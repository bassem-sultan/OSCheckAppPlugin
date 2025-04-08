package OS_CheckApp_Plugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class OSCheckAppPlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("isAppInstalled")) {
            String packageName = args.optString(0);
            if (packageName == null || packageName.isEmpty()) {
                callbackContext.error("Package name is missing");
                return true;
            }

            boolean isInstalled = isAppInstalled(packageName);
            callbackContext.success(isAppInstalled ? 1 : 0);
            return true;
        }
        return false;
    }

    private boolean isAppInstalled(string packageName) {
        PackageManager pm = this.cordova.getActivity().getPackageManager();
        try {

            PackageInfo info = pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
