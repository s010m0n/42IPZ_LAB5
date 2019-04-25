package com.example.solovjn_42ipz_lab5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText editTextName;
    EditText editTextLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName =(EditText)findViewById(R.id.editTextName);
        editTextLastName =(EditText)findViewById(R.id.editTextLastName);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, ActivityChoice.class);

        String name = editTextName.getText().toString();
        String lastName = editTextLastName.getText().toString();
        if (name.isEmpty()){
    Toast.makeText(getApplicationContext(), "Не введено ім’я",Toast.LENGTH_SHORT).show();
        }

    else if(lastName.isEmpty()){
        Toast.makeText(getApplicationContext(), "Не введено прізвище",Toast.LENGTH_SHORT).show();
    }
    else{
        intent.putExtra("name", name);
        intent.putExtra("lastName", lastName);
        startActivity(intent);
    }
    }
}
