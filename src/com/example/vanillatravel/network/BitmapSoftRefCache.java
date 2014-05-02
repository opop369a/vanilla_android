package com.example.vanillatravel.network;

import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;

import android.graphics.Bitmap;
import android.util.Log;

import com.android.volley.toolbox.ImageLoader.ImageCache;

/**
 * �����û��������
 * 
 * BitmapSoftRefCache.java
 * @author zimo2013
 * @see http://blog.csdn.net/zimo2013
 *
 */
public class BitmapSoftRefCache implements ImageCache{
        private static final String TAG = "BitmapSoftRefCache";
        
        private LinkedHashMap<String, SoftReference<Bitmap>> map;
        public BitmapSoftRefCache() {
                map = new LinkedHashMap<String, SoftReference<Bitmap>>();
        }

        /**
         * �������ü����еõ�Bitmap����
         */
        @Override
        public Bitmap getBitmap(String url) {
                Bitmap bitmap = null;
                SoftReference<Bitmap> softRef = map.get(url);
                if(softRef != null){
                        bitmap = softRef.get();
                        if(bitmap == null){
                                map.remove(url); //��map���Ƴ�
                                Log.w(TAG, url+"�����Ѿ���GC����");
                        }else{
                                Log.i(TAG, "����"+url);
                        }
                }
                return bitmap;
        }

        /**
         * �������ü��������bitmap����
         */
        @Override
        public void putBitmap(String url, Bitmap bitmap) {
                SoftReference<Bitmap> softRef = new SoftReference<Bitmap>(bitmap);
                map.put(url, softRef);
        }

}