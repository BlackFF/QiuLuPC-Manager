/**
 * 
 */

var cateSel = (function(){
	
	//分类选择所属的div
	var parentClass;
	
	var temp_Nodes = [];//二维数组  存储个级分类、每级分类的选项
	
	//初始化分类select	加载顶级分类
	function initSelect(className){
		parentClass = className;
		getTop();
//		bindEvent();
	}
	
	
	
	//得到顶级分类
	function getTop(){
		$.ajax({
			type:'post',
			url:'/QiuLuPC-Manager/category/top',
			async:true,
			dataType:'json',
			success:function(data){
				loadNext(data.object);
			},
		});
	}
	
	//得到子节点
	function getNode(id){
		$.ajax({
			type:'post',
			url:'/QiuLuPC-Manager/category/note',
			async:true,
			data:{parentId:id},
			dataType:'json',
			success:function(data){
				loadNext(data.object);
			},
		});
	}
	
	//加载下一级select
	function loadNext(array){
		if(array.length == 0){
			paramFun.loadItemParam();
			return null;
		}
		paramFun.cleanItemParam();
		temp_Nodes[temp_Nodes.length] = array;
		var div = document.querySelector(parentClass);
		var inline = document.createElement('div');
		inline.className = 'layui-inline layui-input-block';
		var select = document.createElement('select');
		select.name = "itemCategory";
		select.setAttribute('lay-filter','category-select')
		select.setAttribute('lay-verify','required')
		var opt = $('<option value="" selected="selected" disabled="disabled" style="display:none;"></option>')[0];
		select.options.add(opt);
		for(var i = 0, len = array.length; i < len; i ++){
			select.add(new Option(array[i].name,array[i].id));
		}
		inline.appendChild(select);
		div.appendChild(inline);
		layui.use('form',function(){
			var form = layui.form();
			form.render('select');
			form.on('select',function(data){
				selectOpt(data.elem);
			});
		});
	}
	
	//清空后面的select
	function removeNextAll(that){
		temp_Nodes.splice($(that.parentElement).index());
		var nextAll = $(that.parentElement).nextAll();
		for(var i = 0, len = nextAll.length; i < len; i ++){
			$(nextAll[i]).remove();
		}
	}
	
	//返回最终选择的分类id
	function checkCate(){
		var sel = $(parentClass +' select:last')[0];
		if(!sel.value){
//			sel = sel.previousElementSibling;
			console.log('当前不是最底层分类');
			return null;
		}
		
		return temp_Nodes[temp_Nodes.length - 1][sel.selectedIndex - 1];
		
		//return sel?sel.value:null;
	}
	//选择一个选项	触发得到子节点数据
	function selectOpt(target){
		removeNextAll(target);
		getNode(target.value);
	}
	
//	function bindEvent(){
//		//绑定选择分类事件
//		$(parentClass).on('change','input',function(event){
//			selectOpt(event.currentTarget);
//		});
////		//显示选中的分类id
////		$('.showCate').click(function(){alert(checkCate())});
//	}
	
	return {initSelect:initSelect,getCate:checkCate};
//	$(document).ready(function(){
//		initSelect();
//	});
	
	
}())