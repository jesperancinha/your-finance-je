describe('Your Finance - Send Money Tests', () => {

    const host = Cypress.env('host.yf') ? Cypress.env('host.yf') : 'localhost';

    it('should inject 50 to allowed users account', () => {
        cy.readFile('../your-finance-files/tokenNameValue.csv').then((data) => {
            const lines = data.split("\n");
            lines.forEach(line => {
                const [user, token] = line.split(",")
                if (user) {
                    switch (user) {
                        case "jack":
                        case "malory":
                        case "jitska":
                            cy.log(`user unauthorized testing for user ${user}`)
                            cy.request({
                                url: `http://${host}:8080/accounts`,
                                method: "PUT",
                                headers: {
                                    "Authorization": `Bearer ${token}`
                                },
                                followRedirect: false,
                                failOnStatusCode: false,
                                body: {
                                    saldo: 50
                                }
                            }).then((resp) => {
                                expect(resp.status).to.eq(403)
                            });
                            break;
                        default:
                            cy.log(`user authorized testing for user ${user}`)
                            cy.request({
                                method: "PUT",
                                url: `http://${host}:8080/accounts`,
                                headers: {
                                    "Authorization": `Bearer ${token}`
                                },
                                body: {
                                    saldo: 50
                                }
                            });
                    }
                }
            })
        })
    })
})