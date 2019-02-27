var expressFun = (function(){
	var id = request("id");
	//查询快递公司
	function getExpressCompany(){
		var expressCompany ;
		$.ajax({
			type : 'post'
			,url : '/QiuLuPC-Manager/express/getAllExpressCompany'
			,async : false
			,dataType : 'json'
			,success : function(data){
				
				expressCompany = data.object;
			}
		});
//		expressCompany = JSON.parse('[{"k":"天天1","v":"tiantian"},{"k":"天天2","v":"tiantian"},{"k":"天天3","v":"tiantian"},{"k":"天天4","v":"tiantian"}]');
		return expressCompany ;
	}
	
	function loadExpressCompany(){
		var temp_html = '';
		var select = $('.selectExpress');
		var array = getExpressCompany();
		temp_html += '<select name="" id="expressCompany" lay-verify="required" >';
		for(var i = 0, len = array.length; i < len; i ++){
			temp_html +=
				' <option value="'+array[i].expressValue+'">'+array[i].expressName+'</option>';
		};
		temp_html += '</select>';
		select.html(temp_html) ;
		layui.use(['form'],function(){
			layui.form().render('select'); 
		});
	}
	
	function submitExpress(express,courierNumber){
			
			
			if( (typeof express) === 'undefined'){
				var sel = $('#expressCompany')[0];
				var opt = sel.options[sel.selectedIndex];
				express = JSON.stringify({'k':opt.text,'v':opt.value});
			};
			if( (typeof courierNumber) === 'undefined'){
				courierNumber = $('#courierNumber').val()
			}
			$.post("/QiuLuPC-Manager/order/send"
				,{"id":id,"express":express,"courierNumber":courierNumber}
				,function(result){
					if(result.status){
						//alert("处理成功！");
//						$.messager.alert('消息框','处理成功！','info',function(){
//							location.href="menu.html?id="+id;
//						});
						layui.use('layer', function(){
							var layer = layui.layer;
							  
							layer.msg('处理成功',{
								icon: 1,
							  	time: 2000 //2秒关闭（如果不配置，默认是3秒）
							},function(){
								parent.history.go(0);
							});
						});
						
						//location.href="menu.html?id="+id;
					} else {
						//alert("处理失败！");
					}
				}
			);
		};
		
	
	return {loadExpressCompany : loadExpressCompany
			,submitExpress : submitExpress};
	
}())
