package com.example.droidcafe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.droidcafe.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String mOrderMessage;
    private View mWebsite;
    private View mLocation;
    public static final String EXTRA_ORDER_KEY = "MY KEY FOR ORDER MESSAGE";


    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mWebsite = findViewById(R.id.action_about_us);
        mLocation = findViewById(R.id.location);

        setSupportActionBar(binding.toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //implement an explicit intent for opening the order activity
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_ORDER_KEY, mOrderMessage);
                startActivity(intent);
            }
        });

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_ORDER_KEY, mOrderMessage);
                startActivity(intent);
            }
        });
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
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
            //return true;
        //}

        //create a switch case block to handle the clicks on the menu items
        switch (item.getItemId()){
            case R.id.action_order:
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_ORDER_KEY, mOrderMessage);
                startActivity(intent);
                return true;
            case R.id.action_call:
                //implement an implicit intent that calls your cafe number
                Uri myUri = Uri.parse("tel:0797951032");
                Intent myIntent = new Intent(Intent.ACTION_DIAL, myUri);
                startActivity(myIntent);
                return true;
            case R.id.action_about_us:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://kfc.ke/"));
                startActivity(browserIntent);
                return true;
            case R.id.location:
                Uri addressUri = Uri.parse("geo:0,0?q=");
                intent = new Intent(Intent.ACTION_VIEW, addressUri);
                startActivity(intent);
                return true;

                //ensure the item about us opens a webpage and locate us opens a google map showing your latitude and longitude.

        }

        return super.onOptionsItemSelected(item);
    }

    //method for displaying toast messages
    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    public void showIceCreamMessage(View view) {
        //define what will be done when the user clicks on the image view
        //e.g showing a toast
        //adding an item to the shopping cart
        //displayToast(getString(R.string.ice_cream_order));
        mOrderMessage = getString(R.string.ice_cream_order);
        displayToast(mOrderMessage);
    }

    public void showDonutOrderMessage(View view) {
        mOrderMessage = getString(R.string.donut_order);
        displayToast(mOrderMessage);
        //displayToast(getString(R.string.donut_order));
    }

    public void showFroyoOrderMessage(View view) {
        mOrderMessage = getString(R.string.froyo_order);
        displayToast(mOrderMessage);
    }
}