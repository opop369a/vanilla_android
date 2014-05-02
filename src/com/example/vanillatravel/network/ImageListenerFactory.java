package com.example.vanillatravel.network;

import android.util.Log;
import android.widget.ImageView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader.ImageContainer;
import com.android.volley.toolbox.ImageLoader.ImageListener;

public class ImageListenerFactory{
	private final static String TAG = "ImageListenerFactory";
    
    public static ImageListener getImageListener(final ImageView view,
        final int defaultImageResId, final int errorImageResId) {
    return new ImageListener() {
    	
        @Override
        public void onErrorResponse(VolleyError error) {
            if (errorImageResId != 0) {
                view.setImageResource(errorImageResId);
            }
        }

        @Override
        public void onResponse(ImageContainer response, boolean isImmediate) {
            if (response.getBitmap() != null) {
                  Log.i("assert", view.getTag().toString());
                if(view.getTag().toString() == response.getRequestUrl()){
                        view.setImageBitmap(response.getBitmap());
                }else{
                        Log.i(TAG, "Í¼Æ¬´íÎ»");
                }
            } else if (defaultImageResId != 0) {
                view.setImageResource(defaultImageResId);
            }
        }
    };
}
}