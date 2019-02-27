//var upload = (function(){
	
	
	//初始化sku图片表单
	function initImageForm(skuArray){
		var sku;
		sku = skuArray;
		var div = $('.form-group')[0];
		var temp = '';
//		div.innerHTML = '';
		$(div).empty();
		sku.forEach(function(item,index,array){
			temp += '<div id="file-div'+index+'">'+item.paramData+'<input id="file" type="file" name="image" multiple class="file"\
				data-overwrite-initial="false" data-min-file-count="1" ></div>';
		});
		$(div).append(temp);
			
		for(var i = 0, len = sku.length; i < len; i ++){
			btup(i,sku[i].id);
		};
	}
	
	
//	
//	return {initImageForm:initImageForm};
//}())
