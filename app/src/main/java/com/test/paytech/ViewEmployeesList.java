package com.test.paytech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.graphics.Color.BLACK;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class ViewEmployeesList extends AppCompatActivity {
    LinearLayout linearLayout;
    public static final Map<Integer, Integer> ITEM_MAP = new HashMap<Integer, Integer>();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_employees_list);
        linearLayout = findViewById(R.id.linearLayout);

        tableControl tableControl = new tableControl(getApplicationContext());
        List<objectResource> empName = tableControl.readEmpName();

        if (empName.size()>0){
            int i=1;
            for (objectResource obj : empName){
                String fName = obj.fName;
                String lName = obj.lName;
                int id = ViewCompat.generateViewId();

                RelativeLayout relativeLayout = new RelativeLayout(getApplicationContext());
                relativeLayout.setId(id);
                ITEM_MAP.put(i,id);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT);
                params.height = 170;
                params.rightMargin = 10;
                params.topMargin = 10;
                params.bottomMargin = 10;
                params.leftMargin = 10;
                relativeLayout.setBackgroundResource(R.drawable.locate);
                relativeLayout.setLayoutParams(params);
                linearLayout.addView(relativeLayout);
                TableRow.LayoutParams txtParams= new TableRow.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
                TextView textView = new TextView(getApplicationContext());
                textView.setId(R.id.text);
                textView.setPadding(35,45,50,50);
                textView.setTextColor(BLACK);
                textView.setTextSize(20);
                Typeface face = Typeface.createFromAsset(getAssets(), "fonts/roboto.ttf");
                textView.setTypeface(face, Typeface.BOLD);
                textView.setText(fName+" "+lName);
                textView.setLayoutParams(txtParams);
                relativeLayout.addView(textView);
                int La = ITEM_MAP.get(i);

                RelativeLayout Real = findViewById(La);

                Real.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(ViewEmployeesList.this, Employee.class).putExtra("fN",fName));
                    }
                });
                i++;


            }

        }else{
            RelativeLayout relativeLayout = new RelativeLayout(getApplicationContext());
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT);
            params.height = 170;
            params.rightMargin = 10;
            params.topMargin = 10;
            params.bottomMargin = 10;
            params.leftMargin = 10;
            relativeLayout.setBackgroundResource(R.drawable.locate);
            relativeLayout.setLayoutParams(params);
            linearLayout.addView(relativeLayout);
            TableRow.LayoutParams txtParams= new TableRow.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
            TextView textView = new TextView(getApplicationContext());
            textView.setId(R.id.text);
            textView.setPadding(35,45,50,50);
            textView.setTextColor(BLACK);
            textView.setTextSize(20);
            Typeface face = Typeface.createFromAsset(getAssets(), "fonts/roboto.ttf");
            textView.setTypeface(face, Typeface.BOLD);
            textView.setText("No Records Found.");
            textView.setLayoutParams(txtParams);
            relativeLayout.addView(textView);

        }


    }
}