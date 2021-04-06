package project.bzu.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;

public class RegistrationForm extends AppCompatActivity {
    Spinner spinner1,spinner2,spinner3;
    EditText txtEdtName,txtEdtEmail,details;
    RadioGroup gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_form);
        spinner1=findViewById(R.id.day);
        spinner2=findViewById(R.id.month);
        spinner3=findViewById(R.id.year);
        txtEdtName=findViewById(R.id.edtTxtName);
        txtEdtEmail=findViewById(R.id.edtTxtEmail);
        details=findViewById(R.id.details);
        gender=findViewById(R.id.gender);
        populateSpinner1();
        populateSpinner2();
        populateSpinner3();



    }

    private void populateSpinner1() {
        ArrayList<Integer> days=new ArrayList<>();
        int dayCounter=31;
        for(int i=1;i<=dayCounter;i++){
            days.add(i);
        }
        ArrayAdapter<Integer> adapter=new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item,days);
        spinner1.setAdapter(adapter);
    }
    private void populateSpinner2() {
        ArrayList<String> months=new ArrayList<>();
        months.add("Jan");
        months.add("Feb");
        months.add("Mar");
        months.add("Apr");
        months.add("May");
        months.add("Jun");
        months.add("Jul");
        months.add("Aug");
        months.add("Sep");
        months.add("Oct");
        months.add("Nov");
        months.add("Dec");

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,months);
        spinner2.setAdapter(adapter);
    }
    private void populateSpinner3() {
        ArrayList<Integer> years=new ArrayList<>();
        int yearCounter=1970;
        for(int i=2021;i>=yearCounter;i--){
            years.add(i);
        }
        ArrayAdapter<Integer> adapter=new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item,years);
        spinner3.setAdapter(adapter);
    }

    public void save_onClick(View view) {
        Intent intent=new Intent(this, Summary.class);

        String name=txtEdtName.getText().toString().trim();
        String email=txtEdtEmail.getText().toString().trim();
        String reason=details.getText().toString().trim();
        String day=spinner1.getSelectedItem().toString();
        String month=spinner2.getSelectedItem().toString();
        String year=spinner3.getSelectedItem().toString();
        int id = gender.getCheckedRadioButtonId();
        View radioButton = gender.findViewById(id);
        int radioId = gender.indexOfChild(radioButton);
        RadioButton btn = (RadioButton) gender.getChildAt(radioId);
        String selection = (String) btn.getText();

        intent.putExtra("name",name);
        intent.putExtra("email",email);
        intent.putExtra("reason",reason);
        intent.putExtra("day",day);
        intent.putExtra("month",month);
        intent.putExtra("year",year);
        intent.putExtra("gender",selection);
        startActivity(intent);
    }
}