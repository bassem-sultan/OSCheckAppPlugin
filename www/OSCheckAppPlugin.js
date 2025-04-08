var exec = require("cordova/exec");

exports.isAppInstalled = function (identifier, success, error) {
  exec(success, error, "OSCheckAppPlugin", "isAppInstalled", [identifier]);
};

exports.openApp = function (identifier, success, error) {
  exec(success, error, "OSCheckAppPlugin", "openApp", [identifier]);
};
