package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText e1 = findViewById(R.id.EditText);
        EditText e2 = findViewById(R.id.EditText2);
        Button b1 = findViewById(R.id.button);
        Button b2 = findViewById(R.id.button2);
        Button b3 = findViewById(R.id.button3);
        Button b4 = findViewById(R.id.button4);
        TextView tv = findViewById(R.id.textView);
        TextView tv2 = findViewById(R.id.textView2);

        SharedPreferences sharedPref = getSharedPreferences("my_pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = e1.getText().toString();
                String val = e2.getText().toString();

                SharedPreferences sharedPref = getSharedPreferences("my_pref", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();

                editor.putString(key, val);
                editor.apply();

                Toast.makeText(MainActivity.this, "Committed", Toast.LENGTH_SHORT).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = e1.getText().toString();
                String val = e2.getText().toString();

                // Check if the key exists before updating
                if (sharedPref.contains(key)) {
                    editor.putString(key, val);
                    editor.apply();
                    Toast.makeText(MainActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Key does not exist", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = e1.getText().toString();

                // Check if the key exists before deleting
                if (sharedPref.contains(key)) {
                    editor.remove(key);
                    editor.apply();
                    Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Key does not exist", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = e1.getText().toString();
                String val = sharedPref.getString(key, null);
                e2.setText(val);

                // Display the data in TextViews
                String name = sharedPref.getString("Name", ""); // Ensure key "Name" matches what you saved
                int id = sharedPref.getInt("ID", 0); // Ensure key "ID" matches what you saved
                tv.setText("Name: " + name);
                tv2.setText("ID: " + id);
            }
        });



    }
}