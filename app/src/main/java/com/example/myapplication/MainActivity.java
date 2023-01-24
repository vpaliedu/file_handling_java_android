package com.example.myapplication;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    File kulsofajl = new File(getExternalFilesDir(null), "myfile2.txt");
                    try {
                        FileOutputStream fos = new FileOutputStream(kulsofajl);
                        EditText editText = findViewById(R.id.editText);
                        fos.write(editText.getText().toString().getBytes());
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    File kulsofajl = new File(getExternalFilesDir(null), "myfile2.txt");
                    try {
                        FileInputStream fis = new FileInputStream(kulsofajl);
                        EditText editText = findViewById(R.id.editText);
                        byte[] data = new byte[(int) kulsofajl.length()];
                        fis.read(data);
                        fis.close();
                        String str = new String(data, "UTF-8");
                        editText.setText(str);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}