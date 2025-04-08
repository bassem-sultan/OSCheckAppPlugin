import Foundation
import UIKit

@objc(OSCheckAppPlugin) class OSCheckAppPlugin: CDVPlugin {
 @objc(checkAppInstalled:)
 func checkAppInstalled(command: CDVInvokedUrlCommand) {
   guard let scheme = command.arguments[0] as? String,
         let url = URL(string: "\(scheme)://") else {
     self.commandDelegate.send(CDVPluginResult(status: .error), callbackId: command.callbackId)
     return
   }
   let canOpen = UIApplication.shared.isAppInstalled(url)
   let result = CDVPluginResult(status: .ok, messageAs: canOpen ? 1 : 0)
   self.commandDelegate.send(result, callbackId: command.callbackId)
 }

 @objc(openApp:)
 func openApp(command: CDVInvokedUrlCommand) {
   guard let scheme = command.arguments[0] as? String,
         let url = URL(string: "\(scheme)://"),
         UIApplication.shared.isAppInstalled(url) else {
     self.commandDelegate.send(CDVPluginResult(status: .error, messageAs: "App not found"), callbackId: command.callbackId)
     return
   }

   UIApplication.shared.open(url, options: [:]) { success in
     let result = CDVPluginResult(status: .ok, messageAs: "Opened app")
     self.commandDelegate.send(result, callbackId: command.callbackId)
   }
 }
}
