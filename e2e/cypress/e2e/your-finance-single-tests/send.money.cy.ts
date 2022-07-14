describe('Your Finance - Send Money Tests', () => {
    it('sends random value for all valid users', () => {
        cy.readFile('../your-finance-files/tokenNameValue.csv').then((data) => {
            const lines = data.split("\n");
            lines.forEach(line => {
                const [user, token] = line.split(",")
                if (user) {
                    switch (user) {
                        case "dee":
                        case "ginger":
                        case "sunny":
                            cy.log(`user unauthorized testing for user ${user}`)
                            cy.request({
                                url: "http://localhost:8080/accounts/50",
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
                                url: "http://localhost:8080/accounts/50",
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