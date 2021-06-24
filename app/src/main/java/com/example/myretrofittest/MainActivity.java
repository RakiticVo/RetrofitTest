package com.example.myretrofittest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myretrofittest.TestAPI_API.APIService;
import com.example.myretrofittest.TestAPI_Model.TestAPIClass;
import com.example.myretrofittest.TestAPI_Model.TestAPI_User;
import com.example.myretrofittest.TestGson.Hobby;
import com.example.myretrofittest.TestGson.Job;
import com.example.myretrofittest.TestGson.User;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText tv_user, tv_id, tv_title, tv_body;
    Button btn_call_api_get, btn_call_api_post;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Job job = new Job(1, "Developer");
        List<Hobby> hobbies = new ArrayList<>();

        hobbies.add(new Hobby(1, "Music"));
        hobbies.add(new Hobby(2, "Play game"));

        User user = new User(1, "Rakitic Võ", true, job, hobbies);

        Gson gson = new Gson();
        String strJson = gson.toJson(user);
        Log.e("JSON", strJson);

        tv_user = findViewById(R.id.tv_user);
        tv_body = findViewById(R.id.tv_body);
        tv_id = findViewById(R.id.tv_id);
        tv_title = findViewById(R.id.tv_title);
        btn_call_api_get = findViewById(R.id.btn_call_api_get);
        btn_call_api_post = findViewById(R.id.btn_call_api_post);
        tv_result = findViewById(R.id.tv_result);

        btn_call_api_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCallAPI2();
            }
        });

        btn_call_api_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCallAPI3();
            }
        });
    }

    private void clickCallAPI1() {
        // Link API : "https://jsonplaceholder.typicode.com/posts?userId=4&id=39"
        // Nhập vào các giá trị có trong đường link API theo từng đối tượng
        APIService.apiService.testGetdata1(4,38, 39)
                .enqueue(new Callback<List<TestAPI_User>>() {
                    @Override
                    public void onResponse(Call<List<TestAPI_User>> call, Response<List<TestAPI_User>> response) {
                        Toast.makeText(MainActivity.this, "Call Success: ", Toast.LENGTH_SHORT).show();
                        List<TestAPI_User> api_user = response.body();
                        if (api_user != null){
                            for (int i = 0; i<api_user.size(); i++){
                                tv_user.setText(tv_user.getText() + "" + api_user.get(i).getUserId());
                                tv_title.setText(tv_title.getText()+""+api_user.get(i).getTitle());
                                tv_id.setText(tv_id.getText()+""+api_user.get(i).getId());
                                tv_body.setText(tv_body.getText()+""+api_user.get(i).getBody());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<TestAPI_User>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Call Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void clickCallAPI2() {
        // Link API : "https://jsonplaceholder.typicode.com/posts?userId=4&id=39"
        // Nhập vào các giá trị có trong đường link API theo từng đối tượng
        APIService.apiService.testGetdata2()
                .enqueue(new Callback<List<TestAPI_User>>() {
                    @Override
                    public void onResponse(Call<List<TestAPI_User>> call, Response<List<TestAPI_User>> response) {
                        Toast.makeText(MainActivity.this, "Call Success: ", Toast.LENGTH_SHORT).show();
                        List<TestAPI_User> api_user = response.body();
                        if (api_user != null){
                            for (int i = 0; i<api_user.size(); i++){
                                tv_user.setText(tv_user.getText() + "" + api_user.get(i).getUserId());
                                tv_title.setText(tv_title.getText()+""+api_user.get(i).getTitle());
                                tv_id.setText(tv_id.getText()+""+api_user.get(i).getId());
                                tv_body.setText(tv_body.getText()+""+api_user.get(i).getBody());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<TestAPI_User>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Call Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();


                    }
                });
    }

    private void clickCallAPI3() {
        TestAPI_User user = new TestAPI_User(10, 101, "new Title", "this is my Test Post Retrofit");
        APIService.apiService.testPostdata1(user).enqueue(new Callback<TestAPI_User>() {
            @Override
            public void onResponse(Call<TestAPI_User> call, Response<TestAPI_User> response) {
                Toast.makeText(MainActivity.this, "Call Success: ", Toast.LENGTH_SHORT).show();

                TestAPI_User api_user = response.body();
                if (api_user != null){
                    tv_result.setText(tv_result.getText() + api_user.toString());
                }
            }

            @Override
            public void onFailure(Call<TestAPI_User> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Call Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}