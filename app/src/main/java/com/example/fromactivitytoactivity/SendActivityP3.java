package com.example.fromactivitytoactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendActivityP3 extends AppCompatActivity {


    private static final int REQUEST_CODE = 10 ;

    private EditText edtEmail,edtPassword;
    private Button btnSendactivityP3;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_p3);

        init();
    }
    private void init(){
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        btnSendactivityP3 = findViewById(R.id.btn_sendactivityP3);
        btnSendactivityP3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendActivityP3();
            }
        });
    }

    private void SendActivityP3() {
        String strEmail = edtEmail.getText().toString().trim();
        String strPassword = edtPassword.getText().toString().trim();
//        AppUtil.mEmail = strEmail;
        user = new User(strEmail, strPassword);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_key", user);
        Intent intent = new Intent(SendActivityP3.this,BackActivityP3.class);
        intent.putExtras(bundle);
        startActivityForResult(intent,REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(REQUEST_CODE == requestCode && resultCode== Activity.RESULT_OK) {
//            edtEmail.setText(data.getStringExtra("key1"));
            user = (User) data.getExtras().get("object_key");
            edtEmail.setText(user.getUsername());
            edtPassword.setText(user.getPassword());
        }
    }
}