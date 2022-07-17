describe('Your Finance - Credit Summary Tests', () => {

    const host = Cypress.env('host.yf') ? Cypress.env('host.yf') : 'localhost';
    const port = 8080;

    it('should reach the summary page', () => {
        cy.request(`http://${host}:${port}/credit/summary`).then((resp) => {
            expect(resp.status).to.eq(200);
        });
    });
});