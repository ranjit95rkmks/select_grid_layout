package com.example.gridexampletwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ArrayList<String> value;
    ArrayList<Double> prices;
    ArrayList<Integer> pic;
    String myPrice;
    ListView listView;
    TextView totalPrice;
    String text="";

    RadioGroup radioGroup;
    RadioButton genderRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        totalPrice = (TextView) findViewById(R.id.total_price);
        listView = (ListView) findViewById(R.id.listView);
        //Toast.makeText(getApplicationContext(), "hare krishna", Toast.LENGTH_SHORT).show();

        Intent myIntent = getIntent();
        value = myIntent.getStringArrayListExtra("myValue");
        myPrice = myIntent.getStringExtra("myCost");
        totalPrice.setText(myPrice);
        prices = (ArrayList<Double>) getIntent().getSerializableExtra("price"); // this work
        pic = getIntent().getIntegerArrayListExtra("logo"); // this is also null
       // pic = (ArrayList<Integer>) getIntent().getSerializableExtra("logo");// this send null



        Toast.makeText(MainActivity2.this, ""+pic, Toast.LENGTH_SHORT).show();

       MyListAdapter myList = new MyListAdapter(this, value, prices, pic);
       listView.setAdapter(myList);

    }

    public void prement(View view) {

        Toast.makeText(MainActivity2.this, "Prement Method is Under Construction",Toast.LENGTH_SHORT).show();
       /* int selectedId = radioGroup.getCheckedRadioButtonId();
        genderRadioButton = (RadioButton) findViewById(selectedId);
        if(selectedId == -1){
            Toast.makeText(MainActivity2.this,"Nothing selected", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(MainActivity2.this,""+genderRadioButton.getText(), Toast.LENGTH_SHORT).show();
        }*/

    }
}