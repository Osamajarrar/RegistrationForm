package project.bzu.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Summary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary);
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        String email=intent.getStringExtra("email");
        String reason=intent.getStringExtra("reason");
        String day=intent.getStringExtra("day");
        String month=intent.getStringExtra("month");
        String year=intent.getStringExtra("year");
        String gender=intent.getStringExtra("gender");

        TextView summary=findViewById(R.id.summary);
        summary.setText("Applicant "+name+" is applying to enroll in the android course.\nApplicant's email is "+email+"\nApplicant was born on "+day+"."+month+"."+year+ ".\nApplicant's Gender is " +gender+".\nApplicant's Reason of Applying is "+reason);


    }
}