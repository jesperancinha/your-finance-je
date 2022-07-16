describe('Your Finance - Send Money Tests', () => {

    const host = Cypress.env('host.yf') ? Cypress.env('host.yf') : 'localhost';

    it('should ask 10 credit in cash from allowed users', () => {
        cy.readFile('../your-finance-files/tokenNameValue.csv').then((data) => {
            const lines = data.split("\n");
            lines.forEach(line => {
                const [user, token] = line.split(",")
                if (user) {
                    switch (user) {
                        case "jack":
                        case "ginger":
                        case "sunny":
                        case "upset":
                            cy.log(`user unauthorized testing for user ${user}`)
                            cy.request({
                                url: `http://${host}:8080/credit/10`,
                                method: "PUT",
                                headers: {
                                    "Authorization": `Bearer ${token}`
                                },
                                followRedirect: false,
                                failOnStatusCode: false
                            }).then((resp) => {
                                expect(resp.status).to.eq(403)
                            });
                            break;
                        default:
                            cy.log(`user authorized testing for user ${user}`)
                            cy.request({
                                method: "PUT",
                                url: `http://${host}:8080/credit/10`,
                                headers: {
                                    "Authorization": `Bearer ${token}`
                                }
                            });
                    }
                }
            })
        })
    })
})