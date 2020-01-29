package com.example.namepass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText et_username, et_password;
    private TextView tv_security_lvl;
    private ProgressBar progress_bar;
    private ImageView imageView;

    private boolean eyeImageChooser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initVars();
        resizeImages();



        et_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {



            }

            @Override
            public void afterTextChanged(Editable s) {

                String password = s.toString();
                int i = 0;
                if (MyClass.emailExists(password)){

                    if (MyClass.passIsLongEnought(password)){
                        i++;

                        if (MyClass.passHaslowercase(password)){
                            i++;
                        }
                        if(MyClass.passHasNumber(password)){
                            i++;
                        }
                        if(MyClass.passHasSymbol(password)){
                            i++;
                        }
                        if (MyClass.passHasUppercase(password)){
                            i++;
                        }
                    }
                    updateViews(new SecurityLevel(i));
                }
            }
        });

    }

    private void initVars() {
        eyeImageChooser = true;

    }


    private void resizeImages() {
       Glide.with(this).load(R.mipmap.whatching_password).into(imageView);

    }


    public void imageViewOnClick(View view){
        if (eyeImageChooser){
            Glide.with(this).load(R.mipmap.hidden_password).into(imageView);
            eyeImageChooser = false;
            et_password.setTransformationMethod(null);
        }else{
            Glide.with(this).load(R.mipmap.whatching_password).into(imageView);
            eyeImageChooser = true;
            et_password.setTransformationMethod(new PasswordTransformationMethod());
        }
        et_password.setSelection(et_password.getText().length());//pointer goes to the end

    }


    private void initViews(){
        et_username = findViewById(R.id.et_usermane);
        et_password = findViewById(R.id.et_password);
        tv_security_lvl = findViewById(R.id.tv_security_lvl);
        progress_bar = findViewById(R.id.progress_bar);
        imageView = findViewById(R.id.imageView);

    }


    private void updateViews(SecurityLevel securityLevel){
        tv_security_lvl.setText(securityLevel.getSecurityWord());
        tv_security_lvl.setTextColor(getResources().getColor(securityLevel.getSecurityColor()));
        progress_bar.setProgress(MyClass.progressBarValue(securityLevel.getI()));

    }


    public void checkDomain(){
        String email = et_username.getText().toString();
        String[] emailSplitted = email.split("@");
        Email emailObject = new Email(emailSplitted[1], this);
        emailObject.start();
        try {
            emailObject.join();
        }catch (InterruptedException ex){

        }
        Toast.makeText(this, emailObject.getMessage(), Toast.LENGTH_SHORT).show();

    }


    public void checkEmail(View view){
        String email = et_username.getText().toString();
        if(!MyClass.emailExists(email)){
            Toast.makeText(this, "Email empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!Pattern.matches("^[a-zA-Z0-9]+@[a-z]+\\.[a-z]$", email)){
            Toast.makeText(this, "No valid email sintax", Toast.LENGTH_SHORT).show();
            return;
        }
        checkDomain();
    }


}
