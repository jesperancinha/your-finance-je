describe('Your Finance - Account Summary Tests', () => {

    const host = Cypress.env('host.yf') ? Cypress.env('host.yf') : 'localhost';
    const port = 8080;

    it('should reach the all data page', () => {
        cy.request(`http://${host}:${port}/accounts/all`).then((resp) => {
            expect(resp.status).to.eq(200)
        })
    });
});