/**
 * 得到当前活动的navtab
 * @returns
 */
function getCurrentNavtab(){
	return $("ul.navTab-tab li.selected");
}



/**
*带文件上传的ajax表单提交并刷新dialog
*要再action中设置rel的值为，页面href中的rel值
***/
function iframeCallbackRefreshDialog(form, callback){
	iframeCallback(form, callback);
}

function dialogAjaxDoneRefreshDialog(json){
	DWZ.ajaxDone(json);
	if (json.statusCode == DWZ.statusCode.ok){
		var dialog = $("body").data(json.rel);
		if(dialog){
			$.pdialog.reload(dialog.data("url"),{dialogId:json.rel});
		}
		 
	}
}



function dialogAjaxDoneRefreshNavTab(json){
	DWZ.ajaxDone(json);
	if (json.statusCode == DWZ.statusCode.ok){
		if (json.navTabId){
			navTab.reload(json.forwardUrl, {navTabId: json.navTabId});
		} else if (json.rel) {
			var $pagerForm = $("#pagerForm", navTab.getCurrentPanel());
			var args = $pagerForm.size()>0 ? $pagerForm.serializeArray() : {}
			navTabPageBreak(args, json.rel);
		}else{//新增、修改，弹出dialog提交后刷新,navTab
		 var $pagerForm = $("#pagerForm", navTab.getCurrentPanel());
		 var args = $pagerForm.size()>0 ? $pagerForm.serializeArray() : {}
		 navTabPageBreak(args, json.rel); 
		}
		if ("closeCurrent" == json.callbackType) {
			$.pdialog.closeCurrent();
		}
	}
}

/**
 * 得到当前活动的navtab的局部区域
 * @returns
 */
function getCurrentNavtabRel(){
	var $pDiv = $('.tabsPage div[class="page unitBox"][style*="block"]').first();
	var $ub = $("div.unitBox", $pDiv);
	if ($ub.length > 0) {
		return $ub.first();
	}
	return $pDiv;
}

/**
 * 自动刷新当前活动的navTab
 * @param json
 */
function dialogReloadNavTab(json){
	DWZ.ajaxDone(json);
	var tabId = getCurrentNavtab().attr("tabid");
	if (json.statusCode == DWZ.statusCode.ok){
		if (json.navTabId || tabId!=null){
			navTab.reload(json.forwardUrl, {navTabId: json.navTabId});
		} else if (json.rel) {
			var $pagerForm = $("#pagerForm", navTab.getCurrentPanel());
			var args = $pagerForm.size()>0 ? $pagerForm.serializeArray() : {}
			navTabPageBreak(args, json.rel);
		}
		if ("closeCurrent" == json.callbackType) {
			$.pdialog.closeCurrent();
		}
	}
}

/**
 * 自动刷新当前活动的navTab的局部区域
 * @param json
 */
function dialogReloadRel(json){
	DWZ.ajaxDone(json);
	if (json.statusCode == DWZ.statusCode.ok){
		var rel = getCurrentNavtabRel().attr("id");
		var $pagerForm = $("#pagerForm", navTab.getCurrentPanel());
		var args = $pagerForm.size()>0 ? $pagerForm.serializeArray() : {}
		navTabPageBreak(args, rel);

		if ("closeCurrent" == json.callbackType) {
			$.pdialog.closeCurrent();
		}
	}
}

/**
 * 根据rel自动局部刷新
 * @param json
 */
function reloadRel(json){
	DWZ.ajaxDone(json);
	if (json.statusCode == DWZ.statusCode.ok){
		if (json.navTabId){ //把指定navTab页面标记为需要“重新载入”。注意navTabId不能是当前navTab页面的
			navTab.reloadFlag(json.navTabId);
		} else { //重新载入当前navTab页面
			var $pagerForm = $("#pagerForm", navTab.getCurrentPanel());
			var args = $pagerForm.size()>0 ? $pagerForm.serializeArray() : {}
			if (json.rel != null && json.rel!="") {
				navTabPageBreak(args, json.rel);
			} else {
				var rel = getCurrentNavtabRel().attr("id");
				navTabPageBreak(args, rel);
			}
		}
		
		if ("closeCurrent" == json.callbackType) {
			setTimeout(function(){navTab.closeCurrentTab(json.navTabId);}, 100);
		} else if ("forward" == json.callbackType) {
			navTab.reload(json.forwardUrl);
		} else if ("forwardConfirm" == json.callbackType) {
			alertMsg.confirm(json.confirmMsg || DWZ.msg("forwardConfirmMsg"), {
				okCall: function(){
					navTab.reload(json.forwardUrl);
				}
			});
		} else {
			navTab.getCurrentPanel().find(":input[initValue]").each(function(){
				var initVal = $(this).attr("initValue");
				$(this).val(initVal);
			});
		}
	}
	
}

/**
 * 根据id自动局部刷新，用于organization页面
 * @param json
 */
function dialogReloadRel2Org(json){
	if (json.statusCode == DWZ.statusCode.ok) {
		$("#refreshJbsxBox2organizationTree").click();
	}
	
	dialogReloadRel(json);
}
/**
 * 根据id自动局部刷新，用于PublicDic页面
 * @param json
 */
function dialogReloadRel2PublicDic(json){
	if (json.statusCode == DWZ.statusCode.ok) {
		$("#refreshJbsxBox2publicDicTree").click();
	}
	
	dialogReloadRel(json);
}
/**
 * 根据id自动局部刷新，用于module页面
 * @param json
 */
function dialogReloadRel2Module(json){
	if (json.statusCode == DWZ.statusCode.ok) {
		$("#refreshJbsxBox2moduleTree").click();
	}
	
	dialogReloadRel(json);
}

/**
 * 根据id自动局部刷新，用于constant页面
 * @param json
 */
function dialogReloadRel2Constant(json){
	if (json.statusCode == DWZ.statusCode.ok) {
		$("#refreshJbsxBox2constantTree").click();
	}
	
	dialogReloadRel(json);
}


/**
 * 实现在Dialog调用ajaxTodo，关闭Dialog并刷新navTab
  *使用方法:a标签中添加callback="closeDialogRefreshTab" 即可
 *  
 */
function closeDialogRefreshTab() {
	  navTab.reload();
	 $.pdialog.closeCurrent();
}

/**
 * 根据id自动局部刷新，用于Terrace页面
 * @param json
 */
function dialogReloadRel2Terrace(json){
	if (json.statusCode == DWZ.statusCode.ok) {
		$("#refreshJbsxBox2TerraceTree").click();
	}
	
	dialogReloadRel(json);
}

/**
 * 根据id自动局部刷新，用于Hospital页面
 * @param json
 */
function dialogReloadRel2Hospital(json){
	if (json.statusCode == DWZ.statusCode.ok) {
		$("#refreshJbsxBox2HospitalTree").click();
	}
	
	dialogReloadRel(json);
}

/**
 * 根据id自动局部刷新，用于terraceFb页面
 * @param json
 */
function dialogReloadRel2terraceFb(json){
	if (json.statusCode == DWZ.statusCode.ok) {
		$("#refreshJbsxBox2terraceFbTree").click();
	}
	
	dialogReloadRel(json);
}

/**
 * 根据id自动局部刷新，用于hospitalFb页面
 * @param json
 */
function dialogReloadRel2hospitalFb(json){
	if (json.statusCode == DWZ.statusCode.ok) {
		$("#refreshJbsxBox2hospitalFbTree").click();
	}
	
	dialogReloadRel(json);
}