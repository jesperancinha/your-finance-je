describe('Your Finance - Send Money Tests', () => {

    const host = Cypress.env('host.jwtenizr') ? Cypress.env('host.jwtenizr') : 'localhost';
    const port = Cypress.env('host.jwtenizr') ? 8080 : 8081;

    it('should ask 10 credit in cash from allowed users', () => {
        cy.readFile('../jwtenizr-files/tokenNameValue.csv').then((data) => {
            const lines = data.split("\n");
            lines.forEach(line => {
                const [user, token] = line.split(",")
                if (user) {
                    switch (user) {
                        case "jack":
                        case "malory":
                        case "jitska":
                        case "shikka":
                            cy.log(`user unauthorized testing for user ${user}`)
                            cy.request({
                                url: `http://${host}:${port}/credit`,
                                method: "PUT",
                                headers: {
                                    "Authorization": `Bearer ${token}`,
                                    "Content-Type": "application/json"
                                },
                                followRedirect: false,
                                failOnStatusCode: false,
                                body: {
                                    saldo: 10
                                }
                            }).then((resp) => {
                                expect(resp.status).to.eq(403)
                            });
                            break;
                        default:
                            cy.log(`user authorized testing for user ${user}`)
                            cy.request({
                                method: "PUT",
                                url: `http://${host}:${port}/credit`,
                                headers: {
                                    "Authorization": `Bearer ${token}`,
                                    "Content-Type": "application/json"
                                },
                                body: {
                                    saldo: 10
                                }
                            });
                    }
                }
            })
        })
    })
})