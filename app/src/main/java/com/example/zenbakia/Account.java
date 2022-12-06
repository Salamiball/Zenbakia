
package com.example.zenbakia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        ImageButton login = (ImageButton) findViewById(R.id.imageButton1);
        EditText psw = (EditText) findViewById(R.id.editTextTextPassword);
        EditText username = (EditText) findViewById(R.id.editTextTextPersonName2);
        TextView anzeige = (TextView) findViewById(R.id.textView);
        TextView error = (TextView) findViewById(R.id.textView2);

        login.setOnClickListener( new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            System.out.println(username.getText() + "   " + psw.getText() );
            if((username.getText().toString().equals("root")) && (psw.getText().toString().equals("root"))) {

                error.setText("");
                Intent intent = new Intent(Account.this, MainActivity.class);
                startActivity(intent);
            } else {
                error.setText("Falsche eingabe");
            }


        }
    });



    }
}

