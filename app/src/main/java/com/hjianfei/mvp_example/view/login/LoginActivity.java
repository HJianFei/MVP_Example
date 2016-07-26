package com.hjianfei.mvp_example.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.hjianfei.mvp_example.R;
import com.hjianfei.mvp_example.presenter.login.LoginPresenter;
import com.hjianfei.mvp_example.presenter.login.LoginPresenterImpl;
import com.hjianfei.mvp_example.view.mian.MainActivity;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private EditText ed_name, ed_password;
    private Button btn_login;
    private ProgressBar progressBar;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed_name = (EditText) findViewById(R.id.username);
        ed_password = (EditText) findViewById(R.id.password);
        btn_login = (Button) findViewById(R.id.button);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        btn_login.setOnClickListener(this);
        presenter = new LoginPresenterImpl(this);

    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
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
    public void setUserNameError() {
        ed_name.setError("用户名不能为空");

    }

    @Override
    public void setPasswordError() {
        ed_password.setError("密码不能为空");

    }

    @Override
    public void navicateToHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void onClick(View v) {
        presenter.validateCredentials(ed_name.getText().toString(), ed_password.getText().toString());

    }
}
