package com.android.www.recyclerdynamica.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.www.recyclerdynamica.R;
import com.bumptech.glide.Glide;

public class SliderAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater inflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public int[] slideImages = {
            R.drawable.hr1,
            R.drawable.hr2,
            R.drawable.hr3,
            R.drawable.hr4,
            R.drawable.hr5,
            R.drawable.hr6

    };

    @Override
    public int getCount() {
        return slideImages.length;
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slider_layout,container,false);

        ImageView slideImage = (ImageView)view.findViewById(R.id.slideImageView);


        slideImage.setImageResource(slideImages[position]);
//        Glide
//                .with(context)
//                .load(slideImages[position])
//                .into(slideImage);

        container.addView(view);
        return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
