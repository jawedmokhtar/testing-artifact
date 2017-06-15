/**
 * Created by jawedmokhtar on 15/06/2017.
 */
'use strict'
var Page = require('./page');
var loginPage = Object.create(Page, {

    loginPageURL:       { value: '?controller=authentication&back=my-account'},
    open:               { value: function () { Page.open.call(this, '?controller=authentication&back=my-account'); } },
    loginLink:          { get: function () { return browser.element('.login') } },
    emailField:         { get: function () { return browser.element('#email'); } },
    passwordField:      { get: function () { return browser.element('#passwd'); } },
    SignInButton:       { get: function () { return browser.element('#SubmitLogin') } },
    clickSignInLink:    { value: function () { this.loginLink.click(); console.log("I was clicked"); }
    },
    fillForm: {
        value: function (emailAddress, password) {
            this.emailField.setValue(emailAddress);
            this.passwordField.setValue(password);
            this.SignInButton.click();
        }
    }
});

module.exports = loginPage;
