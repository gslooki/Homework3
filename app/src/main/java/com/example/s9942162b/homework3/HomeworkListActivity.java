package com.example.s9942162b.homework3;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;


public class HomeworkListActivity extends ListActivity {
    private ArrayList<Homework> mHomeworks = new ArrayList(
            (Collection<? extends Homework>) new Homework("Math 1", false, new GregorianCalendar(2014, 4, 5),new GregorianCalendar(2014, 4, 6), "Finish pls" ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HomeworkAdapter adapter;
        adapter = new HomeworkAdapter(this, R.layout.activity_main, mHomeworks);
        setListAdapter(adapter);

        Button mAddButton = (Button)findViewById(R.id.add_button);
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeworkListActivity.this, HomeworkDetailEditActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(this, HomeworkDetailActivity.class);
        intent.putExtra(HomeworkDetailActivity.HOMEWORK_PARCEL, mHomeworks.get(position));
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    private class HomeworkAdapter extends ArrayAdapter<Homework> {
        private int mResource;
        public HomeworkAdapter(Context context, int resource, ArrayList<Homework> homeworks) {
            super(context, resource, homeworks);
            mResource = resource;
            mHomeworks = homeworks;
        }
        @Override
        public View getView(int position, View row, ViewGroup parent) {
            if (row == null) { // this lets Android recycle the row if necessary
                row = getLayoutInflater().inflate(mResource, parent, false);
            }

            final Homework currentHomework = mHomeworks.get(position); // get at this position

            TextView textView = (TextView) row.findViewById(R.id.list_text);
            // set the text
            if(textView != null) {
                textView.setText(currentHomework.getTitle());
            }
            CheckBox checkBox = (CheckBox)row.findViewById(R.id.list_checkbox);
            if(checkBox != null) {
                checkBox.setOnClickListener((new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mHomeworks.remove(this);
                    }
                }

                ));
            }
            return row;
        }
    }

}
