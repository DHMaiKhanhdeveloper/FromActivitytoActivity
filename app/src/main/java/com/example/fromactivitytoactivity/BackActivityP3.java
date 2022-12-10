package com.example.fromactivitytoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BackActivityP3 extends AppCompatActivity {


    private EditText edtEmail,edtPassword;
    private Button btnBackactivityP3;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_p3);

        init();
    }

    private void init(){
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        btnBackactivityP3 = findViewById(R.id.btn_backactivityP3);
        if(getIntent().getExtras() != null){
            user = (User) getIntent().getExtras().get("object_key");
            edtEmail.setText(user.getUsername());
            edtPassword.setText(user.getPassword());
        }

        btnBackactivityP3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackActivity();
            }
        });
    }
    private void BackActivity() {
        String strEmail = edtEmail.getText().toString().trim();
        String strPassword = edtPassword.getText().toString().trim();
//        AppUtil.mEmail = strEmail;


        user = new User(strEmail, strPassword);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_key", user);
        Intent returnintent = new Intent();
        returnintent.putExtras(bundle);
        setResult(Activity.RESULT_OK,returnintent);
//        setResult(Activity.RESULT_OK);
        finish();


    }
}