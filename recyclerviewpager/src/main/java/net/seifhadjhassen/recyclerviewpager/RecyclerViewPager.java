package net.seifhadjhassen.recyclerviewpager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.AttributeSet;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class RecyclerViewPager extends RecyclerView {

    private int count;
    private Timer timer=new Timer();
    private PagerAdapter adapter;
    private List<PagerModel> pagerModels=new ArrayList<>();

    private boolean runAuto=false;
    private int colorActiveIndicator = 0xDE000000;
    private int colorInactiveIndicator = 0x33000000;
    private String TAG="RecyclerViewPager";
    private int millis=2000;



    public RecyclerViewPager(@NonNull Context context) {
        super(context);
        Log.e(TAG,"RecyclerViewPager(context)");

        initState();
    }



    public RecyclerViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {

        super(context, attrs);
        Log.e(TAG,"RecyclerViewPager(context,attrs)");

        initState(context,attrs);

    }

    public RecyclerViewPager(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {

        super(context, attrs, defStyle);
        Log.e(TAG,"RecyclerViewPager(context,attrs,defStyle)");

        initState(context,attrs);

    }
    private void initState() {
        LinearLayoutManager lm=new LinearLayoutManager(getContext());
        lm.setOrientation(LinearLayoutManager.HORIZONTAL);
        setLayoutManager(lm);

        setClipToPadding(false);
        setPaddingRelative((int) Const.convertDpToPixel(12,getContext()),0,(int) Const.convertDpToPixel(12,getContext()),0);

        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(this);

    }
    private void initState(Context context, AttributeSet attrs) {
        @SuppressLint("Recycle")
        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RecyclerViewPager);
        LinearLayoutManager lm=new LinearLayoutManager(getContext());
        lm.setOrientation(LinearLayoutManager.HORIZONTAL);
        setLayoutManager(lm);

        setClipToPadding(false);
        setPaddingRelative((int) Const.convertDpToPixel(12,getContext()),0,(int) Const.convertDpToPixel(12,getContext()),0);

        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(this);
        runAuto = a.getBoolean(R.styleable.RecyclerViewPager_svp_runAuto, false);
        colorActiveIndicator = a.getColor(R.styleable.RecyclerViewPager_svp_colorActiveIndicator, 0xDE000000);
        colorInactiveIndicator = a.getColor(R.styleable.RecyclerViewPager_svp_colorInactiveIndicator, 0x33000000);
        millis = a.getInt(R.styleable.RecyclerViewPager_svp_timeMillis,2000);


    }

    private void scrollToNext(){
        if(count>=getAdapter().getItemCount()-1)
            count=-1;

        smoothScrollToPosition(count+1);

    }

    public void addItem(PagerModel pagerModel){
        this.pagerModels.add(pagerModel);
    }

    public void start(){

        adapter=new PagerAdapter(getContext(),pagerModels);
        setAdapter(adapter);
        if(runAuto) {
            if(timer==null)
                timer=new Timer();

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    scrollToNext();
                }
            }, millis, millis);
        }else {
            timer=null;
        }

        addItemDecoration(new Indicator(colorActiveIndicator,colorInactiveIndicator));
        addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                LinearLayoutManager layoutManager = ((LinearLayoutManager)getLayoutManager());
                int firstVisiblePosition = layoutManager.findFirstVisibleItemPosition();
                count=firstVisiblePosition;
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

    }

    public void setAutoRun(boolean auto){
        this.runAuto=auto;
    }

    public void setColorActiveIndicator(int color) {
        this.colorActiveIndicator = color;
    }

    public void setColorInactiveIndicator(int color) {
        this.colorInactiveIndicator = color;
    }

    public void setTime(int timeMillis) {
        this.millis = millis;
    }

    public void setOnItemClickListener(PagerAdapter.OnItemClickListener itemClickListener){
        try {

            ((PagerAdapter) getAdapter()).setOnclickItemListener(itemClickListener);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
