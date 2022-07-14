b: build-maven
build:
	mvn clean install
build-maven:
	mvn clean install -DskipTests
test:
	mvn test
test-maven:
	mvn test
local: no-test
	mkdir -p bin
no-test: build-maven
	make setup-certificates
	make build-maven
docker:
	docker-compose rm -svf
	docker-compose up -d --build --remove-orphans
docker-clean:
	docker-compose rm -svf
docker-clean-build-start: docker-clean b docker
yfje-wait:
	bash yfje_wait.sh
dcd:
	docker-compose down
dcup-full: dcd docker-clean no-test
	docker-compose build
	docker-compose up -d
	make yfje-wait
cypress-open:
	cd e2e && yarn && npm run cypress
cypress-electron:
	cd e2e && make cypress-electron
cypress-chrome:
	cd e2e && make cypress-chrome
cypress-firefox:
	cd e2e && make cypress-firefox
cypress-edge:
	cd e2e && make cypress-edge
cleanup-certificates:
	rm -rf jwtenizr-files
	rm -rf your-finance-files
jwtenizr-setup-certificates: cleanup-certificates
	bash jwtenizrSetupCertificates.sh
setup-certificates: cleanup-certificates
	bash setupCertificates.sh
create-users:
	cd your-finance-files && bash createUser.sh
create-accounts:
	cd your-finance-files && bash createAccount.sh
send-money:
	cd your-finance-files && bash sendMoney.sh
ask-credit:
	dc your-finance-files && bash askCredit.sh
demo:
	make dcup-full
	make create-users
	make create-accounts
perform-transactions: send-money ask-credit
jwtenizr-old-file-cleanup:
	rm askCredit.sh &
	rm createAccount.sh &
	rm createUser.sh &
	rm jwt-token.json &
	rm jwtenizr.jar &
	rm jwtenizr-config.json &
	rm logs &
	rm microprofile-config.properties &
	rm sendMoney.sh &
	rm token.jwt &
	rm your-financeje-banking/src/main/resources/config.yml &
	rm -r jwt-tokens &
jwtenizr-no-test: build-maven
	make jwtenizr-setup-certificates
	make build-maven
jwtenizr-demo:
	make jwtenizr-dcup-full
	make jwtenizr-create-users
	make jwtenizr-create-accounts
jwtenizr-dcup-full: dcd docker-clean jwtenizr-no-test
	docker-compose build
	docker-compose up -d
	make yfje-wait
jwtenizr-create-users:
	cd jwtenizr-files && bash createUser.sh
jwtenizr-create-accounts:
	cd jwtenizr-files && bash createAccount.sh
dcup-full-action:
	rm -rf your-finance-images/yf
	rm -rf your-finance-images/jwtenizr
	mkdir -p your-finance-images/yf
	mkdir -p your-finance-images/jwtenizr
	make no-test
	cp your-financeje-banking/target/your-financeje-banking.jar your-finance-images/yf/
	cp your-finance-images-template/* your-finance-images/yf/
	make jwtenizr-no-test
	cp your-financeje-banking/target/your-financeje-banking.jar your-finance-images/jwtenizr
	cp your-finance-images-template/* your-finance-images/jwtenizr/
	cd your-finance-images && docker-compose rm -svf
	cd your-finance-images && docker-compose down
	cd your-finance-images && docker-compose up -d
	cd your-finance-images && bash yfje_wait.sh
