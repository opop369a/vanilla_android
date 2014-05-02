package com.example.vanillatravel.network;

import com.android.volley.toolbox.ImageLoader.ImageCache;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.util.Log;

/**
 * LruCache��������࣬����ʵ����ImageCache�ӿڣ���ʵ����LruCache
 * һ��bitmap�����LruCache�б����������ᱻ������BitmapSoftRefCache�У�����ϸÿ�ܱ���֧�ֵ�Ӳ�̻��棬�������ͼƬ��������
 * 
 * BitmapLruCache.java
 * @author zimo2013
 * @see http://blog.csdn.net/zimo2013
 * 
 */
public class BitmapLruCache extends LruCache<String, Bitmap> implements ImageCache {
        private static final String TAG = "BitmapLruCache";

        private BitmapSoftRefCache softRefCache;

        public BitmapLruCache(int maxSize) {
                super(maxSize);
                softRefCache = new BitmapSoftRefCache();
        }

        @Override
        protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight();
        }

        @Override
        protected void entryRemoved(boolean evicted, String key, Bitmap oldValue, Bitmap newValue) {
                if (evicted) {
                        Log.i(TAG, "�ռ�����������ͼƬ������:" + key);
                        // ����������bitmap���������������BitmapSoftRefCache
                        softRefCache.putBitmap(key, oldValue);
                }
        }

        /**
         * �õ��������
         */
        @Override
        public Bitmap getBitmap(String url) {
                Bitmap bitmap = get(url);
                // ���bitmapΪnull�����Դ������û����в���
                if (bitmap == null) {
                        bitmap = softRefCache.getBitmap(url);
                } else {
                        Log.i(TAG, "LruCache���У�" + url);
                }
                return bitmap;
        }

        /**
         * ��ӻ������
         */
        @Override
        public void putBitmap(String url, Bitmap bitmap) {
                put(url, bitmap);
        }

}