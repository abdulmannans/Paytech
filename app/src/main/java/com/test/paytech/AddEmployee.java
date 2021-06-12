package com.test.paytech;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class AddEmployee extends AppCompatActivity {

    private TextView dob;
    Button Save;
    TextView fName, lName, DOB, Email, Contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        dob = findViewById(R.id.TextDOB);

        MaterialDatePicker.Builder materialDateBuilder = MaterialDatePicker.Builder.datePicker();

        materialDateBuilder.setTitleText("SELECT A DATE");

        final MaterialDatePicker materialDatePicker = materialDateBuilder.build();

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER");
            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onPositiveButtonClick(Object selection) {

                dob.setText(materialDatePicker.getHeaderText());

            }
        });

        Save = findViewById(R.id.Save);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fName = findViewById(R.id.TextFName);
                lName = findViewById(R.id.TextLName);
                DOB = findViewById(R.id.TextDOB);
                Email = findViewById(R.id.TextEmail);
                Contact = findViewById(R.id.TextContact);

                String fN, lN, D, Em, Phn;

                fN = fName.getText().toString().trim();
                lN = lName.getText().toString().trim();
                D = DOB.getText().toString().trim();
                Em = Email.getText().toString().trim();
                Phn = Contact.getText().toString().trim();

                objectResource objectResource = new objectResource();
                objectResource.fName = fN;
                objectResource.lName = lN;
                objectResource.DOB = D;
                objectResource.Email = Em;
                objectResource.Contact = Phn;

                tableControl tableControl = new tableControl(getApplicationContext());
                boolean success = tableControl.create(objectResource);

                if (success) {
                    Toast.makeText(getApplicationContext(),"Data Saved",Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
                }



                startActivity(new Intent(AddEmployee.this, MainActivity.class));
                finish();





            }
        });


    }
}