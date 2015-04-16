package com.example.s9942162b.homework3;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.GregorianCalendar;


public class HomeworkDetailEditActivity extends ActionBarActivity {
    String mTitle;
    Boolean mCompleteB;
    GregorianCalendar mDueDate = null;
    GregorianCalendar mRemindDate = null;
    String mNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework_detail_edit);

        Button mFinishButton = (Button)findViewById(R.id.Finish_Button);
        mFinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText mTitleET = (EditText) findViewById(R.id.HTitleET);
                EditText mCompletion = (EditText) findViewById(R.id.HCompletedET); //casting complete status
                CheckBox mCompleteCB = (CheckBox) findViewById(R.id.checkbox_complete); //casting checkbox
                DatePicker mDDDP = (DatePicker)findViewById(R.id.datePickerDueDate);
                DatePicker mRDDP = (DatePicker)findViewById(R.id.datePickerRemindDate);
                EditText mNotesET = (EditText)findViewById(R.id.HNotesET);

                mTitle = mTitleET.getText().toString();
                mCompleteB = mCompleteCB.isChecked();
                mDueDate.set(mDDDP.getYear(), mDDDP.getMonth(), mDDDP.getDayOfMonth()); //set gregorian due date variable
                mRemindDate.set(mRDDP.getYear(), mRDDP.getMonth(), mRDDP.getDayOfMonth()); //set gregorian remind date variable
                mNotes = mNotesET.getText().toString();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_homework_detail_edit, menu);
        return true;
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
