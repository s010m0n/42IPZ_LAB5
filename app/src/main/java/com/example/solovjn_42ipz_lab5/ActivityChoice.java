package com.example.solovjn_42ipz_lab5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityChoice extends AppCompatActivity {
        TextView text1;
        TextView text2;
        TextView text3;
        Spinner spinner;
        RadioButton rb1;
        RadioButton rb2;

        CheckBox ch1;
        CheckBox ch2;
        CheckBox ch3;
        String prof="";
        String name="";
        String lastName="";

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("name",  name);
        outState.putString("lastName", lastName);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_choice);

                Bundle arguments = getIntent().getExtras();
                 name = arguments.get("name").toString();
                 lastName = arguments.get("lastName").toString();

                text1 = (TextView) findViewById(R.id.textView1);
                text2 = (TextView) findViewById(R.id.textView2);
                text3 = (TextView) findViewById(R.id.textView3);

                rb1 = (RadioButton) findViewById(R.id.radioButton1);
                rb2 = (RadioButton) findViewById(R.id.radioButton2);

                ch1 = (CheckBox) findViewById(R.id.checkBox);
                ch2 = (CheckBox) findViewById(R.id.checkBox2);
                ch3 = (CheckBox) findViewById(R.id.checkBox3);
                spinner = (Spinner) findViewById(R.id.spinner);
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

                text1.setText("Яку професію ти обираєш, "+name);




        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case -1:
                        Toast.makeText(getApplicationContext(), "Нічого не обрано",
                                Toast.LENGTH_SHORT).show();
                        prof = "";
                        break;
                    case R.id.radioButton1:
                        Toast.makeText(getApplicationContext(), "DevOps",
                                Toast.LENGTH_SHORT).show();
                        prof = "DevOps";
                        break;
                    case R.id.radioButton2:
                        Toast.makeText(getApplicationContext(), "QA",
                                Toast.LENGTH_SHORT).show();
                        prof = "QA";
                        break;

                }
            }
        });

        if (savedInstanceState != null)
        {
            name = savedInstanceState.getString("name");
            lastName = savedInstanceState.getString("lastName");

        }
    }
    public void onClick(View view) {
        Intent intent = new Intent(this, FinalActivity.class);

        int position = spinner.getSelectedItemPosition();

        intent.putExtra("prof", prof);
        intent.putExtra("name", name);
        intent.putExtra("lastName", lastName);

        String act ="";
        if(ch1.isChecked()) act = act+"Лекції, ";
        if(ch2.isChecked()) act = act  +  "Практичні, ";
        if(ch3.isChecked()) act = act+"Лабораторні, ";

        intent.putExtra("act", act);
        String[] data = getResources().getStringArray(R.array.data);
        intent.putExtra("program", data[position]);
        startActivity(intent);

    }
}