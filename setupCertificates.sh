#!/bin/bash

mkdir -p your-finance-files

cd your-finance-files || exit

openssl genrsa -out baseKey.pem

openssl pkcs8 -topk8 -inform PEM -in baseKey.pem -out privateKey.pem -nocrypt

openssl rsa -in baseKey.pem -pubout -outform PEM -out publicKey.pem

echo -e '\033[1;32mFirst test\033[0m'
java -jar ../your-finance-jwt-generator/target/your-finance-jwt-generator.jar \
        -p ../jwt-plain-tokens/jwt-token-admin.json \
        -key ../your-finance-files/privateKey.pem >> token.jwt

CERT_PUBLIC_KEY=$(cat ../your-finance-files/publicKey.pem)
CERT_ISSUER="joaofilipesabinoesperancinha"

echo -e "\e[96mGenerated public key: \e[0m $CERT_PUBLIC_KEY"
echo -e "\e[96mIssued by: \e[0m $CERT_ISSUER"
echo -e "\e[96mYour token is: \e[0m $(cat token.jwt)"

cp ../your-financeje-banking/src/main/resources/config-template ../your-financeje-banking/src/main/resources/config_copy.yml

CERT_CLEAN0=${CERT_PUBLIC_KEY//"/"/"\/"}
CERT_CLEAN1=${CERT_CLEAN0//$'\r\n'/}
CERT_CLEAN2=${CERT_CLEAN1//$'\n'/}
CERT_CLEAN3=$(echo "$CERT_CLEAN2" | awk '{gsub("-----BEGIN PUBLIC KEY-----",""); print}')
CERT_CLEAN4=$(echo "$CERT_CLEAN3" | awk '{gsub("-----END PUBLIC KEY-----",""); print}')
CERT_CLEAN=${CERT_CLEAN4//$' '/}

echo -e "\e[96mCertificate cleanup: \e[0m ${CERT_CLEAN/$'\n'/}"

sed "s/{{ publicKey }}/$CERT_CLEAN/g" ../your-financeje-banking/src/main/resources/config_copy.yml > ../your-financeje-banking/src/main/resources/config_cert.yml
sed "s/{{ issuer }}/$CERT_ISSUER/g" ../your-financeje-banking/src/main/resources/config_cert.yml > ../your-financeje-banking/src/main/resources/config.yml

rm ../your-financeje-banking/src/main/resources/config_cert.yml
rm ../your-financeje-banking/src/main/resources/config_copy.yml

echo -e "\e[93mSecurity elements completely generated!\e[0m"

echo -e "\e[93mGenerating tokens...\e[0m"

TOKEN_FOLDER=jwt-tokens
mkdir -p ${TOKEN_FOLDER}
#
CREATE_ACCOUNT_FILE=createAccount.sh
CREATE_USER_FILE=createUser.sh
SEND_MONEY_FILE=sendMoney.sh
ASK_CREDIT_FILE=askCredit.sh
TOKEN_NAME_VALUE=tokenNameValue.csv

echo "#!/usr/bin/env bash" > ${CREATE_ACCOUNT_FILE}
chmod +x ${CREATE_ACCOUNT_FILE}
echo "#!/usr/bin/env bash" > ${CREATE_USER_FILE}
chmod +x ${CREATE_USER_FILE}
echo "#!/usr/bin/env bash" > ${SEND_MONEY_FILE}
chmod +x ${SEND_MONEY_FILE}
echo "#!/usr/bin/env bash" > ${ASK_CREDIT_FILE}
chmod +x ${ASK_CREDIT_FILE}

for item in ../jwt-plain-tokens/jwt-token*.json; do
     if [[ -f "$item" ]]; then
        filename=${item##*/}
        per_token=${filename/jwt-token-/}
        token_name=${per_token/.json/}
        cp "${item}" jwt-token.json
        java -jar ../your-finance-jwt-generator/target/your-finance-jwt-generator.jar \
                -p jwt-token.json \
                -key ../your-finance-files/privateKey.pem > token.jwt
        cp token.jwt ${TOKEN_FOLDER}/token-"${token_name}".jwt

        token=$(cat token.jwt)

        echo "# Create account: ""${token_name}" >> ${CREATE_ACCOUNT_FILE}
        echo "echo  -e \"\e[93mCreating account \e[96m${token_name}\e[0m\"" >> ${CREATE_ACCOUNT_FILE}
        echo curl -i -H"'Authorization: Bearer ""${token}""'" http://localhost:8080/accounts -X POST >> ${CREATE_ACCOUNT_FILE}
        echo "echo  -e \"\e[93m\n---\e[0m\"" >> ${CREATE_ACCOUNT_FILE}

        echo "# Create user: ""${token_name}" >> ${CREATE_USER_FILE}
        echo "echo  -e \"\e[93mCreating user \e[96m${token_name}\e[0m\"" >> ${CREATE_USER_FILE}
        echo curl -i -H"'Authorization: Bearer ""${token}""'" http://localhost:8080/accounts/user -X POST >> ${CREATE_USER_FILE}
        echo "echo  -e \"\e[93m\n---\e[0m\"" >> ${CREATE_USER_FILE}

        echo "# Send money to: "${token_name} >> ${SEND_MONEY_FILE}
        echo "echo  -e \"\e[93mSending money to \e[96m${token_name}\e[0m\"" >> ${SEND_MONEY_FILE}
        echo curl -i -H"'Authorization: Bearer ""${token}""'" http://localhost:8080/accounts/"\$((1 + RANDOM % 500))" -X PUT >> ${SEND_MONEY_FILE}
        echo "echo  -e \"\e[93m\n---\e[0m\"" >> ${SEND_MONEY_FILE}

        echo "# Asking money credit to: "${token_name} >> ${ASK_CREDIT_FILE}
        echo "echo  -e \"\e[93mAsking credit from \e[96m${token_name}\e[0m\"" >> ${ASK_CREDIT_FILE}
        echo curl -i -H"'Authorization: Bearer ""${token}""'" http://localhost:8080/credit/"\$((1 + RANDOM % 500))" -X PUT >> ${ASK_CREDIT_FILE}
        echo "echo  -e \"\e[93m\n---\e[0m\"" >> ${ASK_CREDIT_FILE}

        echo "${token_name},${token}" >> ${TOKEN_NAME_VALUE}
      fi
done
