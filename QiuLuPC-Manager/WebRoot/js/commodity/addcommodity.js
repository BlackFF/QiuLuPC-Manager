var paramFun = (function(){
	//
	var clickIndex;
	function setClickIndex(i){
		clickIndex = i;
	}
	
	//item对象
	var item = {};
	
	//sku数组
	var sku = new Array();
	
	//
	function SKU(){
		this.paramData = '';
		SKU.prototype.itemId = 0;
		this.price = 0;
		this.discount = 0;
		this.repertory = 0;
		this.warnRepertory = 0;
		this.sellPoint = '';
		this.deliveryPlace = '';
		this.salesVolume = 0;
		this.status = 0;
		
		if(typeof this.setParamData !== 'function'){
			//各种SKU私有方法
			SKU.prototype.setParamData = function(arr){
				this.paramData = JSON.stringify(arr);
			};
		}
	}
	
	
	
	//根据分类得到 商品属性、销售属性
	function getParam(){
		
	}
	
	//加载 所选分类的商品属性 和 销售属性
	function loadItemParam(){
		var cate = cateSel.getCate();
		item.categoryId = cate.id;
		var temp_html = '';
		var itemParamData = JSON.parse(cate.itemParamData);
		var skuParamData = JSON.parse(cate.skuParamData);
		
		
		
		//加载商品属性
		for(var i = 0, len = itemParamData.length; i < len; i ++){
			temp_html += '<div class="layui-form-item item-Param"><label class="layui-form-label">'+itemParamData[i].group+'</label><div class="layui-input-block"></div></div>';
			for(var j = 0, len2 = itemParamData[i].param.length; j < len2; j ++){
				temp_html += 
				
					'<div class="layui-form-item item-Param">\
						<label class="layui-form-label">'+itemParamData[i].param[j]+'</label>\
						<div class="layui-input-block">\
							<input type="text" name="itemParam'+i+j+'" id="" value="" lay-verify="required" class="layui-input"/>\
						</div>\
					</div>';
			}
		}
		$('.item-param').html(temp_html);
		temp_html = '';
		//加载销售属性
		for(var i = 0, len = skuParamData.param.length; i < len; i ++){
			temp_html += '<br/><div class="layui-inline">'+
					    	'<label class="layui-form-label">'+skuParamData.param[i]+'</label>'+
							'<div class="layui-input-inline">'+
								'<input type="text" name="skuParam" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">'+
							'</div>'+
							'<div class="layui-input-inline">'+
								'<button class="layui-btn layui-btn-primary layui-btn-small operation add"><i class="layui-icon">&#xe654;</i></button>'+
							'</div>'+
					  	'</div><br/>';
		}
		$('.sku-table').html(temp_html);
		layui.use('form',function(){
			layui.form().render('select');
		});
	}
	
	function cleanItemParam(){
		$('.item-param').html('');
		$('.sku-table').html('');
	}
	
	//sku添加一条属性
	function addSKUParam(){
		$(this).parent().parent().after('<div class="layui-inline">'+
								'<label class="layui-form-label"></label>'+
								'<div class="layui-input-inline">'+
									'<input type="text" name="skuParam" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">'+
								'</div>'+
								'<div class="layui-input-inline">'+
									'<button class="layui-btn layui-btn-primary layui-btn-small operation add"><i class="layui-icon">&#xe654;</i></button>'+
								'</div>'+
								'<div class="layui-input-inline">'+
									'<button class="layui-btn layui-btn-primary layui-btn-small operation del"><i class="layui-icon">&#xe640;</i></button>'+
								'</div></div>');
		layui.use('form',function(){
			layui.form().render('select');
		});
	}
	
	//sku减少一条属性
	function delSKUParam(){
		$(this).parent().parent().remove();
		layui.use('form',function(){
			layui.form().render('select');
		});
	}
	
	$('.sku-table').on('click','.operation.add',addSKUParam);
	$('.sku-table').on('click','.operation.del',delSKUParam);
	
	//生成sku组合	初始化SKU数组,设置paramData值
	function createSKU(){
		var array = new Array();
		var $div = $('.sku-table .layui-inline');
//		for(var i = 0, len = div.length; i < len; i ++){
//			var temp = $(div[i]).find('input').map(function(){return this.value});
//			array[i] = new Array();
//			for(var j = 0, len2 = temp.length; j < len2; j ++){
//				array[i][j] = {};
//				array[i][j]['k'] = div[i].children[0].innerHTML;
//				array[i][j]['v'] = temp[j];
//			}
//		}
		var i = -1, j = 0, temp_k;
		for(var x = 0, len = $div.length; x < len; x ++){
			if($div[x].children[0].innerHTML !== ''){
				i ++;
				j = 0;
				array[i] = [];
				temp_k = $div[x].children[0].innerHTML
				
			}
			array[i][j] = {};
			array[i][j]['k'] = temp_k;
			array[i][j]['v'] = $div[x].querySelector('input').value;
			j ++;
		}
		
		
		function createSKUSet(array){
			var a = [];
			array[0].forEach(function(item,index,array){
				a.push([item]);
			});
			for(var i = 1, len = array.length; i < len; i ++){
				a = setFun(a,array[i]);
			}
			
			function setFun(a,arr){
				var temp = new Array();
				for(var i = 0,len = a.length; i < len; i ++){
					for(var j = 0,len2 = arr.length; j < len2; j ++){
						temp.push(a[i].concat(arr[j]));
					}
				}
				return temp;
			}
			return a;
		}
	
		var SKUSet = createSKUSet(array);
		
		//清空sku数组
		sku.splice(0);
		
		SKUSet.forEach(function(item,index){
			sku.push(new SKU());
			sku[index].setParamData(item);
		});

		return SKUSet;
	}
	
	//生成sku表单
	function createSkuSetTable(){
		var SKUSet = createSKU();
		var table = document.querySelector('.skuSet-table');
		var temp_html = '';
		SKUSet[0].forEach(function(item){
			temp_html += '<th>'+item.k+'</th>';
		})
		table.querySelector('tr').innerHTML = temp_html + '<th>价格</th><th>库存</th><th>操作</th>';
		temp_html = '';
		SKUSet.forEach(function(item){
			var temp = '';
			item.forEach(function(i){
				temp += '<td>'+i.v+'</td>';
			});
			
			temp_html += '<tr>\
							 '+temp+'\
							<td>0.00</td>\
							<td>0</td>\
							<td><a href="javaScript:void(0)" class="edit-SKU">编辑</a></td>\
						</tr>';
			
		});
		table.querySelector('tbody').innerHTML = temp_html;
	}
	
	//生成表格按钮
//	$('.skuXX').click(createSkuSetTable);
	
	
	function readSKU(layero,i){
		var s = sku[clickIndex == 0?0:(clickIndex-1)];
		//价钱
		$('.sku-Price input',layero).val(s.price);
		//库存
		$('.sku-repertory input',layero).val(s.repertory) ;
		//库存警戒线
		$('.sku-warnRepertory input',layero).val(s.warnRepertory) ;
		//卖点
		$('.sku-sellPoint input',layero).val(s.sellPoint) ;
		//发货地
		$('.sku-deliveryPlace input',layero).val(s.deliveryPlace) ;
		//是否上架
		$('.sku-status input:eq('+s.status+')',layero).attr('checked','checked');
	}
	
	function saveSKU(){
		var s = sku[clickIndex];
		//价钱
		s.price = parseInt($('.sku-Price input').val());
		//会员价
		s.discount = parseInt($('.sku-Price input').val())
		//库存
		s.repertory = parseInt($('.sku-repertory input').val());
		//库存警戒线
		s.warnRepertory = parseInt($('.sku-warnRepertory input').val());
		//卖点
		s.sellPoint = $('.sku-sellPoint textarea').val();
		//发货地
		s.deliveryPlace = $('.sku-deliveryPlace input').val() ;
		//是否上架
		s.status = $('.sku-status input[name]').filter(function(index){return this.checked;}).val();
		
		var tr = $('.skuSet-table tbody tr:eq('+clickIndex+')');
		//sku表单里的价格
		tr.find('td:nth-last-of-type(3)').text(s.price);
		//sku表单里的库存
		tr.find('td:nth-last-of-type(2)').text(s.repertory);
	}
	
	
	
	//添加商品item
	function addItem(){
		function formatItemParam(){
			var paramData = new Array();
			var temp;
			var tr = $('.item-table .item-Param');
			
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
		
		function getItemName(){
			return $('.item-Name textarea').val();
		}
		
		function getItemDetail(){
			return $('#editor-html').html();
		}
		
		//注册商品
		$.ajax({
			type : 'post',
			url : '/QiuLuPC-Manager/item/save',
			async : true,
			data : {name:getItemName(),paramData:formatItemParam(),categoryId:item.categoryId,itemDetail:getItemDetail()},
			dataType : 'json',
			success : function(data){
				item.itemId = data.object;
				SKU.prototype.itemId = data.object;
				
				//注册sku
				addSKU(data.object);
				layer.msg('商品添加成功,id为'+data.object, {
				  icon: 1,
				  time: 2000 //2秒关闭（如果不配置，默认是3秒）
				});
				
				//初始化图片加载
				//upload.initImageForm(sku);
				initImageForm(sku);
			}
		});
		
		
	}
	
	//添加sku
	function addSKU(itemId){
		sku.forEach(function(item,index,array){
			$.ajax({
				type:"post",
				url:"/QiuLuPC-Manager/sku/save",
				data : {itemId:itemId
					,price:item.price
					,discount:item.discount
					,repertory:item.repertory
					,warnRepertory:item.warnRepertory
					,sellPoint:item.sellPoint
					,deliveryPlace:item.deliveryPlace
					,salesVolume:0
					,paramData:item.paramData
					,image:"[\"2a0f4705-8f2c-418c-8a66-fef495d4d884.jpg\"]"
				},
				async:false,
				dataType : 'json',
				success : function(data){
					item.id = data.object;
					console.log("sku添加到"+index+" 共:"+array.length);
				}
			});
		});
	}
	
	
	
	
//	$('button.add').click(addItem);
	
	return {loadItemParam:loadItemParam
		,cleanItemParam:cleanItemParam
		,readSKU:readSKU
		,saveSKU:saveSKU
		,setClickIndex:setClickIndex
		,addItem:addItem
		,createSkuSetTable:createSkuSetTable
	};
}())
