<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>爱电影后台管理项目</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath }/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath }/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="main" />
    <script src="${pageContext.request.contextPath }/assets/js/echarts.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/app.css">
    <script src="${pageContext.request.contextPath }/assets/js/jquery.min.js"></script>
<style type="text/css">

#bottom2{margin-bottom:10px;}
#moviedisplay{position:relative;left:260px;}
#performersdisplay{position:relative;left:260px;}
</style>
</head>

<body data-type="index">
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
        <div class="tpl-content-wrapper" id="bottom2" >

            <div class="container-fluid am-cf">
                <div class="row">
                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-9">
                        <div class="page-header-heading"><span class="am-icon-home page-header-heading-icon"></span> 爱电影 <small>后台管理主页</small></div>
                        <p class="page-header-description">当前您所在的位置是：</p>
                             <p class="page-header-description">爱电影项目的主页，在此页中您可以查看部分电影列表信息和部分演员列表信息。</p>
                        
                    </div>
                    <div class="am-u-lg-3 tpl-index-settings-button">
                       <!--  <button type="button" class="page-header-button"><span class="am-icon-paint-brush"></span> 设置</button> -->
                    </div>
                </div>

            </div>
            
            
			
			
			<!-- 添加电影列表展示与演员列表展示 -->
            	<!-- 电影开始 -->
               
               <div class="am-u-sm-12 am-u-md-12 am-u-lg-8 widget-margin-bottom-lg" id="moviedisplay">

                        <div class="widget am-cf widget-body-lg" >

                            <div class="widget-body  am-fr">
                                <div class="am-scrollable-horizontal " >
                         <!-- 表格标题与“看更多超链接”  -->  
                             <div class="widget-head am-cf">
                                <div class="widget-title am-fl" style="font-size:22px;color:green">部分电影列表展示</div>
                                <div class="widget-function am-fr">
                                    <a href="${pageContext.request.contextPath }/movie/movie-show" class="am-icon-star">看更多...</a>
                                </div>
                            </div>
                                    <table width="100%" class="am-table am-table-compact am-text-nowrap tpl-table-black " id="example-r">
                                        <thead>
                                            <tr>
                                                <th>电影简介</th>
                                                <th>电影时长</th>   
                                                <th>豆瓣评分</th> 
                                                <th>播放地址</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                          <!-- 电影表格开始的一项 -->
                                            <c:forEach items="${movies }" var="mov">
                                            <tr class="even gradeC">
                                                <td>推荐观看电影：《${mov.moviename }》</td>
                                                <td>${mov.time }<i class="am-icon-bell"></i></td>
                                               
                                                <td>
                                                    <div class="tpl-table-black-operation">
                                                      ${mov.score} 
                                                    </div>
                                                </td>
                                                <td>${mov.url }</td>
                                            </tr>
                                           </c:forEach>
                                            <!-- more data -->
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                    </div>
               
               <hr>
               <hr>
				<!-- 电影结束 -->
			<!-- 演员开始 -->
			<div class="am-u-sm-12 am-u-md-12 am-u-lg-8 widget-margin-bottom-lg" id="performersdisplay">

                        <div class="widget am-cf widget-body-lg" >

                            <div class="widget-body  am-fr">
                                <div class="am-scrollable-horizontal " >
                         <!-- 表格标题与“看更多超链接”  -->  
                             <div class="widget-head am-cf">
                                <div class="widget-title am-fl" style="font-size:22px;color:green">部分演员列表展示</div>
                                <div class="widget-function am-fr">
                                    <a href="${pageContext.request.contextPath }/performer/performer-show" class="am-icon-star">看更多...</a>
                                </div>
                            </div>
                                    <table width="100%" class="am-table am-table-compact am-text-nowrap tpl-table-black " id="example-r">
                                        <thead>
                                            <tr>
                                                <th>演员姓名</th>
                                                <th>地址</th>   
                                                <th>生日</th> 
                                                <th>星座</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                          <!-- 电影表格开始的一项 -->
                                            <c:forEach items="${performers }" var="per">
                                            <tr class="even gradeC">
                                                <td><a href="${pageContext.request.contextPath }/performer/performer-look-show?name=${per.name }">人气超高演员：${per.name }</a></td>
                                                <td>${per.address }</td>
                                               
                                                <td>
                                                    <div class="tpl-table-black-operation">
                                                      ${per.birthday} 
                                                    </div>
                                                </td>
                                                <td>${per.constellation }</td>
                                            </tr>
                                           </c:forEach>
                                            <!-- more data -->
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                    </div>
			
			
			<!-- 演员结束 -->
			
			<!-- 添加电影列表展示与演员列表展示结束 -->
			

            
        </div>
    </div>
 
    <script src="${pageContext.request.contextPath }/assets/js/amazeui.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/amazeui.datatables.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/dataTables.responsive.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/app.js"></script>

</body>

</html>