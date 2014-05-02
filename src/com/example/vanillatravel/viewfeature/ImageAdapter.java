package com.example.vanillatravel.viewfeature;

import java.io.File;
import java.lang.reflect.Field;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.media.ImageReader;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader.ImageContainer;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.example.vanillatravel.R;
import com.example.vanillatravel.network.MyVolley;


public class ImageAdapter extends BaseAdapter {
	
	private Bitmap[] bitmaps ;
	
	private Context mContext;
	
	int mGalleryItemBackground;
	
	private static final String TAG = "ImageAdapter";
	
	
	public ImageAdapter(Context context) {
		// TODO Auto-generated constructor stub
		mContext = context;
        TypedArray a = mContext.obtainStyledAttributes(R.styleable.HelloGallery);
        mGalleryItemBackground = a.getResourceId(
                R.styleable.HelloGallery_android_galleryItemBackground, 0);
        a.recycle();
	}
	
	public ImageAdapter(Context context,String baseUrl,int totalNum) {
		// TODO Auto-generated constructor stub
		this(context);
		bitmaps = new Bitmap[totalNum];
		ImageListener imageListener = new MyImageListener(totalNum);
		
		for (int i = 0; i < totalNum; i++) {
	        MyVolley.getImageLoader().get(baseUrl+i+".jpg",imageListener); 
	        Log.i(TAG, "Remote Image Reqed");
		}
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return bitmaps.length;
	}

	@Override
	public Object getItem(int pos) {
		// TODO Auto-generated method stub
		return pos;
	}

	@Override
	public long getItemId(int pos) {
		// TODO Auto-generated method stub
		return pos;
	}

	@Override
	public View getView(int pos, View convertview, ViewGroup parent) {
		// TODO Auto-generated method stub
		ImageView imageView = new ImageView(mContext);
		if (bitmaps[pos] == null) {
			imageView.setImageResource(R.drawable.ic_launcher);
			imageView.setId(R.drawable.ic_launcher);
		}
		else {
			imageView.setImageBitmap(bitmaps[pos]);
			imageView.setId(-1);
		}
		imageView.setLayoutParams(new Gallery.LayoutParams(200, 160));
		imageView.setScaleType(ImageView.ScaleType.FIT_XY);
		Log.i(TAG, "getView called");
		return imageView;
	}
	
	
	class MyImageListener implements ImageListener {
		int pos ;
		int total;
		
		public MyImageListener(int totalNum){
			this.total = totalNum;
			this.pos = 0;
		}

		@Override
		public void onErrorResponse(VolleyError arg0) {
			// TODO Auto-generated method stub
			bitmaps[pos++] = null;
			Log.e(TAG, "err response received");
		}

		@Override
		public void onResponse(ImageContainer response, boolean isImmediate) {
			// TODO Auto-generated method stub
			if (response.getBitmap() != null) {
				bitmaps[pos++] = response.getBitmap();
				Log.e(TAG, "response received");
				notifyDataSetChanged();
			}
		}
		
	}


}
