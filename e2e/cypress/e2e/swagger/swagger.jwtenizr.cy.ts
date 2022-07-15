describe('Swagger Tests', () => {

  const host = Cypress.env('host.jwtenizr') ? Cypress.env('host.yf') : 'localhost';
  const port = Cypress.env('host.jwtenizr') ? 8080 : 8081;

  it('shows swagger', () => {
    cy.visit(`http://${host}:${port}/api-specs/ui/?url=http://${host}:${port}/openapi&oauth2RedirectUrl=http://${host}:${port}/api-specs/ui/oauth2-redirect.html#/`);
    cy.get('h2').contains('Generated API').should('not.be.null');
  });
})