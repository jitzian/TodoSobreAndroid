package examples.android.mac.com.org.todosobreandroid.services;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import examples.android.mac.com.org.todosobreandroid.model.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class GitHubService extends IntentService {

    public static String TAG = GitHubService.class.getName();
    public static String BASE_URL = "https://api.github.com/";
    public static String GITHUB_USER_NAME = "jitzian";

    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "examples.android.mac.com.org.todosobreandroid.action.FOO";
    private static final String ACTION_BAZ = "examples.android.mac.com.org.todosobreandroid.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "examples.android.mac.com.org.todosobreandroid.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "examples.android.mac.com.org.todosobreandroid.extra.PARAM2";
    private DatabaseReference databaseReference;

    public GitHubService() {
        super("Result");
        Log.d(TAG, "Constructor");
        databaseReference = FirebaseDatabase.getInstance().getReference();
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, GitHubService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, GitHubService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent");

        if (intent != null) {

            Retrofit retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


            GitHubRestinterface gitHubRestinterface = retrofit.create(GitHubRestinterface.class);
            Call <ArrayList<Result>> call = gitHubRestinterface.getRepositories(GITHUB_USER_NAME);

            if(call != null){
                Log.d(TAG, "Call NOT NULL: " + call);

                    call.enqueue(new Callback<ArrayList<Result>>() {
                        @Override
                        public void onResponse(Call<ArrayList<Result>> call, Response<ArrayList<Result>> response) {
                            Log.d(TAG, "onResponse");
                            List<Result> lstRes = response.body();
                            for (Result r : lstRes){
                                databaseReference.child("avatar").push().setValue(r.getOwner().getAvatarUrl()).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d(TAG, "Avatar created");

                                    }
                                });
                                Log.d(TAG, "R: " + r.getOwner().getAvatarUrl());
                            }
                            Intent intentBroadcast = new Intent();
                            intentBroadcast.setAction("org.services.firebase.url.load.avatar.ok");
                            sendBroadcast(intentBroadcast);
                            GitHubService.this.stopSelf();
                        }

                        @Override
                        public void onFailure(Call<ArrayList<Result>> call, Throwable t) {
                            Log.d(TAG, t.getMessage());
                        }
                    });
            }else{
                Log.d(TAG, "Call is NULL: ");
            }

        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }


    //Endpoint
    //https://api.github.com/users/jitzian/repos
    public interface GitHubRestinterface{
        @GET("users/{user}/repos")
        Call<ArrayList<Result>> getRepositories(@Path("user") String userName);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Destroying Service");
    }
}
