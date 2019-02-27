package com.howin.qiulu.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnails;

public class UploadImageUtil {

	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月18日下午4:24:48
	 * @description 将上传的图片重新命名并存储在本地磁盘
	 * @param pic
	 * @return String
	 */
	public static String UploadPic(MultipartFile pic){
		String originalFilename = pic.getOriginalFilename();
		
		String newFileName = null;
		
		if(pic != null && originalFilename != null && originalFilename.length() != 0){
			
			String pic_path = PathUtil.PIC_PATH;
			
			newFileName = UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
			
			File newFile = new File(pic_path+newFileName);
			
			try {
				pic.transferTo(newFile);
				
				//图片处理
				/*Thumbnails.of(pic_path.concat("\\").concat(newFileName)).scale(1f).outputQuality(0.25f).toFile(pic_path.concat("\\").concat(newFileName));*/
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return newFileName;
	}
}
