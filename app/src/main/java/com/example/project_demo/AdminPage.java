package com.example.project_demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminPage extends AppCompatActivity {


    Button btn_add_teacher,btn_see_teacher,btn_add_student,btn_see_student;


    private FirebaseAuth mauth;
    private DatabaseReference mDatabase,mDatabaseStudent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        btn_add_student=findViewById(R.id.btn_add_student);
        btn_add_teacher=findViewById(R.id.btn_add_teacher);
        btn_see_student=findViewById(R.id.btn_see_student);
        btn_see_teacher=findViewById(R.id.btn_see_teacher);

        mauth=FirebaseAuth.getInstance();
        FirebaseUser mUser=mauth.getCurrentUser();
        String uID=mUser.getUid();

        mDatabase= FirebaseDatabase.getInstance().getReference().child("Teacher").child(uID);
        mDatabaseStudent= FirebaseDatabase.getInstance().getReference().child("Student").child(uID);

        btn_add_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialogTeacher();
            }
        });
        btn_add_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialogStudent();
            }
        });
        btn_see_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),SeeTeacher.class);
                startActivity(i);
            }
        });
        btn_see_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),SeeStudents.class);
                startActivity(i);
            }
        });
    }

    public void customDialogTeacher(){
        AlertDialog.Builder myDialog= new AlertDialog.Builder(AdminPage.this);

        LayoutInflater inflater=LayoutInflater.from(AdminPage.this);
        View myView=inflater.inflate(R.layout.add_teacher,null);

        final AlertDialog dialog=myDialog.create();

        dialog.setView(myView);

        final EditText username=myView.findViewById(R.id.username);
        final EditText password=myView.findViewById(R.id.password);
        final EditText latitude=myView.findViewById(R.id.latitude);
        final EditText longitude=myView.findViewById(R.id.longitude);
        final EditText name=myView.findViewById(R.id.name);
        final Button btn_insert=myView.findViewById(R.id.btn_insert);

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString().trim();
                String pass=password.getText().toString().trim();
                String lat=latitude.getText().toString().trim();
                String lon=longitude.getText().toString().trim();
                String name_tchr=name.getText().toString().trim();

                String id=mDatabase.push().getKey();
                Data data=new Data(user,pass,lat,lon,name_tchr,id);

                mDatabase.child(id).setValue(data);

                Toast.makeText(getApplicationContext(),"Data Addded", Toast.LENGTH_SHORT).show();

                dialog.dismiss();




            }
        });
            dialog.show();
    }

    public void customDialogStudent(){
        AlertDialog.Builder myDialog= new AlertDialog.Builder(AdminPage.this);

        LayoutInflater inflater=LayoutInflater.from(AdminPage.this);
        View myView=inflater.inflate(R.layout.add_teacher,null);

        final AlertDialog dialog=myDialog.create();

        dialog.setView(myView);

        final EditText username=myView.findViewById(R.id.username);
        final EditText password=myView.findViewById(R.id.password);
        final EditText latitude=myView.findViewById(R.id.latitude);
        final EditText longitude=myView.findViewById(R.id.longitude);
        final EditText name=myView.findViewById(R.id.name);
        final Button btn_insert=myView.findViewById(R.id.btn_insert);

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString().trim();
                String pass=password.getText().toString().trim();
                String lat=latitude.getText().toString().trim();
                String lon=longitude.getText().toString().trim();
                String name_tchr=name.getText().toString().trim();

                String id=mDatabaseStudent.push().getKey();
                Data data=new Data(user,pass,lat,lon,name_tchr,id);

                mDatabaseStudent.child(id).setValue(data);

                Toast.makeText(getApplicationContext(),"Data Addded", Toast.LENGTH_SHORT).show();

                dialog.dismiss();




            }
        });
        dialog.show();
    }




}
