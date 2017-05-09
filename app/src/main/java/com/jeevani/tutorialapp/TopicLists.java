package com.jeevani.tutorialapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Jeevani on 5/9/2017.
 */

public class TopicLists extends AppCompatActivity {

    private ListView list;
    private ArrayAdapter arrayAdapter;
    private String[] topics = { "Introduction  of OOPs", "Class", "Object", "Abstraction", "Encapsulation",
            "Inheritance", "Polymorphism", "Interface" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        list = (ListView) findViewById(R.id.lists);
        CustomAdapter adapter = new CustomAdapter(this,topics);
        list.setAdapter(adapter);

        /*list = (ListView) findViewById(R.id.lists);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, topics);
        list.setAdapter(arrayAdapter);*/

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                /*String item = ((TextView)view).getText().toString();

                Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();*/
                Intent intent = new Intent(TopicLists.this, Home.class);
                startActivity(intent);

                /*AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        TopicLists.this);

                alertDialogBuilder.setTitle("Wanna Add Baseline Information");

                alertDialogBuilder
                        .setMessage("Click No to exit")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(getApplicationContext(),TopicLists.class);
                                startActivity(intent);

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();*/

            }
        });
    }
}

class CustomAdapter extends ArrayAdapter<String>
{
    Context context;
    String[] title;

    CustomAdapter(Context c, String[] title)
    {

        super(c, R.layout.parent_list_items,title);
        this.context = c;
        this.title=title;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View row = vi.inflate(R.layout.parent_list_items, parent, false);
        TextView txt = (TextView) row.findViewById(R.id.textView1);
        int pos = position+1;
        txt.setText(+pos + ". " + title[position]);
        pos++;
        return row;
    }

}