package com.example.fromactivitytoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BackActivityP1 extends AppCompatActivity {

    private EditText edtEmail;
    private Button btnBackactivityP1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_p1);
        init();
    }

    private void init(){
        edtEmail = findViewById(R.id.edt_email);
        btnBackactivityP1 = findViewById(R.id.btn_backactivityP1);

        edtEmail.setText(AppUtil.mEmail);

        btnBackactivityP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackActivity();
            }
        });
    }

    private void BackActivity() {
        String strEmail = edtEmail.getText().toString().trim();
        AppUtil.mEmail = strEmail;
        finish();

//        Intent intent = new Intent(BackActivityP1.this,)
    }
}