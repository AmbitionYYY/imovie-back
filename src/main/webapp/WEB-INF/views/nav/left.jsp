<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>爱电影后台管理项目</title>
    <meta name="description" content="这是一个 left 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    
    <meta name="apple-mobile-web-app-title" content="left" />
 

</head>

<body data-type="index">
    <script src="${pageContext.request.contextPath }/assets/js/theme.js"></script>
    <div class="am-g tpl-g">
       

        <!-- 侧边导航栏 -->
         <div class="left-sidebar">
            <!-- 用户信息 -->
            <div class="tpl-sidebar-user-panel">
                <div class="tpl-user-panel-slide-toggleable">
                    <div class="tpl-user-panel-profile-picture">
                        <img src="${pageContext.request.contextPath }/assets/img/user04.png" alt="">
                    </div>
                    <span class="user-panel-logged-in-text">
              <i class="am-icon-circle-o am-text-success tpl-user-panel-status-icon"></i>
            ${username}
          </span>
                    <a href="${pageContext.request.contextPath}/user/edituser-show" class="tpl-user-panel-action-link"> <span class="am-icon-pencil"></span> 账号设置</a>
                </div>
            </div>

            <!-- 菜单 -->
            <ul class="sidebar-nav">
                <li class="sidebar-nav-heading">爱电影<span class="sidebar-nav-heading-info"> 后台管理项目导航</span></li>
                <li class="sidebar-nav-link">
                    <a href="${pageContext.request.contextPath }/main/main-show" class="active">
                        <i class="am-icon-home sidebar-nav-link-logo"></i> 首页
                    </a>
                </li>
               
              
               
                <li class="sidebar-nav-link">
                    <a href="${pageContext.request.contextPath }/data/data-show">
                        <i class="am-icon-bar-chart sidebar-nav-link-logo"></i> 数据统计

                    </a>
                </li>

                <li class="sidebar-nav-heading">Page<span class="sidebar-nav-heading-info"> 常用页面</span></li>
                <li class="sidebar-nav-link">
                    <a href="javascript:;" class="sidebar-nav-sub-title">
                        <i class="am-icon-table sidebar-nav-link-logo"></i> 电影信息编辑
                        <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                    </a>
                    <ul class="sidebar-nav sidebar-nav-sub">
                        <li class="sidebar-nav-link">
                           <a href="${pageContext.request.contextPath }/movie/movie-show">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 电影信息查看
                            </a>
                        </li>

                        <li class="sidebar-nav-link">
                            <a href="${pageContext.request.contextPath}/movie/movie-add-show">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 电影信息添加
                            </a>
                        </li>
                    </ul>
                </li>
                 <li class="sidebar-nav-link">
                    <a href="javascript:;" class="sidebar-nav-sub-title">
                        <i class="am-icon-table sidebar-nav-link-logo"></i> 电影参演编辑
                        <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                    </a>
                    <ul class="sidebar-nav sidebar-nav-sub">
                        <li class="sidebar-nav-link">
                            <a href="${pageContext.request.contextPath }/movieperformer/movie-show">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 参演查看
                            </a>
                        </li>

                       
                    </ul>
                </li>
                 <li class="sidebar-nav-link">
                    <a href="javascript:;" class="sidebar-nav-sub-title">
                        <i class="am-icon-table sidebar-nav-link-logo"></i> 演员编辑
                        <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                    </a>
                    <ul class="sidebar-nav sidebar-nav-sub">
                        <li class="sidebar-nav-link">
                            <a href="${pageContext.request.contextPath }/performer/performer-show">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 演员信息查看
                            </a>
                        </li>

                        <li class="sidebar-nav-link">
                            <a href="table-list-img.html">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 演员信息添加
                            </a>
                        </li>
                    </ul>
                </li>
              
                <li class="sidebar-nav-link">
                    <a href="${pageContext.request.contextPath }/user/logout">
                        <i class="am-icon-key sidebar-nav-link-logo"></i> 注销
                    </a>
                </li>
               

            </ul>
        </div> 
<!-- 侧边导航栏结束 -->

    </div>
   

</body>

</html>