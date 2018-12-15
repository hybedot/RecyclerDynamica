package com.android.www.recyclerdynamica;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.android.www.recyclerdynamica.Adapters.RecyclerViewDataAdapter;
import com.android.www.recyclerdynamica.Adapters.SliderAdapter;
import com.android.www.recyclerdynamica.Model.SectionDataModel;
import com.android.www.recyclerdynamica.Model.SingleItemModel;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    SliderAdapter sliderAdapter;
    Handler handler;
    Runnable runnable;
    Timer timer;

    ArrayList<SectionDataModel> sectionalData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sectionalData = new ArrayList<>();

        viewPager = (ViewPager)findViewById(R.id.main_view_pager);
        circleIndicator = (CircleIndicator)findViewById(R.id.circle_indicator);

        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        circleIndicator.setViewPager(viewPager);

        schedulePager();
        createDummyData();

        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(sectionalData,this);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.main_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);

    }

    private void createDummyData(){
        ArrayList<SingleItemModel> singleDataArray = new ArrayList<>();
        singleDataArray.add(new SingleItemModel("Logan","api.getImage.com","Story of ..."));
        singleDataArray.add(new SingleItemModel("SpiderMan","api.getImage.com","Story of ..."));
        singleDataArray.add(new SingleItemModel("Logan","api.getImage.com","Story of ..."));
        singleDataArray.add(new SingleItemModel("SpiderMan","api.getImage.com","Story of ..."));
        singleDataArray.add(new SingleItemModel("Logan","api.getImage.com","Story of ..."));
        singleDataArray.add(new SingleItemModel("SpiderMan","api.getImage.com","Story of ..."));
        singleDataArray.add(new SingleItemModel("Logan","api.getImage.com","Story of ..."));
        singleDataArray.add(new SingleItemModel("SpiderMan","api.getImage.com","Story of ..."));
        singleDataArray.add(new SingleItemModel("Logan","api.getImage.com","Story of ..."));
        singleDataArray.add(new SingleItemModel("SpiderMan","api.getImage.com","Story of ..."));

        sectionalData.add(new SectionDataModel("ACTION",singleDataArray));
        sectionalData.add(new SectionDataModel("ROMAMCE",singleDataArray));
        sectionalData.add(new SectionDataModel("ADVENTURE",singleDataArray));
        sectionalData.add(new SectionDataModel("KIDS",singleDataArray));
        sectionalData.add(new SectionDataModel("COMEDY",singleDataArray));
        sectionalData.add(new SectionDataModel("DRAMA",singleDataArray));
        sectionalData.add(new SectionDataModel("ACTION",singleDataArray));
        sectionalData.add(new SectionDataModel("ROMAMCE",singleDataArray));


    }

    private  void schedulePager(){
        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                int i = viewPager.getCurrentItem();

                if (i == sliderAdapter.slideImages.length -1){
                    i = 0;
                    viewPager.setCurrentItem(i);
                }else {
                    i++;
                    viewPager.setCurrentItem(i, true);
                }
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        },4000, 4000);
    }

}
