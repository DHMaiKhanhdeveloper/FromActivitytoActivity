package com.example.fromactivitytoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendActivityP1 extends AppCompatActivity {

    private EditText edtEmail;
    private Button btnSendactivityP1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_p1);

        init();
    }
    private void init(){
        edtEmail = findViewById(R.id.edt_email);
        btnSendactivityP1 = findViewById(R.id.btn_sendactivityP1);
        btnSendactivityP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendActivity();
            }
        });
    }
    private void SendActivity() {
        String strEmail = edtEmail.getText().toString().trim();
        AppUtil.mEmail = strEmail;

        Intent intent = new Intent(SendActivityP1.this,BackActivityP1.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        edtEmail.setText(AppUtil.mEmail);
    }
}