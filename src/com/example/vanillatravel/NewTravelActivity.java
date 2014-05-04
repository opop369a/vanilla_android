package com.example.vanillatravel;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.os.Build;

public class NewTravelActivity extends Activity {

	private EditText tNameEditText;
	private EditText tPlaceEditText;
	private EditText tTimeEditText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_travel);
		

	    ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
		
		tNameEditText = (EditText) findViewById(R.id.editText1);
		tPlaceEditText = (EditText) findViewById(R.id.editText2);
		tTimeEditText = (EditText) findViewById(R.id.editText3);
		
		

		findViewById(R.id.dummy_button).setOnTouchListener(
				new OnTouchListener() {
					
					@Override
					public boolean onTouch(View arg0, MotionEvent arg1) {
						// TODO Auto-generated method stub
						Bundle bundle = new Bundle();
						bundle.putString("travel_name", tNameEditText.getText().toString());
						bundle.putString("travel_place", tPlaceEditText.getText().toString());
						bundle.putString("travel_time", tTimeEditText.getText().toString());

						Intent intent = new Intent();
						intent.putExtras(bundle);
						setResult(RESULT_OK, intent);
						finish();
						return false;
					}
				});
	}




}
