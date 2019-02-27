/** 公用js类--------------------- */

// 返回上一页
function goBack(){
	window.history.back(-1);
	//location.reload(); // 刷新页面
};

// 跳转到页面
function skipUrl(url){
	location.href=url;
};

// 右上角--展开或折叠五大项菜单


// 弹出筛选--分类模块
function openFilter(){
	$('html').css({'overflow':'hidden','height':'100%'});
    $('body').css('overflow','hidden');
	$('.cover-shadow').removeClass('display-hide');
	$('.slider-right').removeClass('display-hide');
};
// 关闭筛选分类--模块
function closeFilter(){
	$('html').css({'overflow':'auto','height':'auto'});
    $('body').css('overflow','auto');
	$('.cover-shadow').addClass('display-hide');
	$('.slider-right').addClass('display-hide');
};
// 展开或折叠筛选分类子类


// 一列或者多列显示的切换
function changeShow(thisOpt){
	var $this = $(thisOpt);
	if($this.hasClass("rows-ico")){
		$this.removeClass("rows-ico");
		$('.warps-block').closest('li').css({'width':'100%','border-right':'none'});
		$('.warps-block').removeClass("warps-block-cols");
	}else{
		$this.addClass("rows-ico");
		$('.warps-block').closest('li').css({'width':'50%','border-right':'1px solid #e5e5e5'});
		$('.warps-block').addClass("warps-block-cols");
	}
};

/**
 * 异步判断是否登录
 */
function isLogon(){
	var flag;
	$.ajax({
		type: "post",
		url: "/logon!isLogon.do",
		async: false,
		dataType:'json',
		success: function(data){
			if(!data.success){
				/*location.href="user/login.html";*/
				flag = false;
			}else{
				flag = true;
			}
		}
	});
	return flag;
}

/**
 * 设置搜索条件参数*/
function saveSearchParam(){
	
	var searchParam = getSearchParam();
	if(arguments.length==2){
		searchParam[arguments[0]] = arguments[1];
	}else if(arguments.length==1){
		for(var temp in arguments[0]){
			searchParam[temp] = arguments[0][temp];
		}
	}
	sessionStorage.setItem("searchParam",JSON.stringify(searchParam));
}
/**
 * 得到搜索条件*/
function getSearchParam(){
	var searchParam = sessionStorage.getItem("searchParam");
	searchParam = JSON.parse(searchParam);
	if(!searchParam){
		searchParam = {sousuo:'',startIndex:0,pageSize:20,categoryId:0,industryId:0,areacode:410105,pageStyle:'',sorter:0,loPrice:'',hiPrice:''}
	}
	return searchParam;
}

/**
 * 将要传递的参数存入sessionStrong
 * @param name 参数名称
 * @param value1
 * @param value2
 * */
function saveSessionStrongParam(name,value1,value2){
	var param = getSessionStrongParam(name);
	if(!param){
		param = {};
	}
	if(value2){
		param[value1] = value2;
	}else {
		for(var temp in value1){
			param[temp] = value1[temp];
		}
	}
	sessionStorage.setItem(name,JSON.stringify(param));
}

/**
 * 得到sessionStrong中的参数*/
function getSessionStrongParam(name){
	var param = sessionStorage.getItem(name);
	param = JSON.parse(param);
	return param;
}

/**
 * 删除sessionStrong中的参数*/
function removeSessionStrongParam(name){
	sessionStorage.removeItem(name);
}

/*--获取网页传递的参数
 * @param paras 要获取的url参数字段名
 * --*/
function request(paras)
{ 
    var url = location.href; 
    var paraString = url.substring(url.indexOf("?")+1,url.length).split("&"); 
    var paraObj = {} 
    for (i=0; j=paraString[i]; i++){ 
    paraObj[j.substring(0,j.indexOf("=")).toLowerCase()] = j.substring(j.indexOf("=")+1,j.length); 
    } 
    var returnValue = paraObj[paras.toLowerCase()]; 
    if(typeof(returnValue)=="undefined"){ 
    return ""; 
    }else{ 
    return decodeURIComponent(returnValue); 
    } 
}


/**获得元素的左上角相对于整张网页左上角的坐标*/
function getElementTop(element){
　　　　var actualTop = element.offsetTop;
　　　　var current = element.offsetParent;
　　　　while (current !== null){
　　　　　　actualTop += current.offsetTop;
　　　　　　current = current.offsetParent;
　　　　}
　　　　return actualTop;
　　}

function logOff(){
	$.ajax({
		url: "/logoff!ajax.do",
		datatype:"json",
		success: function(msg){
			if(msg!=null && msg!="" && msg!=="[]" && msg!="undefined"){
				if(JSON.parse(msg).success){
					location.href="login.html";
				}
			}
		}
	})
}

/**获取坐标经纬度*/
function getCoords(){
	if(navigator.geolocation)
    {
		var coords = navigator.geolocation.getCurrentPosition(function (p){
			window.coords =  {lat : p.coords.latitude, lng : p.coords.longitude};
			alert(coords.lat);
		});
	}
}

//获取浏览记录
/*var aa = history.length;
alert(aa);*/