describe('Your Finance - Credit All Tests', () => {

    const host = Cypress.env('host.yf') ? Cypress.env('host.yf') : 'localhost';
    const port = 8080;

    it('should reach the summary page', () => {
        cy.request(`http://${host}:${port}/credit/all`).then((resp) => {
            expect(resp.status).to.eq(200)
            const allClients = resp.body.map(account => account.client.name);
            expect(allClients).to.include("Lucy");
            expect(allClients).to.include("Judy");
            expect(allClients).to.include("Mara");
            expect(allClients).to.include("Admin");
            expect(allClients).to.include("Jack Fallout");
            expect(allClients).to.include("Namita");
            expect(allClients).to.include("Jitska");
            expect(allClients).to.include("Malory");
            expect(allClients).to.include("Cindy");
            expect(allClients).to.include("Pietro");
            expect(allClients).to.include("Admin");
            expect(allClients).to.include("Rachelle");
            expect(allClients).to.include("Sandra");
            expect(allClients).to.include("Faustina");
        });
    });
});