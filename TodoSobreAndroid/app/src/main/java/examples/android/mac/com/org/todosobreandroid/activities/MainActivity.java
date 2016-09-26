package examples.android.mac.com.org.todosobreandroid.activities;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import examples.android.mac.com.org.todosobreandroid.R;
import examples.android.mac.com.org.todosobreandroid.database.StudentsProvider;
import examples.android.mac.com.org.todosobreandroid.services.GitHubService;

public class MainActivity extends AppCompatActivity{

    public static final String TAG = MainActivity.class.getName();
    public static final int RESULT_LOAD_IMG = 1;
    public static final int REQUEST_CODE = 100;
    public String imgDecodableString;

    Button button1, buttonImage, buttonService, buttonContentProvider, buttonBroadcasReceiver;
    EditText editText1, editText2, editText3;
    ImageView imageView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        button1 = (Button)findViewById(R.id.button1);
//        editText1 = (EditText) findViewById(R.id.editText1);
//        editText2 = (EditText) findViewById(R.id.editText2);
//        editText3 = (EditText) findViewById(R.id.editText3);
//        buttonImage = (Button)findViewById(R.id.buttonImage);
//        imageView1 = (ImageView)findViewById(R.id.imageView1);
//        buttonService = (Button) findViewById(R.id.buttonService);
//        buttonContentProvider = (Button)findViewById(R.id.buttonContentProvider);
//        buttonBroadcasReceiver = (Button)findViewById(R.id.buttonBroadcasReceiver);
//
//        //Send 2 values to another activity and get the result of adding them..
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Bundle bundle = new Bundle();
//
//                bundle.putInt("val1", Integer.valueOf(editText1.getText().toString()));
//                bundle.putInt("val2", Integer.valueOf(editText2.getText().toString()));
//                Intent intent = new Intent(MainActivity.this, SumActivity.class);
//                intent.putExtra("bundleValues", bundle);
////                startActivity(intent);
//                startActivityForResult(intent, 100);
//
//            }
//        });
//
//        buttonImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "Load Image");
//                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
//                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
//            }
//        });
//
//        //Start Service
//        buttonService.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "StartService");
//                startService(new Intent(MainActivity.this, GitHubService.class));
//            }
//        });
//
//        //Start Content Provider
//        buttonContentProvider.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "Content Providers");
//                Intent intent = new Intent(MainActivity.this, ContentProvidersActivity.class);
//
//                startActivity(intent);
//            }
//        });
//
//        //Broadcast Receiver Example
//        buttonBroadcasReceiver.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "Broadcast Receiver");
//                Intent intent = new Intent();
//                intent.setAction("examples.android.mac.com.org.todosobreandroid.receivers.CUSTOM_INTENT");
//                sendBroadcast(intent);
//            }
//        });
//
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent intentResul) {
//        super.onActivityResult(requestCode, resultCode, intentResul);
//        Log.d(TAG, "onActivityResult");
//
//        //Adding Numbers
//        if(resultCode == REQUEST_CODE){
//            Log.d(TAG, "requestCode: " + requestCode);
//            Log.d(TAG, "resultCode: " + resultCode);
//            Bundle bundle = intentResul.getExtras();
//            Log.d(TAG, "intentResul: " + bundle.get("resSum"));
//            editText3.setText(bundle.get("resSum").toString());
//        }
////        if(resultCode == RESULT_LOAD_IMAGE_OK){
//        if(requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK && null != intentResul){
//            Log.d(TAG, "Loading Image");
//            Uri selectedImage = intentResul.getData();
//            String[] filePathColumn = {MediaStore.Images.Media.DATA};
//
//            // Get the cursor
//            Cursor cursor = getContentResolver().query(selectedImage,
//                    filePathColumn, null, null, null);
//            // Move to first row
//            cursor.moveToFirst();
//
//            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//            imgDecodableString = cursor.getString(columnIndex);
//            cursor.close();
//
//            // Set the Image in ImageView after decoding the String
//            imageView1.setImageBitmap(BitmapFactory
//                    .decodeFile(imgDecodableString));
//
//        }




    }
}
