package com.example.myapplication;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.myapplication.databinding.ActivityMainBinding;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.button.setOnClickListener(v-> {
                if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    File kulsofajl = new File(getExternalFilesDir(null), "myfile2.txt");
                    try {
                        FileOutputStream fos = new FileOutputStream(kulsofajl);
                        fos.write(binding.editText.getText().toString().getBytes());
                        fos.flush();
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        });

        binding.button2.setOnClickListener(v-> {
                if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    File kulsofajl = new File(getExternalFilesDir(null), "myfile2.txt");
                    try {
                        FileInputStream fis = new FileInputStream(kulsofajl);
                        byte[] data = new byte[(int) kulsofajl.length()];
                        fis.read(data);
                        fis.close();
                        String str = new String(data, "UTF-8");
                        binding.editText.setText(str);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        });
    }
}