package com.example.quizappjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
Button btn;
EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText=findViewById(R.id.editText2);
        btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=editText.getText().toString();



                String Button= btn.getText().toString();
                btn.setText(Button);
                if(name.isEmpty()){
                    Toast.makeText(MainActivity2.this, "please enter your Name", Toast.LENGTH_SHORT).show();
                }

                else {
                    Toast.makeText(MainActivity2.this, "Login Successfull!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    startActivity(intent);

                }
            }
        });

    }
}