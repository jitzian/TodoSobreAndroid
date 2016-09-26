package examples.android.mac.com.org.todosobreandroid.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by User on 9/25/2016.
 */

public class ReceiverComponent extends BroadcastReceiver {
    public static final String TAG = ReceiverComponent.class.getName();
    public static final String ACTION_GENERIC = "examples.android.mac.com.org.todosobreandroid.receivers.CUSTOM_INTENT";
    public static final String ACTION_URL_LOAD_AVATAR_OK = "org.services.firebase.url.load.avatar.ok";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "ACTION: " + intent.getAction().toString());
        if(intent.getAction().equalsIgnoreCase(ACTION_GENERIC)){
            Log.d(TAG, "Custom Intent Detected: " + intent.getAction());
        }else if(intent.getAction().equalsIgnoreCase(ACTION_URL_LOAD_AVATAR_OK)){
            Log.d(TAG, "Firebase Service Intent Detected: " + intent.getAction());

        }

    }


}
