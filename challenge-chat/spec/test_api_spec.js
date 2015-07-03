var request = require("request");

var base_url = "http://localhost:3000/"

describe("http server", function () {
    describe("Get index page", function () {
        it("return the index page with status code 200", function () {
            request.get(base_url, function (error, response, body) {
                expect(response.statusCode).toBe(200);
                done();
            });
        });
    });

});

describe("api get", function () {
    describe("fetch recent page", function () {
        it("return the recent messages with status code 200", function () {
            request.get(base_url + "api/message", function (error, response, body) {
                expect(response.statusCode).toBe(200);
                done();
            });
        });

        it("return the recent messages", function () {
            request.get(base_url + "api/message", function (error, response, body) {
                expect(body).not.toBe(null);
                done();
            });
        });
    });

});


