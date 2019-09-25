package com.example.project_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Student extends AppCompatActivity {

    TextView stu_id,stu_name;
    EditText coupoun;
    Button btn_attendance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        stu_id=findViewById(R.id.stu_id);
        stu_name=findViewById(R.id.stu_name);
        coupoun=findViewById(R.id.coupoun);
        btn_attendance=findViewById(R.id.btn_attendance);

    }
}
