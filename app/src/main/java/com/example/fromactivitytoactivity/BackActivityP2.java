package com.example.fromactivitytoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BackActivityP2 extends AppCompatActivity {

    private EditText edtEmail;
    private Button btnBackactivityP2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_p2);
        init();
    }

    private void init(){
        edtEmail = findViewById(R.id.edt_email);
        btnBackactivityP2 = findViewById(R.id.btn_backactivityP2);

        edtEmail.setText(getIntent().getStringExtra("key2"));

        btnBackactivityP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackActivity();
            }
        });
    }
    private void BackActivity() {
        String strEmail = edtEmail.getText().toString().trim();
//        AppUtil.mEmail = strEmail;
        Intent returnintent = new Intent();
        returnintent.putExtra("key1",strEmail);
        setResult(Activity.RESULT_OK,returnintent);// Intent Result (lấy lại kết quả từ activity)
//        setResult(Activity.RESULT_OK);
        finish();
        //Một activity có thể được đóng lại thông qua button back trên điện thoại. Trong trường hợp đó, hàm finish() sẽ được thực thi

//        Intent intent = new Intent(BackActivityP1.this,)
    }
}