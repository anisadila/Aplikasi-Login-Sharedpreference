package com.example.d2j_00.aplikasiloginpref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public static String LOGIN_PREF = "login.pref.file";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginApp(View view) {
        EditText inpUsername = (EditText) findViewById(R.id.inpUsername);
        EditText inpPassword = (EditText) findViewById(R.id.inpPassword);

        String username = inpUsername.getText().toString();
        String password = inpPassword.getText().toString();

        if (username.equals("anis") && password.equals("adila")){
            SharedPreferences sp = getSharedPreferences(LOGIN_PREF, MODE_PRIVATE);
            SharedPreferences.Editor spEdit = sp.edit();

            spEdit.putString("username",username);
            spEdit.putString("token", "diladiladila");
            spEdit.apply();

            Intent it = new Intent(this, MainActivity.class);
            it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(it);
        } else {
            Toast.makeText(this, "cek kembali", Toast.LENGTH_SHORT).show();
        }
    }
}
