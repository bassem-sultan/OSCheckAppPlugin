var exec = require("cordova/exec");

exports.isAppInstalled = function (identifier, success, error) {
  exec(success, error, "OSCheckAppPlugin", "isAppInstalled", [identifier]);
};
