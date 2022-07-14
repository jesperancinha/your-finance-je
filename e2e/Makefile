cypress-open:
	yarn && npm run cypress
cypress-electron:
	yarn && docker-compose -f ../your-finance-images/docker-compose.yaml -f docker-compose.yml up --exit-code-from e2e-electron e2e-electron
cypress-chrome:
	yarn && docker-compose -f ../your-finance-images/docker-compose.yaml -f docker-compose.yml up --exit-code-from e2e-chrome e2e-chrome
cypress-firefox:
	yarn && docker-compose -f ../your-finance-images/docker-compose.yaml -f docker-compose.yml up --exit-code-from e2e-firefox e2e-firefox
cypress-edge:
	yarn && docker-compose -f ../your-finance-images/docker-compose.yaml -f docker-compose.yml up --exit-code-from e2e-edge e2e-edge
