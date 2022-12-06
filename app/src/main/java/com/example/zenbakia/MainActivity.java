package com.example.zenbakia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {
    public Boolean b = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnver = (Button) findViewById(R.id.button9);
        Button btnent = (Button) findViewById(R.id.button10);
        Button del = (Button) findViewById(R.id.button1);
        Button ctlv = (Button) findViewById(R.id.button2);
        TextView output = (TextView) findViewById(R.id.textView1);
        output.setTextIsSelectable(true);
        EditText input = (EditText) findViewById(R.id.editTextTextPersonName);
        Switch copy = (Switch) findViewById(R.id.switch1);
        ImageButton abmelden = (ImageButton) findViewById(R.id.imageButton);



        btnver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Verschluesseln ver = new Verschluesseln();
                String text =input.getText().toString();
                output.setText(ver.alg1(text));

                if (b){
                    ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    CharSequence label = "";
                    ClipData clip = ClipData.newPlainText(label,output.getText().toString());
                    clipboard.setPrimaryClip(clip);
                }
            }
        });

        btnent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Entschluesseln ent = new Entschluesseln();
                String text = input.getText().toString();
                output.setText(ent.alg1(text));
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
            }
        });

        ctlv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData paste = clipboard.getPrimaryClip();
                ClipData.Item item = paste.getItemAt(0);
                input.setText(item.getText().toString());

            }
        });

        copy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    b =true;
                }else{
                    b =false;
                }
            }
        });


        abmelden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, Account.class);
                //startActivity(intent);

                finish();
                System.exit(0);
            }
        });
    }

}