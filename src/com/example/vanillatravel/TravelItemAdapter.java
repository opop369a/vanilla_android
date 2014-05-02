package com.example.vanillatravel;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TravelItemAdapter extends ArrayAdapter<TravelItem>{
	Context context;
	int resource;
	List<TravelItem> data;

	public TravelItemAdapter(Context context, int resource,
			List<TravelItem> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.resource = resource;
		this.data = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View row = convertView;
		TravelItemHolder holder = null;
		
		if(row == null){
			LayoutInflater inflater = ((Activity)context).getLayoutInflater();
			row = inflater.inflate(resource, parent, false);
			
			holder = new TravelItemHolder();
			holder.imgView = (ImageView)row.findViewById(R.id.travelitemimg);
			holder.txtView = (TextView)row.findViewById(R.id.travelitemtext);
			
			row.setTag(holder);
		}else{
			holder = (TravelItemHolder)row.getTag();
		}
		
		TravelItem item = data.get(position);
		holder.txtView.setText(item.text);
		holder.imgView.setImageResource(item.img);
		
		return row;
	}
	
	
	static class TravelItemHolder{
		ImageView imgView;
		TextView txtView;
	}
}

