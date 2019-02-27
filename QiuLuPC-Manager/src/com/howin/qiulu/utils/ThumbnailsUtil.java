package com.howin.qiulu.utils;

import java.io.IOException;


import net.coobird.thumbnailator.Thumbnails;
/**
 * 
* @Title: ThumbnailsUtil
* @Description: 将图片转存为80x80和500x500两种格式
* @author 吴磊
* @date 2017年2月22日下午2:47:06
 */
public class ThumbnailsUtil {

	public static void transform(String name){

		String beforePath = PathUtil.PIC_PATH+name;
		String afterPath_80 = PathUtil.PIC_PATH_80X80+name;
		String afterPath_500 = PathUtil.PIC_PATH_500X500+name;
		String afterPath_240 = PathUtil.PIC_PATH_240X240+name;
		try {
			Thumbnails.of(beforePath).size(80, 80).toFile(afterPath_80);
			Thumbnails.of(beforePath).size(500, 500).toFile(afterPath_500);
			Thumbnails.of(beforePath).size(240, 240).toFile(afterPath_240);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
