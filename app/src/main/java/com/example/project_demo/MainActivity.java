package com.example.project_demo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    EditText uname,pass;
    Button btn_login;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        mAuth=FirebaseAuth.getInstance();


    }

    public void init(){
        uname=findViewById(R.id.uname);
        pass=findViewById(R.id.pass);
        btn_login=findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logIn();
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currrentUSer=mAuth.getCurrentUser();
        //method call
    }



    public void logIn(){

        FirebaseUser mUser=mAuth.getCurrentUser();
        String uID=mUser.getUid();
         final String email=uname.getText().toString().trim();
         final String passw=pass.getText().toString().trim();

        if(email.equals("rajgauravraj97@gmail.com")){
            mAuth.signInWithEmailAndPassword(email,passw).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        FirebaseUser user=mAuth.getCurrentUser();
                        //method call
                        Intent i=new Intent(MainActivity.this,AdminPage.class);
                        startActivity(i);
                        finish();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Invalid username or password",Toast.LENGTH_SHORT).show();
                        //method call

                    }
                }
            });
        }
        else if(Pattern.compile("TID.*").matcher(email).matches()){
            //teacher page

            mDatabase= FirebaseDatabase.getInstance().getReference().child("Teacher").child(uID);
            mDatabase.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    String username=dataSnapshot.child("username").getValue(String.class);
                    String password=dataSnapshot.child("password").getValue(String.class);
                    if(email.equals(username) && passw.equals(password)){


                        Intent i=new Intent(getApplicationContext(),Teacher.class);
                        startActivity(i);

                    }




                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });






        }
        else if(Pattern.compile("SID.*").matcher(email).matches()){
            //student page

            mDatabase= FirebaseDatabase.getInstance().getReference().child("Student").child(uID);
            mDatabase.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    String username=dataSnapshot.child("username").getValue(String.class);
                    String password=dataSnapshot.child("password").getValue(String.class);
                    if(email.equals(username) && passw.equals(password)){

                        Intent i=new Intent(getApplicationContext(),Student.class);
                        startActivity(i);
                    }



                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }




    }



}
