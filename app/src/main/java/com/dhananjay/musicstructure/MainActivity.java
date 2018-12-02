package com.dhananjay.musicstructure;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



        // Create an ArrayList of AndroidFlavor objects
        ArrayList<AndroidFlavor> androidFlavors = new ArrayList<AndroidFlavor>();
        androidFlavors.add(new AndroidFlavor("Donut", "1.6", R.drawable.donut));
        androidFlavors.add(new AndroidFlavor("Eclair", "2.0-2.1", R.drawable.eclair));
        androidFlavors.add(new AndroidFlavor("Froyo", "2.2-2.2.3", R.drawable.froyo));
        androidFlavors.add(new AndroidFlavor("GingerBread", "2.3-2.3.7", R.drawable.gingerbread));
        androidFlavors.add(new AndroidFlavor("Honeycomb", "3.0-3.2.6", R.drawable.honeycomb));
        androidFlavors.add(new AndroidFlavor("Ice Cream Sandwich", "4.0-4.0.4", R.drawable.icecream));
        androidFlavors.add(new AndroidFlavor("Jelly Bean", "4.1-4.3.1", R.drawable.jellybean));
        androidFlavors.add(new AndroidFlavor("KitKat", "4.4-4.4.4", R.drawable.kitkat));
        androidFlavors.add(new AndroidFlavor("Lollipop", "5.0-5.1.1", R.drawable.lollipop));
        androidFlavors.add(new AndroidFlavor("Marshmallow", "6.0-6.0.1", R.drawable.marshmallow));

        // Create an {@link AndroidFlavorAdapter}, whose data source is a list of
        // {@link AndroidFlavor}s. The adapter knows how to create list item views for each item
        // in the list.
        AndroidFlavorAdapter flavorAdapter = new AndroidFlavorAdapter(this, androidFlavors);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.listview_flavor);
        listView.setAdapter(flavorAdapter);
        ViewCompat.setNestedScrollingEnabled(listView, true);




    }

}
