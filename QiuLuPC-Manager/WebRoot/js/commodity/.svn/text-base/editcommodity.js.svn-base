var itemFun = (function(){
	var item ;
	var skus ;
	
	function getSkus(){
		return skus;
	}
	
	$.ajax({
		type:'post',
		url:'/QiuLuPC-Manager/item/get',
		data:{id:request('itemId')},
		dataType:'json',
		async:true,
		success:function(data){
			item = data.object.item;
			skus = data.object.skus;
			loadItem(item);
			loadSKU(skus);
		}
	});
	
	//加载商品初始值
	function loadItem(item){
		$('.itemName').val(item.name);
		var paramData = JSON.parse(item.paramData);
		var tbody = $('.item-param')[0];
		var temp_html = '';
		paramData.forEach(function(element,index,array){
			temp_html += '<tr class="item-param"><td class="tdleft">'+element.group+'</td><td class="add"></td></tr>';
			element.param.forEach(function(ele,index){
				temp_html += '<tr class="item-param"><td class="tdleft" style="float: right;">'+ele.k+'</td>\
								<td class="add"><p><input type="text" name="" id="" value="'+ele.v+'" class="text" lay-verify="required|noSpecial"/></p></td>\
							</tr>';
			});
		});
		
		$("#editor-html").html(item.itemDetail);
		
		$('.item-param-tbody').append(temp_html);
	}
	
	//加载sku表
	function loadSKU(skuArray){
		var paramData;
		var temp_html = '';
		if(skuArray && skuArray.length){
			paramData = JSON.parse(skuArray[0].paramData);
			paramData.forEach(function(ele,index,array){
				temp_html += '<th>'+ele.k+'</th>';
			});
			$('.sku-table thead tr').append(temp_html + '<th>价格</th><th>库存</th><th>销量</th><th>操作</th>');
			temp_html = '';
			
			skuArray.forEach(function(ele){
				var temp = '';
				
				JSON.parse(ele.paramData).forEach(function(i){
					temp += '<td>'+i.v+'</td>';
				});
				if(ele.saleType == 0){
					temp_html += '<tr data-id="'+ele.id+'">\
					 '+temp+'\
					<td>'+ele.price+'</td>\
					<td>'+ele.repertory+'</td>\
					<td>'+ele.salesVolume+'</td>\
					<td><a href="javaScript:void(0)" class="onsale">设置活动</a>&nbsp;&nbsp;&nbsp;<a href="javaScript:void(0)" class="edit-SKU">编辑</a></td>\
				</tr>';
				}else{
					temp_html += '<tr data-id="'+ele.id+'">\
					 '+temp+'\
					<td>'+ele.price+'</td>\
					<td>'+ele.repertory+'</td>\
					<td>'+ele.salesVolume+'</td>\
					<td><a href="javaScript:void(0)" class="offsale">结束活动</a>&nbsp;&nbsp;&nbsp;<a href="javaScript:void(0)" class="edit-SKU">编辑</a></td>\
				</tr>';
				}
				
				
			
			});
			$('.sku-table tbody').append(temp_html);
		}
	}
	
	//从商品属性表单生成json字符串
	function formatItemParam(){
		var paramData = new Array();
		var temp;
		var tr = $('.item-param-tbody .item-param ');
		
		for(var i = 0, len = tr.length; i < len; i ++){
			if(!tr[i].children[1].innerHTML){
				paramData.push(temp);
				var temp = {};
				temp.group = tr[i].children[0].innerHTML;
				temp.param = new Array();
				continue;
			}
			temp.param.push({k:tr[i].children[0].innerHTML,v:tr[i].querySelector('input').value});
		}
		paramData.push(temp);
		paramData.splice(0,1);
		return JSON.stringify(paramData);
	}
	
	//
	function getItemName(){
		return $('.itemName').val();
	}
	
	function getItemDetail(){
		return $('#editor-html').html();
	}
	
	function updateItem(){
		$.ajax({
			type : 'post',
			url : '/QiuLuPC-Manager/item/update',
			async : true,
			data : {id:item.id,name:getItemName(),paramData:formatItemParam(),itemDetail:getItemDetail()},
			dataType : 'json',
			success : function(data){
				if(data.status){
					//刷新页面
					history.go(0);
				}
			}
		});
	};
	return {getSkus:getSkus,updateItem:updateItem}
}())
