package examples.android.mac.com.org.todosobreandroid.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by User on 9/24/2016.
 */

public class BaseActivity extends AppCompatActivity{

    private static BaseActivity instance;
    public Context context;

    public BaseActivity(Context context) {
        this.context = context;
    }

    public static synchronized BaseActivity getInstance(){
        return instance;
    }

    public static synchronized BaseActivity getInstance(Context context){
        if(instance == null)
            instance = new BaseActivity(context);
        return instance;
    }

}
