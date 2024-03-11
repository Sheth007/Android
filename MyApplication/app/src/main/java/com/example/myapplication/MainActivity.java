package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText e1=findViewById(R.id.edittext);
        EditText e2=findViewById(R.id.edittext2);
        Button b1=findViewById(R.id.button);
        Button b2=findViewById(R.id.button2);
        Button b3=findViewById(R.id.button3);
        Button b4=findViewById(R.id.button4);
        TextView t1=findViewById(R.id.textView);
        dbhelper db=new dbhelper(MainActivity.this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=e1.getText().toString();
                String name=e2.getText().toString();
                db.insertData(id, name);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c=db.displaydata();
                while(c.moveToNext())
                {
                    t1.setText(t1.getText().toString()+c.getString(0)+"\t"+c.getString(1)+"\n");
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Id=e1.getText().toString();
                String Name=e2.getText().toString();
                db.updatedata(Id, Name);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID=e1.getText().toString();
                db.deletedata(ID);
            }
        });
    }
}