package com.example.learningappremastered.Activities;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.learningappremastered.Classes.ModelClass;
import com.example.learningappremastered.Classes.User;
import com.example.learningappremastered.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TitleActivity extends AppCompatActivity {

    EditText editTextEmail, editTextPassword;
    Button btnSignUp,btnLogIn;
    String txtEmail, txtPassword;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    Map<String,Integer> gameStats;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnLogIn= findViewById(R.id.btnLogIn);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        // Initialize Firebase Firestore
        db = FirebaseFirestore.getInstance();


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer click = MediaPlayer.create(TitleActivity.this, R.raw.click);
                click.start();
                txtEmail = editTextEmail.getText().toString().trim();
                txtPassword = editTextPassword.getText().toString().trim();

                    if (!TextUtils.isEmpty(txtEmail)) {
                        if (txtEmail.matches(emailPattern)) {
                                    if (!TextUtils.isEmpty(txtPassword)) {
                                                SignUpUser();
                                    } else {
                                        editTextPassword.setError("Password Field can't be empty");
                                    }
                        } else {
                            editTextEmail.setError("Enter a valid Email Address");
                        }
                    } else {
                        editTextEmail.setError("Email Field can't be empty");
                    }
            }
        });
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer click = MediaPlayer.create(TitleActivity.this, R.raw.click);
                click.start();
                txtEmail = editTextEmail.getText().toString().trim();
                txtPassword = editTextPassword.getText().toString().trim();

                if (!TextUtils.isEmpty(txtEmail)) {
                    if (txtEmail.matches(emailPattern)) {
                        if (!TextUtils.isEmpty(txtPassword)) {
                            LogInUser();
                        } else {
                            editTextPassword.setError("Password Field can't be empty");
                        }
                    } else {
                        editTextEmail.setError("Enter a valid Email Address");
                    }
                } else {
                    editTextEmail.setError("Email Field can't be empty");
                }
            }
        });

        final MediaPlayer click = MediaPlayer.create(this, R.raw.click);
        click.start();

    }

    private void SignUpUser() {

        btnSignUp.setVisibility(View.INVISIBLE); //so that the user doesn't click it again, breaking the program

        mAuth.createUserWithEmailAndPassword(txtEmail, txtPassword).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Map<String, Map<String,Integer>> user = new HashMap<>(); // Creating empty game data
                gameStats = new HashMap<>();
                gameStats.put("Color Find Score",0);
                gameStats.put("Color Find Time",0);
                gameStats.put("Math Quiz Score",0);
                gameStats.put("Math Quiz Time",0);
                gameStats.put("Story Score",0);
                gameStats.put("Story Time",0);

                user.put("GameStats",gameStats);
                User createdUser = new User(txtEmail, user, txtEmail.substring(0, (txtEmail.indexOf('@')))); // Created the empty game data


                db.collection("users").document(txtEmail.substring(0, (txtEmail.indexOf('@'))))
                        .set(createdUser) //Stores the User's empty data for later
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(TitleActivity.this, "Data Stored Successfully !", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(TitleActivity.this, HomeActivity.class); //taking the user to home page
                                startActivity(intent);
                                finish();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(TitleActivity.this, "Error - " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(TitleActivity.this, "Error " + e.getMessage(), Toast.LENGTH_SHORT).show();
                btnSignUp.setVisibility(View.VISIBLE); // so that the user can press it again once they fix the problem
            }
        });

    }
    private void LogInUser() {
        btnLogIn.setVisibility(View.INVISIBLE);

        // VVVV Login the user VVVV
        mAuth.signInWithEmailAndPassword(txtEmail, txtPassword).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(TitleActivity.this, "User Logged In Successfully !", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TitleActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(TitleActivity.this, "Error " + e.getMessage(), Toast.LENGTH_SHORT).show();
                btnLogIn.setVisibility(View.VISIBLE);
            }
        });

    }
}