package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText userSign = (EditText) findViewById(R.id.userSign);
        EditText passSign = (EditText) findViewById(R.id.passSign);

        Button signup = (Button) findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance();
                ref = database.getReference("Accounts");

                String username = userSign.getText().toString();
                String password = passSign.getText().toString();

                Account acc = new Account(username, password);
                ref.child(username).setValue(acc);

                Toast.makeText(MainActivity.this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);

            }
        });

    }
}