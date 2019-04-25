package com.example.solovjn_42ipz_lab5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {
   String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Bundle arguments = getIntent().getExtras();
        String prof = arguments.get("prof").toString();
        String name = arguments.get("name").toString();
        String lastName = arguments.get("lastName").toString();
        String act = arguments.get("act").toString();

        String program = arguments.get("program").toString();

        if (act == "") act = " мінімуму зусиль ";

        TextView valText = (TextView)findViewById(R.id.textView);
        str = "Студент: "+lastName+" "+name+" обрав спеціальність: "+prof+" Обрав активності: "+program + " .А також бажає виконувати "+act;
        valText.setText(str);
    }
    public void onClickSendTo(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, str);
        intent.setType("text/plain");
        startActivity(intent);
    }
}
