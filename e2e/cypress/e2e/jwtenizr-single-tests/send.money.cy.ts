describe('Your Finance - Send Money Tests', () => {

    const host = Cypress.env('host.jwtenizr') ? Cypress.env('host.jwtenizr') : 'localhost';
    const port = Cypress.env('host.jwtenizr') ? 8080 : 8081;

    it('should inject 50 to allowed users account', () => {
        cy.readFile('../jwtenizr-files/tokenNameValue.csv').then((data) => {
            const lines = data.split("\n");
            lines.forEach(line => {
                const [user, token] = line.split(",")
                if (user) {
                    switch (user) {
                        case "jack":
                        case "ginger":
                        case "sunny":
                            cy.log(`user unauthorized testing for user ${user}`)
                            cy.request({
                                url: `http://${host}:${port}/accounts/50`,
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
                                url: `http://${host}:${port}/accounts/50`,
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