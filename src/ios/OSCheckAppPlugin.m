/********* OSCheckAppPlugin.m Cordova Plugin Implementation *******/

#import <Cordova/CDV.h>

@interface OSCheckAppPlugin : CDVPlugin {
  // Member variables go here.
}

- (void)isAppInstalled:(CDVInvokedUrlCommand*)command;
@end

@implementation OSCheckAppPlugin

- (void)isAppInstalled:(CDVInvokedUrlCommand*)command
{
    NSString* urlScheme = [command.arguments objectAtIndex:0];

    if([[UIApplication sharedApplication] canOpenUrl:[NSURL URLWithString:urlScheme]]){
        CDVPluginResult* pluginResult = [CDVPluginResult CDVPluginResult: CDVCommandStatus_OK messageAsInt: 1];
        [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
    }else{
        CDVPluginResult* pluginResult = [CDVPluginResult CDVPluginResult: CDVCommandStatus_OK messageAsInt: 0];
        [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
    }
}

@end
