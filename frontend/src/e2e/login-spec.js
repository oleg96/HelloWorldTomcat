describe('Login page', () => {
    it('Test administrator login', () => {
        browser.get('http://localhost:3000/#/login');
        let username = element(by.id('username'));
        let password = element(by.id('password'));
        let loginButton = element(by.id('loginButton'));
        username.sendKeys("Admin");
        password.sendKeys("123");
        loginButton.click();
        expect(browser.getCurrentUrl()).toEqual('http://localhost:3000/#/');
    });
});