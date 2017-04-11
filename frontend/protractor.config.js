exports.config = {
    framework: 'jasmine',
    seleniumAddress: 'http://localhost:4444/wd/hub',
    specs: ['./src/e2e/login-spec.js'],
    capabilities: {
        browserName: 'chrome'
    }
}