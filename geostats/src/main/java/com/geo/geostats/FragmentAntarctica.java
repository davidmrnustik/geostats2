package com.geo.geostats;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.geo.geostats.Constants;
import com.geo.viewpagerindicator.TabPageIndicator;

import java.util.Locale;

public class FragmentAntarctica extends Fragment{
	
	ViewPager vp;
	private vpAdapter miAdapter;
	TextView tvChart;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

		View v = inflater.inflate(R.layout.fragment_antarctica, container, false);
		
		vp = (ViewPager) v.findViewById(R.id.viewpager);
        miAdapter = new vpAdapter();
        vp.setAdapter(miAdapter);
        
        tvChart = (TextView)v.findViewById(R.id.chartNo);
		tvChart.append(" 71");
		
        TabPageIndicator indicator = (TabPageIndicator)v.findViewById(R.id.indicator);
        indicator.setViewPager(vp);
        
		return v;
	}
	private class vpAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 2;
		}
		
		public CharSequence getPageTitle(int position) {
            return Constants.CONTENT_ANTARCTICA[position % Constants.CONTENT_ANTARCTICA.length].toUpperCase(Locale.getDefault());
        }

		@Override
		public boolean isViewFromObject(View view, Object object) {
			// TODO Auto-generated method stub
			return view == ((ScrollView)object);
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			((ViewPager)container).removeView((ScrollView)object);
		}

		@Override
		public void finishUpdate(ViewGroup container) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Object instantiateItem(View container, int position) {
			// TODO Auto-generated method stub
			
			LayoutInflater inflater = (LayoutInflater)container.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View v = null;
			switch(position){
			case 0:
				v = inflater.inflate(R.layout.vp_antarctica_mountains, null);
				tvChart = (TextView)v.findViewById(R.id.chartNo);
				tvChart.append(" 72");
				break;
			case 1:
				v = inflater.inflate(R.layout.vp_antarctica_weather, null);
				tvChart = (TextView)v.findViewById(R.id.chartNo);
				tvChart.append(" 73");
				break;
			}
			((ViewPager)container).addView(v, 0);
			return v;
		}

		@Override
		public Parcelable saveState() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void startUpdate(ViewGroup container) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
