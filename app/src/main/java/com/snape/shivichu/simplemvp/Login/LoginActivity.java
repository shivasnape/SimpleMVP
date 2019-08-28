package com.snape.shivichu.simplemvp.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.snape.shivichu.simplemvp.Home.HomeActivity;
import com.snape.shivichu.simplemvp.R;
import com.snape.shivichu.simplemvp.activity.MainActivity;


public class LoginActivity extends AppCompatActivity implements LoginView {

    private ProgressBar progressBar;
    private EditText mUsername;
    private EditText mPassword;
    private Button mLogin;
    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = findViewById(R.id.progress);
        mUsername = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);
        mLogin = findViewById(R.id.button);

        mPresenter = new LoginPresenter(this, new LoginInteractor());

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validateCredentials();

            }
        });

    }

    @Override
    protected void onDestroy() {
        mPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        mUsername.setError("Invalid User Name");
    }

    @Override
    public void setPasswordError() {
        mPassword.setError("Invalid password");
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    private void validateCredentials() {
        mPresenter.validateCredentials(mUsername.getText().toString(), mPassword.getText().toString());
    }
}
