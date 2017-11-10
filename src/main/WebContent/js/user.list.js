

$(document).ready(function() {
	var pageSize = 10;
	getPageCount(pageSize, "");
	getUserByPage("", 1, pageSize);
	var uname = $("#searchName").val();
	$("#listPage").change(function() {
		getUserByPage(uname, $("#listPage").val(), pageSize);
	});

});

/**
 * 获取分页数量
 * @param pageSize
 * @param name
 * @returns
 */
function getPageCount(pageSize, name) {
	$.ajax({
		url : "page/" + pageSize,
		type : "get",
		data : {uname : name},
		success : function(data) {
			if(typeof(data) == 'string') {
				window.location.href="error.jsp";
			} else {
				drawPagelist(data);
			}
		}
	});
}

/**
 * 画分页
 * @param count
 * @returns
 */
function drawPagelist(count) {
	var show = $("#listPage");
	show.text("");
	for (let i = 1; i <= count; i++) {
		show.append("<option value='" + i + "'>" + i + "</option>");
	}
}

/**
 * 获取分页记录
 * @param uname
 * @param pageNo
 * @param pageSize
 * @returns
 */
function getUserByPage(uname, pageNo, pageSize) {
	$.ajax({
		url : "sign",
		type : "get",
		data : {
			"uname" : uname,
			"pageNo" : pageNo,
			"pageSize" : pageSize
		},
		success : function(data) {
			if(typeof(data) == 'string') {
				window.location.href="error.jsp"
			} else {
				drawUserlist(data)
			}
		}
	});
}

/**
 * 画记录列表
 * @param signs
 * @returns
 */
function drawUserlist(signs) {
	var show = $("#signMsg");
	show.text("");
	for (let i = 0; i < signs.length; i++) {
		var status = signs[i].status == 0 ? "迟到" : "正常打卡";
		var text = "<tr>"
			+ "<td>" + signs[i].uname + "</td>"
			+ "<td>" + signs[i].stime + "</td>"
			+ "<td>" + status + "</td>"
			+ "<td><a href='javascript:void(0)' onclick='deleteSign(" + signs[i].sid + ")'>删除</a></td>"
			+ "</tr>";
		show.append(text);

	}
}

/**
 * 插入记录
 * @returns
 */
function insertSign() {
	$.ajax({
		url : "sign",
		type : "post",
		data : {
			uname : $("#loginName").text(),
			time : new Date().getTime()
			},
		success : function(data) {
			if (typeof data != "string" && data != -1) {
				alert("签到成功");
				window.location.href = "main.jsp";
			} else {
				alert("打卡失败");
			}		
		}
	});
}

/**
 * 删除记录
 * @param id
 * @returns
 */
function deleteSign(id) {
	$.ajax({
		url : "sign/" + id,
		type : "delete",
		success : function(data) {
			if (typeof data == "string") {
				window.location.href = "error.jsp"
			} else if (data != -1) {
				alert("删除成功");
				window.location.href = "main.jsp";
			} else {
				alert("删除失败");
			}		
		},
		error : function(data) {
			window.location.href = "error.jsp"
		}
	});
}

/**
 * 查询记录
 * @returns
 */
function searchSign() {
	var uname = $("#searchName").val();
	$("#listPage").val(1);
	getPageCount(10, uname);
	getUserByPage(uname, 1, 10);
}
