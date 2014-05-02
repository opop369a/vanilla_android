package com.example.vanillatravel.test;

import java.io.File;


public class testNetwork {
	
	public void testJudgeDir(String url){
		File file = new File(url);
		if (file.isDirectory()) {
			System.out.println(url+"isdir");
		}else
			System.out.println(url+"isnotdir");
	}
	
	public static void main(String[] args) {
		testNetwork network = new testNetwork();
		network.testJudgeDir("http://a.hiphotos.baidu.com/album/h%3D800%3Bcrop%3D0%2C0%2C1280%2C800/sign=5f024b518326cffc762ab2b2893a29e2/72f082025aafa40fa3bcf315aa64034f79f019fb.jpg");
	}

}
