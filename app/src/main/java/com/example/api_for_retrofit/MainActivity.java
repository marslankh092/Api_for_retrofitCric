package com.example.api_for_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private BaseApiService mApiService;
    //https://api.cricapi.com/v1/currentMatches?apikey=acdcba6a-5e79-4d7d-8efc-650c785096e2&offset=0
//https://api.cricapi.com/v1/currentMatches?apikey=acdcba6a-5e79-4d7d-8efc-650c785096e2&offset=1
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mApiService = UtilsAPI.getApiService();

        mApiService.readData("acdcba6a-5e79-4d7d-8efc-650c785096e2","1").enqueue(new Callback<Datum>() {
            @Override
            public void onResponse(Call<Datum> call, Response<Datum> response) {
                response.body();
            }

            @Override
            public void onFailure(Call<Datum> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}