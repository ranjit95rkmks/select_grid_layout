package com.example.gridexampletwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;
import static com.example.gridexampletwo.R.drawable.grid_row_border;

public class MainActivity extends AppCompatActivity {

    GridView myGrid;
    ArrayList<Toy> myToy;
    ArrayList<String> myCard;
    ArrayList<Double>price;
    ArrayList<Integer> pic;
    String mySelect = "";
    Button btn;
    double total_price = 00;
    LinearLayout bouder;
    GridAdapter gridAdapter;
    double[] p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn= (Button) findViewById(R.id.btn);
        myCard = new ArrayList<>();
        price = new ArrayList<>();;
        pic = new ArrayList<>();
        bouder = (LinearLayout)findViewById(R.id.my_view);
        myGrid = (GridView) findViewById(R.id.my_grid);
        myToy = new ArrayList<>();
        setArrayList();
        gridAdapter = new GridAdapter(this,myToy);
        myGrid.setAdapter(gridAdapter);
        myGrid.setOnItemClickListener(myItem);
      //  myGrid.setOnItemSelectedListener(mySelectedItem);

      /*  myGrid.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent me) {

                int action = me.getActionMasked();
                float currentXPosition = me.getX();
                float currentYPosition = me.getY();
                int position = myGrid.pointToPosition((int) currentXPosition, (int) currentYPosition);
                if (action == MotionEvent.ACTION_DOWN) {
                    //bouder.setBackgroundResource(grid_row_border);
                   // myGrid.requestFocusFromTouch();
                   // Toast.makeText(MainActivity.this, position+"", LENGTH_SHORT).show();
                }

                return true;
            }
        });*/

    }

   /* GridView.OnItemSelectedListener mySelectedItem = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };*/


    GridView.OnItemClickListener myItem = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            btn.setVisibility(View.VISIBLE);

            String value = String.valueOf(myToy.get(position).getTitle());
            Toy toy = myToy.get(position);
            if (toy.isSelected()) {
                toy.setSelect(false);
                myCard.remove(toy.getTitle());
                pic.remove(toy.getImage());
                price.remove(toy.getPrice());
                if(mySelect.contains(toy.getTitle())){
                    mySelect.replace(toy.getTitle().toString(), " ");
                   // Toast.makeText(MainActivity.this, "remove text", Toast.LENGTH_SHORT).show();

                }

                total_price -= Double.valueOf(toy.getPrice());
            }
            else {

                toy.setSelect(true);
                myCard.add(toy.getTitle());
                pic.add(toy.getImage());
                price.add(toy.getPrice());
                mySelect += toy.getTitle();
                total_price += Double.valueOf(toy.getPrice());
            }
            gridAdapter.updateRecords(myToy);



           // Toast.makeText(MainActivity.this, "Select item"+mySelect+". Price"+total_price, Toast.LENGTH_SHORT).show();
              Toast.makeText(MainActivity.this, ""+pic, Toast.LENGTH_SHORT).show();

        }
    };

    private void setArrayList() {
        Toy toy1 = new Toy(R.drawable.toy1, "Toy1", 4.00, false);
        Toy toy2 = new Toy(R.drawable.toy2, "Toy2", 5.00,false);
        Toy toy3 = new Toy(R.drawable.toy3, "Toy3", 6.00,false);
        Toy toy4 = new Toy(R.drawable.toy4, "Toy4", 7.00, false);
        Toy toy5 = new Toy(R.drawable.toy5, "Toy5", 8.00,false);
        Toy toy6 = new Toy(R.drawable.toy6, "Toy6", 9.00,false);
        Toy toy7 = new Toy(R.drawable.toy7, "Toy7", 10.00,false);
        Toy toy8 = new Toy(R.drawable.toy8, "Toy8", 11.00,false);

        myToy.add(toy1);
        myToy.add(toy2);
        myToy.add(toy3);
        myToy.add(toy4);
        myToy.add(toy5);
        myToy.add(toy6);
        myToy.add(toy7);
        myToy.add(toy8);


    }


    public void myClick(View view) {


        String totalprice = String.valueOf(total_price);
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("myValue", myCard);
        intent.putExtra("myCost", totalprice);
        intent.putIntegerArrayListExtra("logo", (ArrayList<Integer>) pic ); // it sent null arraylist
       // intent.putExtra("loge", pic);// it also send null
        intent.putExtra("price", price);// it work ArrayList<Double>price;
        startActivity(intent);
    }
}