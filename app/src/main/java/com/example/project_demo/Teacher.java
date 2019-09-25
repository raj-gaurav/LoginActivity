package com.example.project_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Teacher extends AppCompatActivity {

    TextView t_id,t_name,code;
    Button btn_generate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        t_id=findViewById(R.id.t_id);
        t_name=findViewById(R.id.t_name);
        code=findViewById(R.id.code);
        btn_generate=findViewById(R.id.btn_generate);

    }
}
