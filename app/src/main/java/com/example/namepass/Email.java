package com.example.namepass;

import android.content.Context;
import android.widget.Toast;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Email extends Thread {

    private String domain;
    private Context context;
    private String message;

    public Email(String domain, Context context){
        this.domain = domain;
        this.context = context;
        this.message = "";
    }

    @Override
    public void run() {
        try {
            InetAddress ia = InetAddress.getByName(domain);
            message = "Correct email address";
        } catch (UnknownHostException e) {
            message = "This email address does not exist";
        }
    }

    public String getMessage() {
        return message;
    }
}
