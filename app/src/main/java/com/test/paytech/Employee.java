package com.test.paytech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

import static android.graphics.Color.BLACK;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class Employee extends AppCompatActivity {
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        linearLayout = findViewById(R.id.linear);
        String Val = getIntent().getStringExtra("fN");

        List<objectResource> Resource;

        tableControl tableControl = new tableControl(getApplicationContext());
        Resource =tableControl.readResource(Val);
        String fN = null , lN = null, DOB = null, Em = null, Phn = null;

        for (objectResource obj: Resource){

            fN = obj.fName;
            lN = obj.lName;
            DOB = obj.DOB;
            Em = obj.Email;
            Phn = obj.Contact;
        }

        RelativeLayout relativeLayout = new RelativeLayout(getApplicationContext());
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT);
        params.height = 800;
        params.rightMargin = 10;
        params.topMargin = 10;
        params.bottomMargin = 10;
        params.leftMargin = 10;
        relativeLayout.setBackgroundResource(R.drawable.locate);
        relativeLayout.setLayoutParams(params);
        linearLayout.addView(relativeLayout);

        TableRow.LayoutParams txtParams= new TableRow.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
        TextView Fn = new TextView(getApplicationContext());
        Fn.setGravity(Gravity.CENTER_VERTICAL);
        Fn.setPadding(35,100,50,50);
        Fn.setTextColor(BLACK);
        Fn.setTextSize(25);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/roboto.ttf");
        Fn.setTypeface(face, Typeface.BOLD);
        Fn.setText("First Name: "+fN);
        Fn.setLayoutParams(txtParams);
        relativeLayout.addView(Fn);

        TextView Ln = new TextView(getApplicationContext());
        Ln.setGravity(Gravity.CENTER_VERTICAL);
        Ln.setPadding(35,200,50,50);
        Ln.setTextColor(BLACK);
        Ln.setTextSize(25);
        Ln.setTypeface(face, Typeface.BOLD);
        Ln.setText("Last Name: "+lN);
        Ln.setLayoutParams(txtParams);
        relativeLayout.addView(Ln);

        TextView DB = new TextView(getApplicationContext());
        DB.setGravity(Gravity.CENTER_VERTICAL);
        DB.setPadding(35,300,50,50);
        DB.setTextColor(BLACK);
        DB.setTextSize(25);
        DB.setTypeface(face, Typeface.BOLD);
        DB.setText("DOB: "+DOB);
        DB.setLayoutParams(txtParams);
        relativeLayout.addView(DB);

        TextView Email = new TextView(getApplicationContext());
        Email.setGravity(Gravity.CENTER_VERTICAL);
        Email.setPadding(35,400,50,50);
        Email.setTextColor(BLACK);
        Email.setTextSize(25);
        Email.setTypeface(face, Typeface.BOLD);
        Email.setText("Email: "+Em);
        Email.setLayoutParams(txtParams);
        relativeLayout.addView(Email);

        TextView Contact = new TextView(getApplicationContext());
        Contact.setGravity(Gravity.CENTER_VERTICAL);
        Contact.setPadding(35,550,50,50);
        Contact.setTextColor(BLACK);
        Contact.setTextSize(25);
        Contact.setTypeface(face, Typeface.BOLD);
        Contact.setText("Contact: "+Phn);
        Contact.setLayoutParams(txtParams);
        relativeLayout.addView(Contact);
    }
}