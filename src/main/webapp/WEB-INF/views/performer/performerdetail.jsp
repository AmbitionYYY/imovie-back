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
        <div class="aaa" >
            <div class="row-content am-cf">
     
                    
                        
                            <div class="widget-head am-cf">
                                <div class="widget-title  am-cf">电影出演人员展示</div>
                            </div>
                            
                           
            <div class="tpl-content-page-title">
              	 演员详情
            </div>
                        <div class="am-u-sm-12">
                            <form class="am-form">
                                <table class="am-table am-table-striped am-table-hover table-main">
                                    <tbody>
                                        <tr>
                                            <td rowspan="3" width="100px">
                                            	<img src="${pageContext.request.contextPath }/assets/img/user05.png"/>
											</td>
                                            <td>姓名:${performer.name }</td>
                                            <td>性别:${performer.sex }</td>
                                        </tr>
                                        <tr>
                                            <td>英文:${performer.e_name }</td>
                                            <td>血型:${performer.bloodtype }</td>
                                        </tr>
                                        <tr>
                                            <td>艺名:${performer.alias }</td>
                                            <td>身高:${performer.height }</td>
                                        </tr>
                                        <tr>
                                            <td>地址:${performer.address }</td>
                                            <td>日期:${performer.birthday }</td>
                                        </tr>
                                        <tr>
                                            <td>星座:${performer.constellation }</td>
                                            <td>籍贯:${performer.location }</td>
                                            <td>居住:${performer.residentialAddress }</td>
                                        </tr>
                                        <tr>
                                            <td>毕业学校:${performer.school }</td>
                                            <td>签约公司:${performer.brokerageAgency }</td>
                                            <td>出道时间:${performer.fameyear }</td>
                                        </tr>
                                        <tr>
                                            <td>特长:${performer.hobby }</td>
                                            <td>${performer.occupation }</td>
                                            <td>${performer.weight }</td>
                                        </tr>
                                        <tr>
                                            <td colspan="3">${performer.des }</td>
                                        </tr>
                                    </tbody>
                                </table>
                           
                                <hr>

                            </form>
                                                        
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
function goback() {
	location.href="${pageContext.request.contextPath}/movieperformer/movie-show";
}
</script>
</html>