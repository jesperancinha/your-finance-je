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
docker-clean: cleanup-certificates
	docker-compose rm -svf
docker-clean-build-start: docker-clean b docker
docker-delete:
	docker ps -a --format '{{.ID}}' -q --filter="name=your-finance"| xargs -I {}  docker stop {}
	docker ps -a --format '{{.ID}}' -q --filter="name=your-finance"| xargs -I {}  docker rm {}
docker-stop-all:
	docker ps -a --format '{{.ID}}' | xargs -I {}  docker stop {}
	docker network prune
docker-remove-all: docker-stop-all
	docker network list --format '{{.ID}}' | xargs -I {} docker network rm  {} || echo 'Done!'
	docker ps -a --format '{{.ID}}' | xargs -I {}  docker rm {}
yfje-wait:
	bash yfje_wait.sh
dcd:
	docker-compose down
	cd your-finance-images && docker-compose rm -svf
	cd your-finance-images && docker-compose down
	make docker-delete
dcup-full: dcd docker-clean no-test dcup
dcup:
	docker-compose build
	docker-compose up -d
	make yfje-wait
dcup-composed: dcd
	cd your-finance-images && make dcup
	make all-env
cypress-open:
	cd e2e && yarn && npm run cypress:open:electron
cypress-electron:
	cd e2e && make cypress-electron
cypress-chrome:
	cd e2e && make cypress-chrome
cypress-firefox:
	cd e2e && make cypress-firefox
cypress-edge:
	cd e2e && make cypress-edge
cleanup-certificates:
	if [ -d jwtenizr-files ]; then rm -r jwtenizr-files; fi
	if [ -d your-finance-files ]; then rm -r your-finance-files; fi
jwtenizr-setup-certificates:
	bash jwtenizrSetupCertificates.sh
setup-certificates:
	bash setupCertificates.sh
create-users:
	cd your-finance-files && bash createUser.sh
create-accounts:
	cd your-finance-files && bash createAccount.sh
send-money:
	cd your-finance-files && bash sendMoney.sh
ask-credit:
	cd your-finance-files && bash askCredit.sh
demo:
	make dcup-full
	make create-users
	make create-accounts
demo-action: dcup-full-action cypress-open
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
jwtenizr-send-money:
	cd jwtenizr-files && bash sendMoney.sh
jwtenizr-ask-credit:
	cd jwtenizr-files && bash askCredit.sh
dcup-full-action: cleanup-certificates
	if [ -d your-finance-images/yf ]; then rm -r your-finance-images/yf; fi
	if [ -d your-finance-images/jwtenizr ]; then rm -r your-finance-images/jwtenizr; fi
	if [ -d your-financeje-banking/target ]; then rm -r your-financeje-banking/target; fi
	mkdir -p your-finance-images/yf
	mkdir -p your-finance-images/jwtenizr
	make no-test
	cp your-financeje-banking/target/your-financeje-banking.jar your-finance-images/yf/
	cp your-finance-images-template/* your-finance-images/yf/
	if [ -d your-financeje-banking/target ]; then rm -r your-financeje-banking/target; fi
	make jwtenizr-no-test
	cp your-financeje-banking/target/your-financeje-banking.jar your-finance-images/jwtenizr
	cp your-finance-images-template/* your-finance-images/jwtenizr/
	make dcup-composed
all-env: create-users create-accounts jwtenizr-create-users jwtenizr-create-accounts send-money ask-credit jwtenizr-send-money jwtenizr-ask-credit
revert-deps-cypress-update:
	if [ -f  e2e/docker-composetmp.yml ]; then rm e2e/docker-composetmp.yml; fi
	if [ -f  e2e/packagetmp.json ]; then rm e2e/packagetmp.json; fi
	git checkout e2e/docker-compose.yml
	git checkout e2e/package.json
deps-cypress-update:
	curl -sL https://raw.githubusercontent.com/jesperancinha/project-signer/master/cypressUpdateOne.sh | bash
deps-plugins-update:
	curl -sL https://raw.githubusercontent.com/jesperancinha/project-signer/master/pluginUpdatesOne.sh | bash
deps-quick-update: deps-cypress-update deps-plugins-update
