package com.example.vanillatravel.network;

import com.example.vanillatravel.R;

import android.widget.ImageView;

public class volleyMethods {
	
	public static void loadImage(ImageView imageView, String imgUrl){
        MyVolley.getImageLoader().get(imgUrl, 
                        //ImageListenerFactoryΪ�Զ����࣬��װ�󼴿ɻ�ȡͼƬ��Դ�����UI����
           ImageListenerFactory.getImageListener(//�ο�ImageLoader.getImageListener()
                                        imageView,                 // ImageView����
                                        R.drawable.ic_launcher, // Ĭ��Image���������Ӧ��Ϊ0
                                        R.drawable.ic_launcher)
                                        ); // ����Image���������Ӧ��Ϊ0
}
}
