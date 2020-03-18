#!/usr/bin/env bash


MICROPROFILE_PROPERTY_FILE=microprofile-config.properties

function getProperty {
   PROP_KEY=$1
   PROP_VALUE=`cat $MICROPROFILE_PROPERTY_FILE | grep "$PROP_KEY" | cut -d'=' -f2`
   echo $PROP_VALUE
}

curl -L https://github.com/AdamBien/jwtenizr/releases/download/0.0.4/jwtenizr.jar -o jwtenizr.jar

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


