describe('Your Finance - Credit Summary Tests', () => {

    const host = Cypress.env('host.jwtenizr') ? Cypress.env('host.jwtenizr') : 'localhost';
    const port = Cypress.env('host.jwtenizr') ? 8080 : 8081;

    it('should reach the summary page', () => {
        cy.request(`http://${host}:${port}/credit/summary`).then((resp) => {
            expect(resp.status).to.eq(200)
        })
    });
});