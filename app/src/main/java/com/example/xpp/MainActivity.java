package com.example.xpp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(view ->
                Toast.makeText(this, message(), Toast.LENGTH_SHORT).show());
    }

    private String message() {
        return "这是一个测试按钮";
    }
}
