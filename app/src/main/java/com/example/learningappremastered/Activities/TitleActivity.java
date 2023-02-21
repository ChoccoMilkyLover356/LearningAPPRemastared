package com.example.learningappremastered.Activities;

import android.content.Intent;
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

import com.example.learningappremastered.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class TitleActivity extends AppCompatActivity {

    EditText editTextEmail, editTextPassword;
    Button btnSignUp,btnLogIn;
    String txtEmail, txtPassword;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
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

    }

    private void SignUpUser() {
        btnSignUp.setVisibility(View.INVISIBLE);

        mAuth.createUserWithEmailAndPassword(txtEmail, txtPassword).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Map<String, Object> user = new HashMap<>();
                user.put("Email", txtEmail);


                db.collection("users")
                        .add(user)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(TitleActivity.this, "Data Stored Successfully !", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(TitleActivity.this, HomeActivity.class);
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
                btnSignUp.setVisibility(View.VISIBLE);
            }
        });

    }
    private void LogInUser() {
        btnLogIn.setVisibility(View.INVISIBLE);

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
                btnSignUp.setVisibility(View.VISIBLE);
            }
        });

    }
}