package com.example.sokomazaoke;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.sokomazaoke.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding registerBinding;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerBinding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(registerBinding.getRoot());

        loadingBar = new ProgressDialog(this);

        registerBinding.registerBuyerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAccount();
            }
        });
    }

    private void createAccount() {
        String name = registerBinding.registerUsernameInput.getText().toString();
        String phone = registerBinding.registerPhoneNumberInput.getText().toString();
        String residence = registerBinding.registerLocation.getText().toString();
        String password = registerBinding.registerPasswordInput.getText().toString();
        String confirmPassword = registerBinding.registerPasswordInputConfirmation.getText().toString();

        if (TextUtils.isEmpty(name))
        {
            Toast.makeText(this, "Please write your name...", Toast.LENGTH_SHORT).show();
            registerBinding.registerUsernameInput.setError(" Your Full Name Required!");
            registerBinding.registerUsernameInput.requestFocus();
        }
        else if (TextUtils.isEmpty(phone))
        {
            Toast.makeText(this, "Please write your phone number...", Toast.LENGTH_SHORT).show();
            registerBinding.registerPhoneNumberInput.setError("Phone Number Required!");
            registerBinding.registerPhoneNumberInput.requestFocus();
        }
        else if (TextUtils.isEmpty(residence))
        {
            Toast.makeText(this, "Please Enter your Residence...", Toast.LENGTH_SHORT).show();
            registerBinding.registerLocation.setError("Residential Location Required!");
            registerBinding.registerLocation.requestFocus();
        }
        else if (TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Please write your password...", Toast.LENGTH_SHORT).show();
            registerBinding.registerPasswordInput.setError("Password Required!");
            registerBinding.registerPasswordInput.requestFocus();
        }
        else if (TextUtils.isEmpty(confirmPassword))
        {
            Toast.makeText(this, "Please confirm your password...", Toast.LENGTH_SHORT).show();
            registerBinding.registerPasswordInputConfirmation.setError("Password Confirmation Required!");
            registerBinding.registerPasswordInputConfirmation.requestFocus();
        }
        else if (!password.equals(confirmPassword))
        {
            Toast.makeText(this, "Please ensure password and confirm password are equal...", Toast.LENGTH_SHORT).show();
            registerBinding.registerPasswordInputConfirmation.setError("Password and Confirm password should match!");
            registerBinding.registerPasswordInputConfirmation.requestFocus();
        }
        else {
            loadingBar.setTitle("Create Account");
            loadingBar.setMessage("Please wait, while we are checking the credentials.");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            ValidatePhoneNumber(name, phone, residence, password);
        }
    }

    private void ValidatePhoneNumber(String name, String phone, String residence, String password) {
    }
}