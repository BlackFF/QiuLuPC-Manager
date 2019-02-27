(function(){
	/*生成行时  带有参数表示层级  点击一行时向下寻找第一个同级或高级的行  取得两行索引  将索引值中间的行隐藏*/
	
	//请求分类列表数据
	$.ajax({
		type:'post',
		url:'/QiuLuPC-Manager/category/get',
		async:true,
		dataType:'json',
		success:function(data){
			var temp = creatTree(data.object,0);
			var tbody = document.querySelector('.tbody');
			tbody.innerHTML = temp;
		}
		
	});
	//tree初始化
	function creatTree(array,rank){
		var temp_html = new Array();
		var table = '';
		for(var j = 0; j < rank; j ++){
			table += '&nbsp;&nbsp;&nbsp;&nbsp;'
		}
		for(var i = 0, len = array.length; i < len; i ++){
			temp_html.push('<tr class="" data-rank="'+rank+'" data-id="'+array[i].id+'">'
						+'<td class="" >'+table+(array[i].children?'<i class="glyphicon glyphicon-menu-right glyphicon-menu-down"></i>\
						<i class="layui-icon layui-tree-branch-close layui-tree-branch-open"></i>':'<i class="layui-icon layui-tree-leaf"></i>')+array[i].name+'</td>'
						+'<td><span class="operation">添加</span><span class="operation">编辑</span><span class="operation">删除</span></td>'
					+'</tr>');
			if(array[i].children){
				temp_html.push(creatTree(array[i].children,Number(rank)+1));
			}
			
		}
		return temp_html.join('');
	}
	//生成一行
	function createRow(){
		
	}
	
	//点击隐藏或显示子级目录	
	function showSubNodes(tr){
		var trs = document.querySelectorAll('.tbody tr');
//		var index = trs.indexOf(tr);
//		for(var i = index+1, len = trs.length; i < len; i ++){
//			if(trs[i].dataset.rank < tr.dataset.rank){
//				trs[i].className.replace('display-hide','');
//			}else{
//				break;
//			}
//		}
		out:
		for(var i = 0,len = trs.length; i < len; i ++){
			if(trs[i] == tr){
				i ++;
				for(;trs[i].dataset.rank > tr.dataset.rank;i ++){
					trs[i].classList.remove('display-hide');
				}
				break out;
			}
		}
	}
	
	function hideSubNodes(tr){
		var trs = document.querySelectorAll('.tbody tr');
//		var index = trs.indexOf(tr);
//		for(var i = index+1, len = trs.length; i < len; i ++){
//			if(trs[i].dataset.rank > tr.dataset.rank){    
//				trs[i].classList.add('display-hide');
//			}else{
//				break;
//			}
//		}
		out:
		for(var i = 0,len = trs.length; i < len; i ++){
			if(trs[i] == tr){
				i ++;
				for(;trs[i].dataset.rank > tr.dataset.rank;i ++){
					trs[i].classList.add('display-hide');
				}
				break out;
			}
		}
	}
	
	//目标分类的状态图标转变 
	function click(event){
		var td = event.currentTarget;
		var i = td.querySelector('.glyphicon');
		var i2 = td.querySelector('.layui-icon');
		if(i == null){
			return null;
		}
		//收起子分类
		if(i.classList.contains('glyphicon-menu-down')){
			i2.classList.remove('layui-tree-branch-open');
			i.classList.remove('glyphicon-menu-down');
			hideSubNodes(td.parentElement);
		//打开子菜单
		}else{
			i2.classList.add('layui-tree-branch-open');
			i.classList.add('glyphicon-menu-down');
			showSubNodes(td.parentElement);
		}
	}
	
	//$('tbody td').click(click);
	
	$('tbody').on('click','td:nth-child(2n+1)',click);
})()
