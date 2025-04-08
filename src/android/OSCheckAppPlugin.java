package OS.Plugin.CheckApp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;

import org.apache.cordova.*;

import org.json.JSONArray;
import java.util.List;

/**
 * This class echoes a string called from JavaScript.
 */
public class OSCheckAppPlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
            if (action.equals("isAppInstalled")) {
                String packageName = args.optString(0);
                if (packageName == null || packageName.isEmpty()) {
                    callbackContext.error("Package name is missing");
                    return true;
                }
                Intent intent = this.cordova.getActivity().getPackageManager().getLaunchIntentForPackage(packageName);
                callbackContext.success(intent != null ? 1 : 0);
                return true;
            } else if (action.equals("openApp")) {
                String packageName = args.optString(0);
                if (packageName == null || packageName.isEmpty()) {
                    callbackContext.error("Package name is missing");
                    return true;
                }
                Intent intent = this.cordova.getActivity().getPackageManager().getLaunchIntentForPackage(packageName);
                if (intent != null) {
                    cordova.getActivity().startActivity(intent);
                    callbackContext.success("Oppened App");
                } else {
                    callbackContext.error("App not found");
                }
                return true;
            }
        } catch (Exception e) {
            callbackContext.error("error: " + e.getMessage());
        }

        return false;
    }

    private boolean isAppInstalled(string packageName) {

    }
}
