<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>电影展示页面</title>
    <meta name="description" content="这是一个 movie show 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath }/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath }/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/app.css">
    <script src="${pageContext.request.contextPath }/assets/js/jquery.min.js"></script>
<style type="text/css">
#shenhe{
color:white;
}
#xinzeng{margin-left:450px;}
</style>
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
                                <div class="widget-title  am-cf">电影信息查看列表</div>
                            </div>
                            
                            
                            <div class="widget-body  am-fr">
		<!-- 新增按钮 -->
       <button type="button" onclick="toAddMovie()" id="xinzeng" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span> 新增</button>
		
         <!-- 搜索框 -->  
                                <div class="am-u-sm-12 am-u-md-6 am-u-lg-3">
                                    <div class="am-form-group tpl-table-list-select">
                                        <select id="selCategroy" data-am-selected="{btnSize: 'sm'}">
                                        <c:forEach items="${list }" var="opt">
                                        <c:choose>
                                        <c:when test="${opt==conditionBean.caption }">
                                <option value="${opt }" selected="selected">${opt }</option>
                                        
                                        </c:when>
                                        <c:otherwise>
                                        <option value="${opt }">${opt }</option>
                                        </c:otherwise>
                                        
                                        </c:choose>
             
                                        </c:forEach>
           
           								 </select>
                                    </div>
                                </div>
                                
			<!-- 搜索按钮 -->
                                <div class="am-u-sm-12 am-u-md-12 am-u-lg-3">
                                    <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                        <input id="keyword" value="${conditionBean.keyword }" type="text" class="am-form-field ">
                                        <span class="am-input-group-btn">
            <button onclick="searchAndPage(1)" class="am-btn  am-btn-default am-btn-success tpl-table-list-field am-icon-search" type="button"></button>
          </span>
                                    </div>
                                </div>
							<!-- 电影信息表格 -->
                                <div class="am-u-sm-12">
                                    <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black ">
                                        <thead>
                                            <tr>
                                                <th>电影缩略图</th>
                                                <th>电影名称</th>
                                                <th>豆瓣评分</th>
                                                <th>上映时间</th>
                                                <th>操作</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <!-- 列表开始的一项 -->
                                        <c:forEach items="${pageInfo.list }" var="mov">
                                            <tr class="gradeX">
                                                <td>
                                                    <img src="${mov.saveimagepath}" class="tpl-table-line-img" alt="">
                                                </td>
                                                <td class="am-text-middle">《${mov.moviename}》</td>
                                                <td class="am-text-middle">★${mov.score }★</td>
                                                <td class="am-text-middle">2020-06-20</td>
                                                <td class="am-text-middle">
                                                    <div class="tpl-table-black-operation">
                                                    
                                                        <a href="javascript:toEditShow(${mov.id })">
                                                            <i class="am-icon-pencil"></i> 编辑
                                                        </a>
					                                          <a  href="javascript:toAuditing(${mov.id })" id="shenhe" class="am-btn am-btn-default am-btn-warning">
					                                          <i class="am-icon-archive"></i> 审核
					                                          </a>
                                                        
                                                        <a href="javascript:deleteMovie('${mov.id}','${mov.moviename }')" class="tpl-table-black-operation-del">
                                                            <i class="am-icon-trash"></i> 删除
                                                        </a>
                                                        </div>
                                                    
                                                </td>
                                            </tr>
                                            </c:forEach>
                                            <!-- 列表结束的一项 -->
                                            
                                            
                                            
                                            <!-- more data -->
                                        </tbody>
                                    </table>
                                </div>
                                <div class="am-u-lg-12 am-cf">

                                    <div class="am-fr">
                                        <ul class="am-pagination tpl-pagination">
                           
                      <!--首页  -->  
                      <li ><a href="javascript:searchAndPage(1)">首页</a></li>
                        
                                            <c:choose>                            
                                   <c:when test="${pageInfo.pageNum<=1 }">
                                              <li class="am-disabled"><a href="#">«</a></li>     
                                     </c:when>
                                            <c:otherwise>
                                            <li ><a href="javascript:searchAndPage(${pageInfo.pageNum - 1 })">«</a></li>
                                            </c:otherwise>
                                            </c:choose>  
                                            
                                                 
                                                 
                                                                                     
                                            <c:forEach items="${pageInfo.navigatepageNums }" var="num">
                                        
                                            <c:choose>
                                            <c:when test="${num==pageInfo.pageNum }">
 												<li class="am-active"><a href="javascript:searchAndPage(${num })">${num }</a></li>                                    
 											 </c:when>
                                            <c:otherwise>
                                            <li ><a href="javascript:searchAndPage(${num })">${num }</a></li>
                                            </c:otherwise>
                                            </c:choose>
                                          
                                            </c:forEach>
                                            
                                            
                                            
                                            
                                            
                                            <c:choose>
                                            <c:when test="${pageInfo.pageNum>=pageInfo.pages }">
										<li class="am-disabled"><a href="#">»</a></li>                                            
                                            </c:when>
                                            <c:otherwise>
                                            <li ><a href="javascript:searchAndPage(${pageInfo.pageNum + 1 })">»</a></li>
                                            </c:otherwise>  
                                            </c:choose>   
                                            
                                   <!-- 尾页 -->
									<li ><a href="javascript:searchAndPage(${pageInfo.pages })">尾页</a></li>
                                            
                                            
                                          
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
   <!-- 隐藏表单，表单中包含一些隐藏框，隐藏框保存某些数据，实现此表单的数据提交 -->
   <form action="${pageContext.request.contextPath }/movie/movie-show" method="post" id="hidForm">
   <!-- 保存页码 -->
   <input type="hidden" name="currentPage" id="currentPage" >
   <!-- 保存下拉列表中的value值，保存关键字的值 -->
<!--    <input type="hidden" name="" id="所有类型">-->  
 <input type="hidden" name="area" id="地区">
   <input type="hidden" name="type" id="类型">
   <input type="hidden" name="style" id="规格">
   <input type="hidden" name="year" id="我的年代">
   <input type="hidden" name="name" id="电影名称">
   </form>
   
   
    <script src="${pageContext.request.contextPath }/assets/js/amazeui.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/app.js"></script>

</body>
<script type="text/javascript">
//用于分页和搜索两个功能
function searchAndPage(currentPage) {
	//给隐藏制设置值
	$("#currentPage").val(currentPage);
	//先获取的select获取到的值,在获取关键字
	var selvalue=	$("#selCategroy").val();
	var keyword=	$("#keyword").val();
	
	//给隐藏框设置值
	$("#"+selvalue).val(keyword);
	
	//表单提交
	$("#hidForm").submit();
}

//进入录入数据界面
function toAddMovie() {
	location.href="${pageContext.request.contextPath}/movie/movie-add-show";
}
//进入修改页面
function toEditShow(id) {
	location.href="${pageContext.request.contextPath}/movie/movie-edit-show?id="+id;
	
}
//进入审核界面
function toAuditing(id) {
	location.href="${pageContext.request.contextPath}/movie/movie-audit-show?id="+id;
}
//删除电影
function deleteMovie(id,name) {
	//要有一定的提示，较为明确
	//	alert(id+"--"+name);
var bo=	confirm("您是否要删除电影《"+name+"》");
if(bo){
	//当确定要删除时，要有删除条件假如按id删除
	//alert("删除");
	location.href="${pageContext.request.contextPath}/movie/movie-delete?id="+id;
	
}else{
	//不删除
	alert("您取消了对当前电影的删除操作！");
}
	//当确定要删除的时候，还需要有删除的条件假如按id删除
}

</script>
</html>