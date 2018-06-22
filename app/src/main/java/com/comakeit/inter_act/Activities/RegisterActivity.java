package com.comakeit.inter_act.Activities;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.comakeit.inter_act.R;

public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = "RegisterActivity";
    private Button mSignUpButton;
    private TextView mLoginLinkTextView;
    private EditText mEmailEditText, mFirstNameEditText, mLastNameEditText, mPasswordEditText, mConfirmPasswordEditText;
    private Drawable mCorrectDrawable, mCorrectDrawable2, mCorrectDrawable3, mCorrectDrawable4, mCorrectDrawable5;
    private TextInputLayout mEmailInputLayout, mFirstNameInputLayout, mLastNameInputLayout, mPasswordInputLayout, mConfirmPasswordInputLayout;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mSignUpButton = findViewById(R.id.register_signup_button);
        mPasswordEditText = findViewById(R.id.register_password_edit_text);
        mConfirmPasswordEditText = findViewById(R.id.register_confirm_password_edit_text);
        mFirstNameEditText = findViewById(R.id.register_first_name_edit_text);
        mLastNameEditText = findViewById(R.id.register_last_name_edit_text);
        mEmailEditText = findViewById(R.id.register_email_edit_text);
        mLoginLinkTextView = findViewById(R.id.register_login_text_view);
        mCorrectDrawable = getResources().getDrawable(R.drawable.ic_correct, null);
        mCorrectDrawable.setBounds(0,0, mCorrectDrawable.getIntrinsicWidth(), mCorrectDrawable.getIntrinsicHeight());
        mCorrectDrawable.setTint(getResources().getColor(R.color.colorGreen, null));

        mEmailInputLayout = findViewById(R.id.register_email_input_layout);
        mFirstNameInputLayout = findViewById(R.id.register_first_name_input_layout);
        mLastNameInputLayout = findViewById(R.id.register_last_name_input_layout);
        mPasswordInputLayout = findViewById(R.id.register_password_input_layout);
        mConfirmPasswordInputLayout = findViewById(R.id.register_confirm_password_input_layout);

        mEmailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(validateEmail()){
                    mEmailInputLayout.setErrorEnabled(false);
                    mEmailEditText.setCompoundDrawables(null, null, mCorrectDrawable, null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mFirstNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(validateFirstName()){
                    mFirstNameInputLayout.setErrorEnabled(false);
                    mFirstNameEditText.setCompoundDrawablesWithIntrinsicBounds(null, null, mCorrectDrawable, null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mLastNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (validateLastName()){
                    mLastNameInputLayout.setErrorEnabled(false);
                    mLastNameEditText.setCompoundDrawablesWithIntrinsicBounds(null, null, mCorrectDrawable, null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mPasswordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(validatePassword()){
                    mPasswordInputLayout.setErrorEnabled(false);
                    mPasswordEditText.setCompoundDrawablesWithIntrinsicBounds(null, null, mCorrectDrawable, null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mConfirmPasswordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!validateConfirmPassword()){
                    mConfirmPasswordEditText.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
                    mConfirmPasswordInputLayout.setErrorEnabled(true);
                    mConfirmPasswordInputLayout.setError("Passwords do not match");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        mLoginLinkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                finish();
            }
        });
    }

    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        mSignUpButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(RegisterActivity.this,
                R.style.LoginActivityStyle);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        String first_name = mFirstNameEditText.getText().toString();
        String first_last = mLastNameEditText.getText().toString();
        String email = mEmailEditText.getText().toString();
        String password = mPasswordEditText.getText().toString();

        // TODO: Implement your own signup logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    public void onSignupSuccess() {
        mSignUpButton.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        mSignUpButton.setEnabled(true);
    }

    public boolean validateFirstName(){
        boolean valid = true;
        String first_name = mFirstNameEditText.getText().toString().trim();
        if (first_name.isEmpty() || first_name.length() < 3) {
            mFirstNameEditText.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
            mFirstNameInputLayout.setErrorEnabled(true);
            mFirstNameInputLayout.setError("At least 3 letters");
            valid = false;
        }
        return valid;
    }

    public boolean validateLastName(){
        boolean valid = true;
        String last_name = mLastNameEditText.getText().toString().trim();
        if (last_name.isEmpty() || last_name.length() < 3) {
            mLastNameEditText.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
            mLastNameInputLayout.setErrorEnabled(true);
            mLastNameInputLayout.setError("At least 3 letters");
            valid = false;
        }
        return valid;
    }

    public boolean validateEmail(){
        boolean valid = true;
        String email = mEmailEditText.getText().toString();
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmailEditText.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
            mEmailInputLayout.setErrorEnabled(true);
            mEmailInputLayout.setError("Enter a valid email address");
            valid = false;
        }
        return valid;
    }
    public boolean validatePassword(){
        boolean valid = true;
        String password = mPasswordEditText.getText().toString().trim();
        if (password.isEmpty() || password.length() < 4 || password.length() > 18) {
            mPasswordEditText.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
            mPasswordInputLayout.setErrorEnabled(true);
            mPasswordInputLayout.setError("Must be between 4 and 18 letters");
            valid = false;
        }
        return valid;
    }
    public boolean validateConfirmPassword(){
        boolean valid = false;
        String confirm_password = mConfirmPasswordEditText.getText().toString().trim();
        if(validatePassword() && confirm_password.equals(mPasswordEditText.getText().toString().trim())) {
            valid = true;
            mConfirmPasswordInputLayout.setErrorEnabled(false);
            mConfirmPasswordEditText.setCompoundDrawablesWithIntrinsicBounds(null, null, mCorrectDrawable, null);
        }
        return valid;
    }

    public boolean validate() {
        boolean valid = true;
        return valid;
    }
}