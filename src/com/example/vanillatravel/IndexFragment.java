package com.example.vanillatravel;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.vanillatravel.viewfeature.ImageAdapter;

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
           g.setAdapter(new ImageAdapter(getActivity(),"http://192.168.96.2/~BAO/travel_android/Recommendation/recom" , recom_total));
           
           g.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub\
				Toast.makeText(getActivity(), ""+position,Toast.LENGTH_LONG).show();
				iv.setImageDrawable(((ImageView)view).getDrawable());
			}
		});
	}
}
