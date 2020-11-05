<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>查看电影演员列表</title>
    <meta name="description" content="这是一个 performershow 页面">
    <meta name="keywords" content="performer">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath }/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath }/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <script src="${pageContext.request.contextPath }/assets/js/echarts.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/app.css">
    <script src="${pageContext.request.contextPath }/assets/js/jquery.min.js"></script>

</head>

<body data-type="widgets">
    <script src="${pageContext.request.contextPath }/assets/js/theme.js"></script>
    <div class="am-g tpl-g">
                 
        <!-- 头部开始 -->
        <!-- 加载top文件 -->
        <jsp:include page="../nav/top.jsp"></jsp:include>
        <!-- 头部结束 -->
        <!-- 侧边导航栏 -->
          <jsp:include page="../nav/left.jsp"></jsp:include>
		<!-- 侧边导航栏结束 -->


        <!-- 内容区域 -->
        <div class="tpl-content-wrapper">
            <div class="row-content am-cf">
                <div class="row">
                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                        <div class="widget am-cf">
                            <div class="widget-head am-cf">
                                <div class="widget-title  am-cf">电影出演人员编辑界面</div>


                            </div>
                            <div class="widget-body  am-fr">

                                <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                                    <div class="am-form-group">
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                   <button type="button" onclick="addTr()" id="xinzeng" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span> 添加出演</button>
                                            
                                               <!--  <button type="button" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span> 新增</button>
                                                <button type="button" class="am-btn am-btn-default am-btn-secondary"><span class="am-icon-save"></span> 保存</button>
                                                <button type="button" class="am-btn am-btn-default am-btn-warning"><span class="am-icon-archive"></span> 审核</button>
                                                <button type="button" class="am-btn am-btn-default am-btn-danger"><span class="am-icon-trash-o"></span> 删除</button> -->
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                
                         
                                <div class="am-u-sm-12">
                                <form action="${pageContext.request.contextPath }/movieperformer/performer-edit" method="post">
                                <!-- 从浏览器地址栏的内容中把参数对的数值获取到 -->
                                <input type="hidden" name="mid" value="${param.id}">
                                    <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black " id="example-r">
                                        <thead>
                                            <tr>
                                                <th>电影ID</th>
                                                <th>电影演员</th>
                                                <th>角色</th>
                                                <th>操作</th>
                                            </tr>
                                        </thead>
                                        <tbody id="tbody1">
                                        <!-- 循环 -->
                                        <c:forEach items="${mperformers }" var="per"  varStatus="sta">
                                            <tr class="gradeX" id="${sta.count}">
                                                <td><input name="list[${sta.index }].id" value="${per.id }" readonly="readonly"></td>
                                                <td><a href="">你喜欢的演员--<input name="list[${sta.index }].performer" value="${per.performer}"></a></td>
                                                <td><input name="list[${sta.index }].role" value="${per.role}"></td>
                                                <td>                                        
                                                <div  class="tpl-table-black-operation"> 
                                                 <a href="javascript:deleteTr(${sta.count})" class="tpl-table-black-operation-del">
                                                            <i class="am-icon-trash"></i> 删除当前行
                                                 </a>
                                                </div>
                                                
                                                </td>
                                            </tr>
                                            </c:forEach>
                                            
                                            <!-- more data -->
                                        </tbody>
                                    </table>
                                    <hr>
                                        <button type="submit" class="am-btn am-btn-primary tpl-btn-bg-color-success ">提交</button>
                                        <button  onclick="javascript:goback()" class="am-btn am-btn-primary tpl-btn-bg-color-success ">返回</button>
                                        
                                   </form>
                                </div>
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
   
  
    <script src="${pageContext.request.contextPath }/assets/js/amazeui.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/amazeui.datatables.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/dataTables.responsive.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/app.js"></script>

</body>
<script type="text/javascript">
//返回按钮
function goback() {
	location.href="${pageContext.request.contextPath}/movieperformer/movie-show";
}

//删除一行
function deleteTr(id) {
	//获取到tbody
	var tbody= document.getElementById("tbody1");
	
	//获取到tr
	var tr= document.getElementById(id);
	
	//找出tr的索引
	var index =tr.rowIndex;
	
	//按照tr的索引从tbody中删除
	tbody.deleteRow(index-1);
}
//添加table中的一行
function addTr() {
	//获取到tbody
	var tbody=document.getElementById("tbody1");	
	//在其中添加一行，缺少tr标签，只是插入一个空行
    var tr=	 tbody.insertRow(tbody.rows.length);
	
	//给新填的一行添加索引，获取当前总行数在减1.
	var num= tbody.rows.length;
	var index = num -1;
	tr.id=num;
	//在新填的一行设置元素
	tr.innerHTML=

	' <tr class="gradeX" id="${'+num+'}">'
				+ '  <td><input name="list['+index+'].id"></td>'
				+ ' <td><a href="">你喜欢的演员--<input name="list['+index+'].performer" ></a></td>'
				+ ' <td><input name="list['+index+'].role" ></td>'
				+ ' <td>          '
				+ ' <div  class="tpl-table-black-operation"> '
				+ '  <a href="javascript:deleteTr('+num+')" class="tpl-table-black-operation-del">'
				+ '            <i class="am-icon-trash"></i> 删除当前行' + '  </a>'
				+ ' </div>' +

				' </td>' + '</tr>'

	}
</script>
</html>