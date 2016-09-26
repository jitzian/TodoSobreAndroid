package examples.android.mac.com.org.todosobreandroid.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import examples.android.mac.com.org.todosobreandroid.R;

public class SumActivity extends AppCompatActivity{
    public static final String TAG = SumActivity.class.getName();
    TextView textViewSumRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum);

        textViewSumRes = (TextView) findViewById(R.id.textViewSumRes);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundleValues");

        if(bundle != null){
            Log.d(TAG, "Bundle Not Null");
            int val1 = bundle.getInt("val1");
            int val2 = bundle.getInt("val2");
            int resSum = val1+val2;
            Intent intentResul = new Intent();
            intentResul.putExtra("resSum", resSum);
            setResult(100, intentResul);
            finish();

        }else{
            Log.d(TAG, "Bundle is Null");
            finish();
        }
    }
}
