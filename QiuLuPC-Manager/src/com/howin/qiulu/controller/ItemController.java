package com.howin.qiulu.controller;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.baidu.ueditor.define.FileType;
import com.howin.qiulu.pojo.Item;
import com.howin.qiulu.pojo.OnSale;
import com.howin.qiulu.pojo.Sku;
import com.howin.qiulu.result.QiuluResult;
import com.howin.qiulu.service.ItemService;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.sf.json.JSONArray;
/**
 * 
* @Title: ItemController
* @Description: 
* @author 吴磊
* @date 2017年2月24日下午4:46:14
 */
@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月24日下午4:46:20
	 * @description 
	 * @param item
	 * @return QiuluResult
	 */
	@RequestMapping("/save")
	@ResponseBody
	public QiuluResult saveItem(Item item){
		QiuluResult result = itemService.saveItem(item);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月25日下午1:53:48
	 * @description 
	 * @return QiuluResult
	 */
	@RequestMapping("/getAll")
	@ResponseBody
	public QiuluResult getAllItem(@RequestParam(defaultValue="1")int pageNumber){
		QiuluResult result = itemService.getAllItem(pageNumber);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月25日下午2:07:32
	 * @description 
	 * @param id
	 * @return QiuluResult
	 */
	@RequestMapping("/get")
	@ResponseBody
	public QiuluResult getItem(int id){
		QiuluResult result = itemService.getItem(id);
		return result;
	}
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年2月25日下午3:07:50
	 * @description 
	 * @param item
	 * @return QiuluResult
	 */
	@RequestMapping("/update")
	@ResponseBody
	public QiuluResult updateItem(Item item){
		QiuluResult result = itemService.updateItem(item);
		return result;
	}
	
	@RequestMapping("/addOnSaleSkuImage")
	@ResponseBody
	public QiuluResult addOnSaleSkuImage(@RequestParam(value = "file", required = false)MultipartFile file){
		boolean flg=true;
		QiuluResult qiuluResult=new QiuluResult();
		String fileName=null;
		if (!file.isEmpty()) {
			try {
				// 文件保存路径
				/*String path = "F:\\pic\\qiulu\\onSale"; */ 
				
				
				//Linux 下的路径
				String path = "/apps/apache-tomcat-8.5.11/webapps/pic/qiulu/onSale"; 
				//获取文件名
				fileName = file.getOriginalFilename();  
				//得到上传封面图片的后缀
				String suffix = FileType.getSuffixByFilename(fileName);
				 Date date = new Date();
				 Long d=date.getTime();
				 String s=d.toString();
				 fileName=s.concat(suffix);
				 System.out.println(fileName);
				File targetFile = new File(path,fileName);
				  if(!targetFile.exists()){  
					  targetFile.mkdirs();
				 }  
				// 转存文件
				file.transferTo(targetFile);
				//图片压缩处理
				/*Thumbnails.of(path.concat("\\").concat(fileName)).sourceRegion(Positions.CENTER,700,270)
				.size(700,270).toFile(path.concat("\\").concat(fileName)); 
				Thumbnails.of(path.concat("\\").concat(fileName)).scale(1f).outputQuality(0.25f).toFile(path.concat("\\").concat(fileName));*/
				
				//Linux 下的路径
				Thumbnails.of(path.concat("/").concat(fileName)).sourceRegion(Positions.CENTER,700,270)
				.size(700,270).toFile(path.concat("/").concat(fileName)); 
				Thumbnails.of(path.concat("/").concat(fileName)).scale(1f).outputQuality(0.25f).toFile(path.concat("/").concat(fileName));
				
				
			} catch (Exception e) {
				 flg=false;
				e.printStackTrace();
			}
		
			
			if(flg){
				 qiuluResult.setMessage("上传成功");
        		 qiuluResult.setStatus(true);
        		 qiuluResult.setObject(fileName);
			}
			else{
				qiuluResult.setMessage("保存失败");
        		qiuluResult.setStatus(false);
			}
	   }
		else{
			qiuluResult.setMessage("保存失败,图片为空");
    		qiuluResult.setStatus(false);
    		
		   }
		  return qiuluResult;
	 }
	/**
	 * 
	 * @author 张磊
	 * @Description: 添加活动商品
	 * @return QiuluResult
	 * @date 2017年4月25日 下午2:42:48
	 * @param file
	 * @param skuId
	 * @param price
	 * @param stime
	 * @param etime
	 * @param type
	 * @param isShow
	 * @return
	 */
	@RequestMapping("/addOnSaleSku")
	@ResponseBody
	public QiuluResult addOnSaleSku(String imageName,Integer skuId,Float price,Timestamp stime,Timestamp etime,Integer type,Integer isShow){
		String[] newName=new String[1];
		QiuluResult qiuluResult=new QiuluResult();
		newName[0]=imageName;
        
    	       Sku sku=itemService.getSku(skuId);
    	       sku.setDiscount((double)price);
    	       if(type==1){
    	    	   sku.setEtime(etime);
    	       }
    	       JSONArray json = JSONArray.fromObject(newName);
    	       sku.setSaleImage(json.toString());
    	       sku.setSaleType(type);
    	       sku.setIsShow(isShow);
    	     boolean b = itemService.toaddOnSaleSku(sku);
        	if(b){
        		  OnSale sale=new OnSale();
        		  sale.setSkuId(skuId);
        		  sale.setPrice(price);
        		  sale.setEtime(etime);
        		  sale.setStime(stime);
        		  sale.setStatus(type);
        		 boolean x= itemService.toaddOnSale(sale);
        		 if(x){
        		 qiuluResult.setMessage("上传成功");
        		 qiuluResult.setStatus(true);
        		 qiuluResult.setObject(imageName);
        		      }
        	  }
        	  else{
        		qiuluResult.setMessage("保存失败");
        		qiuluResult.setStatus(false);
        		
        	   }
		    return qiuluResult;
	}
    /**
     * 
     * @author 张磊
     * @Description: TODO
     * @return QiuluResult
     * @date 2017年4月25日 下午3:04:30
     * @param skuId
     * @return
     */
	 @RequestMapping("/endOnSaleSku")
	 @ResponseBody
	public QiuluResult endOnSaleSku(Integer skuId){
		QiuluResult result = itemService.endOnSaleSku(skuId);
		return result;
	  }
}
