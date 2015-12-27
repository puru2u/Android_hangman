package com.example.vikasyaligar.hangman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final GridView gridView = (GridView) findViewById(R.id.gridview);
        final GameAdapter adapter = new GameAdapter(this);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                char guess = ((TextView) v).getText().charAt(0);
                adapter.guess(guess);
                //adapter.notifyDataSetChanged();

                Toast.makeText(MainActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();

            }
        });
    }
}
