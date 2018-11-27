package com.example.mohamedmeme.simplefragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         etMessage= findViewById(R.id.et_message);





        //complete the fragment transaction (add) as default
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_layout, new FragmentA())
                .commit();
    }

    public void onClick(View view) {

        //complete the fragment transaction (add)

        if (!(getSupportFragmentManager().findFragmentById(R.id.fragment_layout) instanceof FragmentB)) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack("Replace Fragment A")
                    .replace(R.id.fragment_layout,FragmentB.newInstance(etMessage.getText().toString()))
                    .commit();
        } else {


            //Toast.makeText(this, "Already Added ", Toast.LENGTH_SHORT).show();
            FragmentB fragmentB= (FragmentB) getSupportFragmentManager().findFragmentById(R.id.fragment_layout);
            fragmentB.updateMessage(etMessage.getText().toString());

        }
        etMessage.setText("");
    }
}
