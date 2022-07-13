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
no-test:
	mvn clean install -DskipTests
	make setup-certificates
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
setup-certificates:
	bash setupCertificates.sh
create-accounts:
	bash createAccount.sh
create-users:
	bash createUser.sh
send-money:
	bash sendMoney.sh
ask-credit:
	bash askCredit.sh
demo:
	make dcup-full
	make create-accounts
	make create-users
perform-transactions: send-money ask-credit
