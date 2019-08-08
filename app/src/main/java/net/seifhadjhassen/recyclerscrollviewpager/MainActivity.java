package net.seifhadjhassen.recyclerscrollviewpager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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

        recyclerViewPager=findViewById(R.id.pager);
        recyclerViewPager.addItem(new PagerModel(R.drawable.cover1,"Vikings"));
        recyclerViewPager.addItem(new PagerModel(R.drawable.cover2,"The nutcracker and the four realms"));
        recyclerViewPager.addItem(new PagerModel(R.drawable.cover3,"Flash"));
        recyclerViewPager.start();


    }
}
