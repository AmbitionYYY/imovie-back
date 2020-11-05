<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>数据统计页面</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
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
<style type="text/css">
.fourtj{float:left;}
.widget4{width:312px;}
.width1{width:1220px;}
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
        <div class="tpl-content-wrapper">
			<!-- 内容头部 -->
            <div class="container-fluid am-cf">
                <div class="row">
                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-9">
                        <div class="page-header-heading"><span class="am-icon-home page-header-heading-icon"></span> 数据统计 <small>Data statistics</small></div>
                        <p class="page-header-description">在此页面中你可以看到一些统计数据比如：总电影数量、总演员数量、总注册用户数量、总分类数量和几种列表：排名列表、电影分类排名、不同类型下电影总数排名、以及访问日志列表。</p>
                    </div>
                    <div class="am-u-lg-3 tpl-index-settings-button">
                       
                    </div>
                </div>
            </div>
			<!-- 内容头部结束-->
            <div class="row-content am-cf">
            <!-- 四个数据统计 -->
                <div class="row  am-cf" >
                    
                        <div class="widget widget4 widget-primary am-cf fourtj">
                            <div class="widget-statistic-header">
                              电影总数
                            </div>
                            <div class=" widget-statistic-body">
                                <div class="widget-statistic-value">
                                    ${dataBean.movienum }
                                </div>
                                <div class="widget-statistic-description">
                                    都是特别 <strong>好看</strong> 的电影
                                </div>
                                <span class="widget-statistic-icon am-icon-credit-card-alt"></span>
                            </div>
                        </div>
                    
                   
                  
                        <div class="widget widget4 widget-purple am-cf fourtj">
                            <div class="widget-statistic-header">
                               演员总数
                            </div>
                            <div class="widget-statistic-body">
                                <div class="widget-statistic-value">
                                   ${dataBean.performernum } 
                                </div>
                                <div class="widget-statistic-description">
                                    都是特别 <strong>霸气</strong> 的演员
                                </div>
                                <span class="widget-statistic-icon am-icon-support"></span>
                            </div>
                        </div>
                   
                    
                   
                        <div class="widget widget4 widget-primary am-cf fourtj">
                            <div class="widget-statistic-header">
                                用户总数
                            </div>
                            <div class="widget-statistic-body">
                                <div class="widget-statistic-value">
                                     ${dataBean.usernum }
                                </div>
                                <div class="widget-statistic-description">
                                    都是特别 <strong>帅气</strong> 的用户
                                </div>
                                <span class="widget-statistic-icon am-icon-credit-card-alt"></span>
                            </div>
                        </div>
                    
                      
                        <div class="widget widget4 widget-purple am-cf fourtj">
                            <div class="widget-statistic-header">
                               分类总数
                            </div>
                            <div class="widget-statistic-body">
                                <div class="widget-statistic-value">
                                   ${dataBean.categroynum }
                                </div>
                                <div class="widget-statistic-description">
                                   都是人们 <strong>爱看</strong> 的的电影分类
                                </div>
                                <span class="widget-statistic-icon am-icon-support"></span>
                            </div>
                        </div>
                    </div>          
                
				 <!-- 四个数据统计结束-->
				 <!-- 分类排名开始 -->
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-6">
                        <div class="widget am-cf">
                            <div class="widget-head am-cf">
                                <div class="widget-title am-fl">
                                <i class="am-icon-bar-chart"></i>
                                <span> 分类排名</span></div>
                                <div class="widget-function am-fr">   
                                </div>
                            </div>
                            <div class="widget-body  widget-body-lg am-fr">

                                <table width="100%" class="am-table am-table-compact tpl-table-black " id="example-r">
                                    <thead>
                                        <tr>
                                            <th>分类名称</th>
                                            <th>分类总数</th>
                                            <th>平均评分</th>
                                            <th>分类占比</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${dataBean.rankings}" var="rank">
                                        <tr class="gradeX">
                                            <td>${rank.name}</td>
                                            <td>${rank.num}</td>
                                            <td>${rank.avgscore}</td>
                                            <td>${rank.percent}%</td>
                                        </tr>
                                        </c:forEach>
                                        
                                        <!-- more data -->
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>

				 <!-- 分类排名结束 -->

                <div class="row am-cf">
                <!--   禁言小张装饰栏开始 -->
                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-4 widget-margin-bottom-lg ">
                        <div class="tpl-user-card am-text-center widget-body-lg">
                            <div class="tpl-user-card-title">
                                施瓦辛格
                            </div>
                            <div class="achievement-subheading">
                                年度最受欢迎影星
                            </div>
                            <img class="achievement-image" src="${pageContext.request.contextPath }/assets/img/user07.png" alt="">
                            <div class="achievement-description">
                       阿诺德·施瓦辛格（Arnold Schwarzenegger），1947年7月30日生于奥地利，奥林匹亚先生 [1]  、健美运动员、力量举运动员、演员、导演、制片人、加州州长、政治家，拥有美国/奥地利双重国籍。 [2] 
施瓦辛格幼时练习健美，1967年20岁时获得了环球健美及奥林匹亚先生头衔。1968年，到美国发展后，在大学修习工商管理，并开班授课、拍摄健美录像带。 [3]  1970年进入影视圈，1984年拍摄的《终结者》塑造了阿诺冷酷的银幕形象，之后接连拍摄多部动作片。 [4]  2003年竞选加州州长获得成功，跨入政坛。 [5]  2011年1月3日卸任，任期达7年。 [6]  卸任后的施瓦辛格重返大银幕，继续接拍电影。
                       
                            </div>
                        </div>
                    </div>
 					<!--   禁言小张装饰栏结束 -->
 					
 					
 					
                    <!-- 访问日志开始 -->
               <div class="am-u-sm-12 am-u-md-12 am-u-lg-8  " id="moviedisplay">

                        <div class="widget width1  am-cf widget-body-lg" >

                            <div class="widget-body  am-fr">
                                <div class="am-scrollable-horizontal " >
                         <!-- 表格标题与“看更多超链接”  -->  
                             <div class=" am-cf">
                                <div class="widget-title am-fl" style="font-size:22px;color:green">系统访问日志</div>
                                <div class="widget-function am-fr">
                                    <a href="${pageContext.request.contextPath }/movie/movie-show" class="am-icon-star">点我看电影</a>
                                </div>
                            </div>
                                    <table width="100%" class="am-table am-table-compact am-text-nowrap tpl-table-black " id="example-r">
                                        <thead>
                                            <tr>
                                               <th>访问id</th>
                                              <th>访问路径</th>
                                              <th>用户ip</th>
                                              <th>访问时间</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                          <!-- 电影表格开始的一项 -->
                                            <c:forEach items="${dataBean.logs }" var="log">
                                            <tr class="even gradeC">
                                                <td>${log.logid }</td>  
                                                <td>${log.logurl }</td>  
                                                <td>${log.logip }</td> 
                                                <td><fmt:formatDate value="${log.logdate }" pattern="yyyy年-MM月-dd日 HH时:mm分:ss秒"/></td>                                            
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
                     <!-- 访问日志结束 -->
                </div>
            </div>
        </div>
    </div>
   
    <script src="${pageContext.request.contextPath }/assets/js/amazeui.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/amazeui.datatables.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/dataTables.responsive.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/app.js"></script>

</body>

</html>