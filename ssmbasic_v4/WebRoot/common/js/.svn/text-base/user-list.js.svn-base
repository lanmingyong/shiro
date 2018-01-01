$(document).ready(function(){
	
});

/**
 * 显示用户列表当前页
 * @author Rocye
 * @createtime 2015-06-26
 */
function showUserNowPageList(){
	if($('#pgUser_nowPg').length > 0){
		showUserPageList(parseInt($('#pgUser_nowPg').text(),10));
	}else{
		showUserPageList(1);
	}
}

/**
 * 用户分页回调
 * @author Rocye
 * @createtime 2015-06-26
 */
function userPageselectCallback(page_index, jq){
	showUserPageList(page_index+1);
}

/**
 * 用户分页
 * @author Rocye
 * @createtime 2015-06-26
 */
function showUserPageList(pgNum){
	var paraObj = {};
	paraObj["pageNum"] = pgNum;
	if($.trim($('#txtParam').val()) != ''){
		paraObj["user.userName"] = $.trim($('#txtParam').val());
	}
	var loading = ShowLoading();
	$.ajax({
		url: "user/listAjax",
		type: "post",			// 数据发送方式          
		dataType : "json",		// 接受数据格式
		data : paraObj,
		success : function(jsonData){
			HideLoading(loading);
			if(jsonData.errcode == -2){
                top.location.reload(true);
            }else if(jsonData.errcode == -3){
				DilogError('没有操作权限!');
			}else if(jsonData.errcode == -1){
				DilogError('出错了!请联系管理员!');
			}else{
			    var listHtml = [];
			    $.each(jsonData.items, function(i,item){
			    	listHtml.push('<tr>');
			    	listHtml.push('<td>'+ item.loginName+ '</td>');
			    	listHtml.push('<td>'+ item.userName+ '</td>');
			    	listHtml.push('<td>'+ (item.birthday==undefined?'':item.birthday) + '</td>');
			    	listHtml.push('<td>'+ (item.userPhone==undefined?'':item.userPhone) + '</td>');
			    	listHtml.push('<td>'+ (item.userEmail==undefined?'':item.userEmail) + '</td>');
			    	listHtml.push('<td><a href="user/'+ item.userId +'/download" target="_blank">下载</a></td>');
			    	listHtml.push('<td><a class="btn btn-xs btn-link" href="javascript:showUser('+ item.userId +');">Ajax修改</a>');
			    	listHtml.push('<a class="btn btn-xs btn-link" href="user/'+ item.userId +'/edit">修改</a>');
			    	listHtml.push('<a class="btn btn-xs btn-link" href="javascript:deleteUser('+ item.userId +');">删除</a></td>');
			    	listHtml.push('</tr>');
				});
			    
			    $('#tbUserList').html(listHtml.join(''));
			    $('#pgUser').empty();
			    createUserPagination(jsonData.totalPages, jsonData.totalRows, jsonData.pageNum, jsonData.pageSize);
			}
		},
		error: function(e){
			HideLoading(loading); 
		}
	});
}

/**
 * 构建用户分页组件
 * @author Rocye
 * @createtime 2015-07-18
 */
function createUserPagination(totalPages, totalRows, pageNum, pageSize){
	if(totalPages > 1){
		$("#pgUser").pagination(totalRows, {
			callback: userPageselectCallback,
			current_page:pageNum-1,
			num_edge_entries:1,
			num_display_entries:5,
			items_per_page:pageSize,
			show_if_single_page:true,
			show_ext:true
		});
	}
}

/**
 * 删除用户
 * @author Rocye
 * @createTime 2015-10-15
 */
function deleteUser(userId){
	DilogConfirm('您确定要删除此用户吗？',function(){
		$.ajax({
            url: "user/"+ userId +"/delete",
            type: "get",           // 数据发送方式          
            dataType : "json",      // 接受数据格式
            success : function(jsonData){
                if(jsonData.errcode == -2){
                    top.location.reload(true);
                }else if(jsonData.errcode == -3){
					DilogError('没有操作权限!');
				}else if(jsonData.errcode == -1){
                    DilogError('出错了!请联系管理员!');
                }else{
                    if(jsonData.errcode == 0){
                        showUserNowPageList();
                    }else{
                        DilogError(jsonData.msg);
                    }
                }
            },
            error: function(e){
            }
        });
	});
}

