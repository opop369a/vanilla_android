package com.example.vanillatravel.network;

import com.example.vanillatravel.R;

import android.widget.ImageView;

public class volleyMethods {
	
	public static void loadImage(ImageView imageView, String imgUrl){
        MyVolley.getImageLoader().get(imgUrl, 
                        //ImageListenerFactory为自定义类，封装后即可获取图片资源，完成UI更新
           ImageListenerFactory.getImageListener(//参考ImageLoader.getImageListener()
                                        imageView,                 // ImageView对象
                                        R.drawable.ic_launcher, // 默认Image，如果不设应置为0
                                        R.drawable.ic_launcher)
                                        ); // 错误Image，如果不设应置为0
}
}
