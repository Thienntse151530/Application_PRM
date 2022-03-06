package com.example.projecttimtro.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projecttimtro.R;
import com.example.projecttimtro.models.auth.MessageSignInModel;
import com.example.projecttimtro.models.auth.UserModel;
import com.example.projecttimtro.services.Api_Services;
import com.example.projecttimtro.services.Instance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity implements Instance {

    Button btnSignIn;
    TextView txtAccount;
    TextView txtPassword;
    private void bindingAction(){
        btnSignIn.setOnClickListener(this::onClick);
    }

    private void onClick(View view) {
        UserModel user_model = new UserModel();
        user_model.setAccount(txtAccount.getText().toString());
        user_model.setPassword(txtPassword.getText().toString());
        putAuthSignInUser(user_model);
        getAuthSignInUser();
    }

    private void bindingElement(){
        btnSignIn = findViewById(R.id.btnSignIn);
        txtAccount = findViewById(R.id.txtAccount);
        txtPassword = findViewById(R.id.txtPassword);
    }

    public void putAuthSignInUser(UserModel user_model) {
        Api_Services rest_api = retrofit.create(Api_Services.class);
        rest_api.authUser(user_model)
                .enqueue(new Callback<List<UserModel>>() {

                    @Override
                    public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                        if(response.code() == 200){
                            Log.i("ActionSuccessfully","Put data successfully!!!"+response.toString());
                            //Toast.makeText(SignInActivity.this,"Put data successfully!!!",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<UserModel>> call, Throwable t) {
                        Log.i("ActionFailed","Put data failed!!!"+t.toString());
                        //Toast.makeText(SignInActivity.this,"Put data failed!!!",Toast.LENGTH_LONG).show();
                    }
                });
    }

    public void getAuthSignInUser(){
        Api_Services rest_api = retrofit.create(Api_Services.class);
        rest_api.getToken()
                .enqueue(new Callback<MessageSignInModel>() {
                    @Override
                    public void onResponse(Call<MessageSignInModel> call, Response<MessageSignInModel> response) {
                        MessageSignInModel messageSignInModel = response.body();
                        Log.i("ActionSuccessfully","Get data successfully!!!"+"code:"+messageSignInModel.getCode()+"- Token:"+messageSignInModel.getToken());
                    }

                    @Override
                    public void onFailure(Call<MessageSignInModel> call, Throwable t) {
                        Log.i("ActionFailed","Get data failed!!!"+t.toString());
                    }
                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindingElement();
        bindingAction();
    }
}