describe('Your Finance - Send Money Tests', () => {

    const host = Cypress.env('host.yf') ? Cypress.env('host.yf') : 'localhost';
    const port = Cypress.env('host.jwtenizr') ? 8080 : 8081;

    it('should reach the summary page', () => {
        cy.request(`http://${host}:${port}/accounts/summary`)
    });
});