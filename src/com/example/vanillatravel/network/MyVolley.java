package com.example.vanillatravel.network;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * MyVolley.java
 * @author zimo2013
 * [url=home.php?mod=space&uid=189949]@See[/url] http://blog.csdn.net/zimo2013
 * 
 */
public class MyVolley {
        private static final String TAG = "MyVolley";

        private static MyVolley instance;
        private static RequestQueue mRequestQueue;
        private static ImageLoader mImageLoader;
        private final static int RATE = 8; // Ĭ�Ϸ������ռ�ļ���֮һ

        private MyVolley(Context context) {
                mRequestQueue = Volley.newRequestQueue(context);

                // ȷ����LruCache�У����仺��ռ��С,Ĭ�ϳ���������ռ�� 1/8
                ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
                int maxSize = manager.getMemoryClass() / RATE; // ���� 64M/8,��λΪM
                
                //BitmapLruCache�Զ��建��class���ÿ�ܱ���֧�ֶ������棬��BitmapLruCache��װһ�������û���
                mImageLoader = new ImageLoader(mRequestQueue, new BitmapLruCache(1024*1024*maxSize));

                Log.i(TAG, "MyVolley��ʼ�����");
        }

        /**
         * ��ʼ��Volley��ض�����ʹ��VolleyǰӦ����ɳ�ʼ��
         * 
         * @param context
         */
        public static void init(Context context) {
                if (instance == null) {
                        instance = new MyVolley(context);
                } else {
                        Log.w(TAG, "�Ѿ���ʼ����������Ҫ�ٴε���init()");
                }
        }

        /**
         * �õ�������ж���
         * 
         * @return
         */
        public static RequestQueue getRequestQueue() {
                throwIfNotInit();
                return mRequestQueue;
        }

        /**
         * �õ�ImageLoader����
         * 
         * @return
         */
        public static ImageLoader getImageLoader() {
                throwIfNotInit();
                return mImageLoader;
        }

        /**
         * ����Ƿ���ɳ�ʼ��
         */
        private static void throwIfNotInit() {
                if (instance == null) {// ��δ��ʼ��
                        throw new IllegalStateException("MyVolley��δ��ʼ������ʹ��ǰӦ��ִ��init()");
                }
        }
}