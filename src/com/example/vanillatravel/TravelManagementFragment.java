package com.example.vanillatravel;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.app.ListFragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;

public class TravelManagementFragment extends ListFragment {
	
	List<TravelItem> data;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		data = new ArrayList<TravelItem>();
		appendData();
		
		ArrayAdapter<TravelItem> adapter = new TravelItemAdapter(getActivity(), R.layout.travlelistitem, data);
		setListAdapter(adapter);
	}
	
	private void appendData(){
		if(data==null)
			return;
		
		data.add(new TravelItem("威尼斯之旅", R.drawable.a));
		data.add(new TravelItem("赫尔辛基的回忆", R.drawable.b));
		data.add(new TravelItem("布宜诺斯艾利斯", R.drawable.c));
		data.add(new TravelItem("威斯康星游学", R.drawable.d));
		data.add(new TravelItem("阿姆斯特丹", R.drawable.e));
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.fragment_travelmanagement, container, false);
	}

}
