package com.example.vanillatravel;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.example.vanillatravel.network.MyVolley;
import com.example.vanillatravel.network.volleyMethods;

public class IndexFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		return inflater.inflate(R.layout.fragment_index, container, false);
        
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub		
		super.onActivityCreated(savedInstanceState);
		ImageView imageView = (ImageView) getView().findViewById(R.id.ImageView1);
		volleyMethods.loadImage(imageView, "http://a.hiphotos.baidu.com/album/h%3D800%3Bcrop%3D0%2C0%2C1280%2C800/sign=5f024b518326cffc762ab2b2893a29e2/72f082025aafa40fa3bcf315aa64034f79f019fb.jpg");
//		RequestQueue mRequestQueue=Volley.newRequestQueue(this.getActivity());
//        final LruCache<String, Bitmap> lruCache = new LruCache<String, Bitmap>(20); 
//        
//        ImageCache imageCache = new ImageCache() {
//			@Override
//			public void putBitmap(String key, Bitmap value) {
//				// TODO Auto-generated method stub
//				lruCache.put(key, value);
//				Log.v("network","imageCached");
//			}
//			
//			@Override
//			public Bitmap getBitmap(String key) {
//				// TODO Auto-generated method stub
//				return lruCache.get(key);
//				
//			}
//		};
//		
//        ImageLoader imageLoader = new ImageLoader(mRequestQueue, imageCache);
//        networkImageView.setTag("url");
//        
//        networkImageView.setImageUrl(Constant.server_url+"pujidao.jpg", imageLoader);
//        networkImageView.setImageUrl("http://a.hiphotos.baidu.com/album/h%3D800%3Bcrop%3D0%2C0%2C1280%2C800/sign=5f024b518326cffc762ab2b2893a29e2/72f082025aafa40fa3bcf315aa64034f79f019fb.jpg", imageLoader);
//		Log.v("network","imageLoaded");

	}
}
