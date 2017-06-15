/**
 * Created by jawedmokhtar on 15/06/2017.
 */
function Page() {

    this.title = 'My Store';
}

Page.prototype.open = function (path) {
    browser.url('/' + path)
}

module.exports = new Page();


