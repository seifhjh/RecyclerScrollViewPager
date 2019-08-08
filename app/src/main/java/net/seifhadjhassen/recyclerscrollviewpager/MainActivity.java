package net.seifhadjhassen.recyclerscrollviewpager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import net.seifhadjhassen.recyclerviewpager.PagerAdapter;
import net.seifhadjhassen.recyclerviewpager.PagerModel;
import net.seifhadjhassen.recyclerviewpager.RecyclerViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    RecyclerViewPager recyclerViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerViewPager recyclerViewPager=findViewById(R.id.pager);
        // add item from resource

        recyclerViewPager.addItem(new PagerModel(R.drawable.cover1,"Vikings",getApplicationContext()));
        recyclerViewPager.addItem(new PagerModel(R.drawable.cover2,"The nutcracker and the four realms",getApplicationContext()));
        recyclerViewPager.addItem(new PagerModel(R.drawable.cover3,"Flash",getApplicationContext()));

        //add item from url


        //  recyclerViewPager.addItem(new PagerModel("http://i.imgur.com/DvpvklR.png","Vikings"));


        recyclerViewPager.start();

        recyclerViewPager.setOnItemClickListener(new PagerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getApplicationContext(),"click pos "+position,Toast.LENGTH_SHORT).show();
            }
        });


    }
}
