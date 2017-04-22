package rookiescode.android_login_mvp_master;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements LoginView {


    // UI references.
    private EditText etEmail;
    private EditText etPassword;
    private Button btLogin;

    private View mProgressView;
    private View mLoginFormView;

    String email, password;

    private LoginPresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initPresenter();

        initView();
        login();


    }
    private void initPresenter() {
        mPresenter = new LoginPresenterImpl(this);
    }

    private void initView() {
        // Set up the login form.
        etEmail = (EditText) findViewById(R.id.et_login_email);
        etPassword = (EditText) findViewById(R.id.et_login_password);
        btLogin = (Button) findViewById(R.id.bt_login);

        mLoginFormView = findViewById(R.id.scroll_login_form);
        mProgressView = findViewById(R.id.pb_login_progress);

    }
    private void login() {
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.login(getEmail(), getPassword());
            }
        });
    }

    @Override
    public String getEmail() {
        email = etEmail.getText().toString();

        return email;
    }

    @Override
    public String getPassword() {
        password = etPassword.getText().toString();

        return password;
    }

    @Override
    public boolean validation() {
        boolean valid = true;
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError(getText(R.string.error_invalid_email));
            valid = false;
        }
        if (password.isEmpty()) {
            etPassword.setError(getText(R.string.error_invalid_password));
            valid = false;
        }
        return valid;
    }

    @Override
    public void successLogin() {
        Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void errorLogin() {
        Toast.makeText(this, "Login Error", Toast.LENGTH_SHORT).show();

    }


}

