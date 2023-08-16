package com.randez_trying.cardanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView err = findViewById(R.id.err_anim);
        TextView success = findViewById(R.id.success_anim);

        err.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, ErrorActivity.class));
            overridePendingTransition(0, 0);
        });
        success.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, SuccessActivity.class));
            overridePendingTransition(0, 0);
        });
    }
}