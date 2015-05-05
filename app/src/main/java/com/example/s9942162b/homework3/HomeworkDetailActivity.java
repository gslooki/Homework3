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

import java.util.Calendar;


public class HomeworkDetailActivity extends ActionBarActivity {

    public static final String HOMEWORK_PARCEL = "com.example.s9942162b.homework3.homework_parcel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework_detail);
        final Intent intent = getIntent();
        Homework mHomework = intent.getParcelableExtra("HOMEWORK"); //getting the relevant homework object
        final int position = intent.getIntExtra("POSITION", 0);
        TextView mTitle = (TextView) findViewById(R.id.HTitleTV);
        mTitle.setText(mHomework.getTitle()); //setting the title
        CheckBox mCompleteCB = (CheckBox) findViewById(R.id.checkbox_complete); //casting checkbox
        Boolean TFCompleteB = mHomework.isCompletion(); //getting true false value from homework object
        mCompleteCB.setChecked(TFCompleteB); //setting checkbox status

        //DateFormat mDateDF = android.text.format.DateFormat.getDateFormat(getApplicationContext()); //setting date format
        TextView mDateDue = (TextView) findViewById(R.id.HDueDateTV); //casting due date
        mDateDue.setText(Integer.toString(mHomework.getDueDate().get(Calendar.YEAR)) + " " + Integer.toString(mHomework.getDueDate().get(Calendar.MONTH)) + " " + Integer.toString(mHomework.getDueDate().get(Calendar.DAY_OF_MONTH))); //setting due date and formating at the same time


        TextView mRemindDate = (TextView) findViewById(R.id.HRemindDateTV); //casting remind date
        //mRemindDate.setText(Integer.toString(mHomework.getRemindDate().get(Calendar.YEAR)) + " " + Integer.toString(mHomework.getRemindDate().get(Calendar.MONTH)) + " " + Integer.toString(mHomework.getRemindDate().get(Calendar.DAY_OF_MONTH)));
        mRemindDate.setText(mHomework.getRemindDate().toString());
        TextView mNotes = (TextView) findViewById(R.id.HNotesTV);
        mNotes.setText(mHomework.getNotes()); //setting notes

        Button mFinishButton = (Button) findViewById(R.id.Finish_Button);
        mFinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox mFinalCompleteCB = (CheckBox) findViewById(R.id.checkbox_complete);
                Homework mHomework = intent.getParcelableExtra("HOMEWORK");
                mHomework.setCompletion(mFinalCompleteCB.isChecked());
                Intent i = new Intent(HomeworkDetailActivity.this,HomeworkListActivity.class);
                i.putExtra("POSITION", position);
                i.putExtra("HOMEWORK", mHomework);
                finish();
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