/**
 * 查看用户信息
 * @author Rocye
 * @createTime 2015-10-15
 */
function showUser(userId){
	clearnForm();
    $.ajax({
        url: "user/"+ userId +"/show",
        type: "get",           // 数据发送方式          
        dataType : "json",      // 接受数据格式
        success : function(jsonData){
            if(jsonData.errcode == -2){
                top.location.reload(true);
            }else if(jsonData.errcode == -3){
				DilogError('没有操作权限!');
			}else if(jsonData.errcode == -1){
                DilogError('出错了!请联系管理员!');
            }else{
                $('#hdnUserId').val(jsonData.userId);
                $('#tloginName').val(jsonData.loginName);
                $('#tpassword').val(jsonData.password);
                $('#tuserName').val(jsonData.userName);
                $('#tbirthday').val(jsonData.birthday);
                $('#tuserPhone').val(jsonData.userPhone);
                $('#tuserEmail').val(jsonData.userEmail);
                
                DialogCustomForm('编辑用户','divUserForm','userFormDig');
                
                showUserNowPageList();
            }
        },
        error: function(e){
        }
    });
}

/**
 * 清空编辑表单
 * @author Rocye
 * @createTime 2015-10-15
 */
function clearnForm(){
    $('#hdnUserId').val('');
    $('#tloginName').val('');
    $('#tpassword').val('');
    $('#tuserName').val('');
    $('#tbirthday').val('');
    $('#tuserPhone').val('');
    $('#tuserEmail').val('');
}

/**
 * 保存编辑用户记录
 * @author Rocye
 * @createTime 2015-10-15
 */
function saveUser(){
    var msgArr = [];
    var paraObj = {};
    if($.trim($('#hdnUserId').val()) != ''){
        paraObj["userId"] = $('#hdnUserId').val();
    }
    if($.trim($('#tloginName').val()) != ''){
        paraObj["loginName"] = $.trim($('#tloginName').val());
    }else{
        msgArr.push('登录名不能为空!');
    }
    if($.trim($('#tpassword').val()) != ''){
        paraObj["password"] = $.trim($('#tpassword').val());
    }else{
        msgArr.push('密码不能为空!');
    }
    if($.trim($('#tuserName').val()) != ''){
        paraObj["userName"] = $.trim($('#tuserName').val());
    }else{
        msgArr.push('姓名不能为空!');
    }
    if($.trim($('#tbirthday').val()) != ''){
        paraObj["birthday"] = $.trim($('#tbirthday').val());
    }
    if($.trim($('#tuserPhone').val()) != ''){
        paraObj["userPhone"] = $.trim($('#tuserPhone').val());
    }
    if($.trim($('#tuserEmail').val()) != ''){
        paraObj["userEmail"] = $.trim($('#tuserEmail').val());
    }
    
    if(msgArr.length > 0){
        DilogWarning(msgArr.join('<br/>'));
        return ;
    }
    $.ajax({
        url: "user/save",
        type: "post",           // 数据发送方式          
        dataType : "json",      // 接受数据格式
        data : paraObj,
        success : function(jsonData){
            if(jsonData.errcode == -2){
                top.location.reload(true);
            }else if(jsonData.errcode == -3){
				DilogError('没有操作权限!');
			}else if(jsonData.errcode == -1){
                DilogError('出错了!请联系管理员!');
            }else{
                if(jsonData.errcode == 0){
                	DialogClose('userFormDig');
                	if($.trim($('#hdnUserId').val()) != ''){
                        showUserNowPageList();
                	}else{
                		showUserPageList(1);
                	}
                }else{
                    DilogError(jsonData.msg);
                }
            }
        },
        error: function(e){
        }
    });
}

