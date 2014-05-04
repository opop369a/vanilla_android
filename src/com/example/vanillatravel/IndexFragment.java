package com.example.vanillatravel;

import com.example.vanillatravel.viewfeature.ImageAdapter;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class IndexFragment extends Fragment {
	
	private int recom_total = 3;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.fragment_index, container, false);
		
        
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	} 
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub		
		super.onActivityCreated(savedInstanceState);
		   final ImageView iv= (ImageView)getView().findViewById(R.id.ImageView01);
           Gallery g = (Gallery) getView().findViewById(R.id.Gallery01);
           g.setAdapter(new ImageAdapter(getActivity(),"http://192.168.95.2/~BAO/travel_android/Recommendation/recom" , recom_total));
           
           g.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub\
				iv.setImageDrawable(((ImageView)view).getDrawable());
			}
		});
          
           
           Button button = (Button) getView().findViewById(R.id.button1);
           button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), NewTravelActivity.class);
				getActivity().startActivityForResult(intent, 0);
			}
		});
	}
}
