package com.example.s9942162b.homework3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.DateFormat;


public class HomeworkDetailActivity extends ActionBarActivity {

    public static final String HOMEWORK_PARCEL = "com.example.s9942162b.homework3.homework_parcel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework_detail);
        Intent intent = getIntent();
        Homework mHomework = (Homework) intent.getParcelableExtra(HOMEWORK_PARCEL); //getting the relevant homework object

        TextView mTitle = (TextView) findViewById(R.id.HTitleTV);
        mTitle.setText(mHomework.getTitle()); //setting the title

        TextView mCompletion = (TextView) findViewById(R.id.HCompletedTV); //casting complete status
        CheckBox mCompleteCB = (CheckBox) findViewById(R.id.checkbox_complete); //casting checkbox

        Boolean TFCompleteB = mHomework.isCompletion(); //getting true false value from homework object
        String mTFCompleteS = String.valueOf(TFCompleteB); //setting a string for ease of reference
        mCompletion.setText(mTFCompleteS); //setting true false value (of string)
        mCompleteCB.setChecked(TFCompleteB); //setting checkbox status

        DateFormat mDateDF = android.text.format.DateFormat.getDateFormat(getApplicationContext()); //setting date format
        TextView mDateDue = (TextView) findViewById(R.id.HDueDateTV); //casting due date
        mDateDue.setText(mDateDF.format(mHomework.getDueDate())); //setting due date and formating at the same time

        TextView mRemindDate = (TextView) findViewById(R.id.HRemindDateTV); //casting remind date
        mDateDue.setText(mDateDF.format(mHomework.getRemindDate()));

        TextView mNotes = (TextView) findViewById(R.id.HNotesTV);
        mNotes.setText(mHomework.getNotes()); //setting notes

        Button mEditButton = (Button) findViewById(R.id.Edit_Button);
        mEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_homework_detail, menu);
        return true;
    }
    public boolean TFComplete(CheckBox cb){
       if (cb.isChecked()){
            return true;
        }
        else{
           return false;
       }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}