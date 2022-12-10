package com.example.fromactivitytoactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendActivityP2 extends AppCompatActivity {

    private static final int REQUEST_CODE = 10 ;

    private EditText edtEmail;
    private Button btnSendactivityP2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_p2);

        init();
    }

    private void init(){
        edtEmail = findViewById(R.id.edt_email);
        btnSendactivityP2 = findViewById(R.id.btn_sendactivityP2);
        btnSendactivityP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendActivityP2();
            }
        });
    }

    private void SendActivityP2() {
        String strEmail = edtEmail.getText().toString().trim();
//        AppUtil.mEmail = strEmail;

        Intent intent = new Intent(SendActivityP2.this,BackActivityP2.class);
        intent.putExtra("key2", strEmail);
        startActivityForResult(intent,REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(REQUEST_CODE == requestCode && resultCode==Activity.RESULT_OK) {
            edtEmail.setText(data.getStringExtra("key1"));
        }
    }
    //    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if(REQUEST_CODE == requestCode && resultCode==Activity.RESULT_OK) {
//            edtEmail.setText(getIntent().getStringExtra("key1"));
//        }
//    }

//    @Override
//    protected void onResume() {
//        super.onResume();
////        edtEmail.setText(AppUtil.mEmail);
//    }
}