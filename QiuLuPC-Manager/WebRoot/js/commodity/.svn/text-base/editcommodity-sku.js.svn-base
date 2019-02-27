var skuFun = (function(){

	var temp_sku = {} ;
	
	function loadSku(){
		var temp_html = '';
		var sku = parent.itemFun.getSkus()[request('index')];
		temp_sku.id = sku.id;
		JSON.parse(sku.paramData).forEach(function(ele,index,array){
			temp_html += '<tr class="sku-param"><td class="tdleft" style="float: right;">'+ele.k+'</td>\
				<td class="add"><p><input type="text" name="" id="" value="'+ele.v+'" class="text" lay-verify="required|noSpecial"/>\
				</td></tr>';
		});
		$('.contable').append(temp_html);
		$('.sku-Price input').val(sku.price);
		$('.sku-sellPoint textarea').val(sku.sellPoint);
		$('.sku-deliveryPlace input').val(sku.deliveryPlace);
	}
	
	loadSku();
	
	//从销售属性表单生成json字符串
	function formatSKUParam(){
		var paramData = new Array();
		var tr = $('.sku-param');
		
		for(var i = 0, len = tr.length; i < len; i ++){
			paramData.push({k:tr[i].children[0].innerHTML,v:tr[i].querySelector('input').value});
		}
		return JSON.stringify(paramData);
	}
	
	function changePrice(event){
		temp_sku.price = event.currentTarget.value;
		temp_sku.discount = event.currentTarget.value;
	}
	
	function changeSellPoint(event){
		temp_sku.sellPoint = event.currentTarget.value;
	}
	
	function changeDeliveryPlace(event){
		temp_sku.deliveryPlace = event.currentTarget.value;
	}
	
	$('.sku-Price input').change(changePrice);
	$('.sku-sellPoint textarea').change(changeSellPoint);
	$('.sku-deliveryPlace input').change(changeDeliveryPlace);
	
	//修改sku
	function updataSKU(){
		temp_sku.paramData = formatSKUParam();
		$.ajax({
			type:"post",
			url:"/QiuLuPC-Manager/sku/update",
			data :temp_sku,
			async:true,
			dataType : 'json',
			success : function(data){
				if(data.status){
					//刷新页面
					parent.history.go(0);
				}
			}
		});
	};

	return {updataSKU:updataSKU};
}())
