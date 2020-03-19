#!/usr/bin/env bash


MICROPROFILE_PROPERTY_FILE=microprofile-config.properties

function getProperty {
   property_key=$1
   property_value=`cat ${MICROPROFILE_PROPERTY_FILE} | grep "$property_key" | cut -d'=' -f2`
   echo ${property_value}
}

curl -L https://github.com/AdamBien/jwtenizr/releases/download/0.0.4/jwtenizr.jar -o jwtenizr.jar

cp jwt-plain-tokens/jwt-token-admin.json jwt-token.json

java -jar jwtenizr.jar

CERT_PUBLIC_KEY=$(getProperty "mp.jwt.verify.publickey")
CERT_ISSUER=$(getProperty "mp.jwt.verify.issuer")

echo -e "\e[96mGenerated public key: \e[0m $CERT_PUBLIC_KEY"
echo -e "\e[96mIssued by: \e[0m $CERT_ISSUER"
echo -e "\e[96mYour token is: \e[0m `cat token.jwt`"

cp your-financeje-banking/src/main/resources/config-template your-financeje-banking/src/main/resources/config_copy.yml


CERT_CLEAN=${CERT_PUBLIC_KEY//"/"/"\/"}

sed "s/{{ publicKey }}/$CERT_CLEAN/g" your-financeje-banking/src/main/resources/config_copy.yml > your-financeje-banking/src/main/resources/config_cert.yml
sed "s/{{ issuer }}/$CERT_ISSUER/g" your-financeje-banking/src/main/resources/config_cert.yml > your-financeje-banking/src/main/resources/config.yml

rm your-financeje-banking/src/main/resources/config_cert.yml
rm your-financeje-banking/src/main/resources/config_copy.yml

echo -e "\e[93mSecurity elements completely generated!\e[0m"

echo -e "\e[93mGenerating Dua Lipa tokens...\e[0m"

TOKEN_FOLDER=jwt-tokens
mkdir -p ${TOKEN_FOLDER}

SEND_MONEY_FILE=sendMoney.sh

echo "#!/usr/bin/env bash" > ${SEND_MONEY_FILE}
chmod +x ${SEND_MONEY_FILE}


for item in jwt-plain-tokens/jwt*.json; do
     if [[ -f "$item" ]]; then
        filename=${item##*/}
        per_token=${filename/jwt-token-/}
        token_name=${per_token/.json/}
        cp ${item} jwt-token.json
        java -jar jwtenizr.jar
        cp token.jwt ${TOKEN_FOLDER}/token-${token_name}.jwt

        token=$(cat token.jwt)
        echo "# Send money to: "${token_name} >> ${SEND_MONEY_FILE}
        echo "echo  -e \"\e[93mSending money to \e[96m${token_name}\e[0m\"" >> ${SEND_MONEY_FILE}
        echo curl -i -H"'Authorization: Bearer "${token}"'" http://localhost:8080/accounts/"\$((1 + RANDOM % 500))" -X PUT >> ${SEND_MONEY_FILE}
        echo "echo  -e \"\e[93m\n---\e[0m\"" >> ${SEND_MONEY_FILE}
      fi
done
