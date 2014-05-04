package com.example.vanillatravel;


import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;


public class TravelDetailActivity extends Activity implements 
ViewFactory,OnItemSelectedListener,OnItemLongClickListener {
	
	private ImageSwitcher is;
	private Gallery gallery;
	
	private ArrayList<Integer> mImageIds;
	
	private ShareActionProvider mShareActionProvider;

	
//	private Integer[] mImageIds = { R.drawable.b, R.drawable.c,
//			R.drawable.d, R.drawable.a, R.drawable.e, };
	
//	private Integer[] mThumbIds = { R.drawable.b, R.drawable.c,
//			R.drawable.d, R.drawable.a, R.drawable.e, };
	
	ImageAdapter adapter ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_travel_detail);
	
//		ActionBar actionBar = getActionBar();
//		actionBar.setDisplayHomeAsUpEnabled(true);
		mImageIds = new ArrayList<Integer>();
		mImageIds.add(R.drawable.a);
		mImageIds.add(R.drawable.b);
		mImageIds.add(R.drawable.c);
		mImageIds.add(R.drawable.d);
		mImageIds.add(R.drawable.e);

		
		is = (ImageSwitcher) findViewById(R.id.switcher);
		is.setFactory(this);
		
		is.setInAnimation(AnimationUtils.loadAnimation(this,
				android.R.anim.fade_in));
		is.setOutAnimation(AnimationUtils.loadAnimation(this,
				android.R.anim.fade_out));

		gallery = (Gallery) findViewById(R.id.gallery);
		
		adapter= new ImageAdapter(this);
		gallery.setAdapter(adapter);
		gallery.setOnItemSelectedListener(this);
		gallery.setOnItemLongClickListener(this);
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.travel_detail, menu);
	    MenuItem shareItem = menu.findItem(R.id.action_share);
	    mShareActionProvider =(ShareActionProvider) shareItem.getActionProvider();
	    Intent intent = new Intent(Intent.ACTION_SEND);
	    intent.setType("image/*");
	    setShareIntent(intent);
	    return true;
	}
		
	private void setShareIntent(Intent intent) {
		if (mShareActionProvider != null) {
			mShareActionProvider.setShareIntent(intent);
		}
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


	@Override
	public View makeView() {
		ImageView i = new ImageView(this);
		i.setBackgroundColor(0xFF000000);
		i.setScaleType(ImageView.ScaleType.FIT_CENTER);
		i.setLayoutParams(new ImageSwitcher.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		return i;
	}
	
	
	public class ImageAdapter extends BaseAdapter {

		
		public ImageAdapter(Context c) {
			mContext = c;
	
		}

		public int getCount() {
			return mImageIds.size();
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView i = new ImageView(mContext);

			i.setImageResource(mImageIds.get(position));
			i.setAdjustViewBounds(true);
			i.setLayoutParams(new Gallery.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			return i;
		}

		private Context mContext;

	}


	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		is.setImageResource(mImageIds.get(position));

	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view, final int position,
			long id) {
		// TODO Auto-generated method stub
		Dialog alertdDialog = new AlertDialog.Builder(this).
				setTitle("删除该照片").
				setMessage("确定要删除？").
				setPositiveButton("确定", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						mImageIds.remove(position);
						adapter.notifyDataSetChanged();
					}
				}).setNegativeButton("取消", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						
					}
				}).create();
		alertdDialog.show();
		
				
		return false;
	}

	

}
