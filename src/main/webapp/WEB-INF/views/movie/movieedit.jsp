<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>电影信息编辑</title>
    <meta name="description" content="这是一个 edit 页面">
    <meta name="keywords" content="edit">
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

            <div class="container-fluid am-cf">
                <div class="row">
                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-9">
                        <div class="page-header-heading"><span class="am-icon-home page-header-heading-icon"></span>编辑电影 <small>update a movie</small></div>
                        <p class="page-header-description">在此页面你可以更改电影的相关信息。</p>
                    </div>
                    <div class="am-u-lg-3 tpl-index-settings-button">
                        <button type="button" class="page-header-button"><span class="am-icon-paint-brush"></span> 设置</button>
                    </div>
                </div>

            </div>

            <div class="row-content am-cf">


                <div class="row">

                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                        <div class="widget am-cf">
                            <div class="widget-head am-cf">
                                <div class="widget-title am-fl">电影信息编辑</div>
                                <div class="widget-function am-fr">
                                    <a href="javascript:;" class="am-icon-cog"></a>
                                </div>
                            </div>
                            <div class="widget-body am-fr">

					<!-- 表单开始 -->			
                                <form class="am-form tpl-form-line-form" action="${pageContext.request.contextPath }/movie/movie-edit" method="post" id="" enctype="multipart/form-data">
                              <!-- 隐藏框 -->
								<input type="hidden" name="id" value="${movie.id }">
                              
                                <!-- 一个input开始 -->
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label" >电影名称 <span class="tpl-form-line-small-title">MovieName</span></label>
                                        <div class="am-u-sm-9">
                                            <input type="text" class="tpl-form-input" name="moviename" id="moviename" value="${movie.moviename }" placeholder="请输入电影名称">
                                        </div>
                                    </div>
                                <!-- 一个input结束 -->
                                  <!-- 一个input开始 -->
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">电影时长<span class="tpl-form-line-small-title">MovieTime</span></label>
                                        <div class="am-u-sm-9">
                                            <input type="text" class="tpl-form-input" name="movietime" id="user-name" value="${movie.time }" placeholder="请输入电影时长">
                                        </div>
                                    </div>
                                <!-- 一个input结束 -->
                                  <!-- 一个input开始 -->
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">播放路径<span class="tpl-form-line-small-title">Url</span></label>
                                        <div class="am-u-sm-9">
                                            <input type="text" class="tpl-form-input" name="url" id="user-name" value="${movie.url }" placeholder="请输入播放路径">
                                        </div>
                                    </div>
                                <!-- 一个input结束 -->
                                  <!-- 一个input开始 -->
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">图片路径<span class="tpl-form-line-small-title">ImagePath</span></label>
                                        <div class="am-u-sm-9">
                                            <input type="text" class="tpl-form-input" name="imagepath" value="${movie.imagepath }"  id="user-name" placeholder="请输入图片路径">
                                        </div>
                                    </div>
                                <!-- 一个input结束 -->
                                  <!-- 一个input开始 -->
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">封面海报<span class="tpl-form-line-small-title">Upload</span></label>
                                        
                                        <div class="am-u-sm-9 am-btn  am-btn-sm">
                                            <input type="file" class="file" name="files" id="user-name" placeholder="请选择一张上传图片">
                                        </div>
                                    </div>
                                <!-- 一个input结束 -->
                                
                                  <!-- 一个input开始 -->
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">电影评分<span class="tpl-form-line-small-title">Score</span></label>
                                        <div class="am-u-sm-9">
                                            <input type="text" class="tpl-form-input" id="user-name" name="score" value="${movie.score }" placeholder="请输入电影评分">
                                        </div>
                                    </div>
                                <!-- 一个input结束 -->
                                  <!-- 一个input开始 -->
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">电影导演<span class="tpl-form-line-small-title">Director</span></label>
                                        <div class="am-u-sm-9">
                                            <input type="text" class="tpl-form-input" name="director" value="${movie.moviedetail.director }" id="user-name" placeholder="请输入电影导演">
                                        </div>
                                    </div>
                                <!-- 一个input结束 -->
                                

                                    <div class="am-form-group">
                                        <label class="am-u-sm-3 am-form-label">关键字 <span class="tpl-form-line-small-title">keyword</span></label>
                                        <div class="am-u-sm-9">
                                            <input type="text" name="keyword" value="${movie.moviedetail.keyword }" placeholder="输入关键字">
                                        </div>
                                    </div>

                                    

                                    <div class="am-form-group">
                                        <label for="user-weibo" class="am-u-sm-3 am-form-label">添加分类 <span class="tpl-form-line-small-title">Categroy</span></label>
                                        <div class="am-u-sm-9">
                                            <input type="text" name="categroy" value="${movie.moviedetail.categroy }" id="user-weibo" placeholder="请添加分类用逗号隔开">
                                            <div>

                                            </div>
                                        </div>
                                    </div>

               

                                    <div class="am-form-group">
                                        <label for="user-intro" class="am-u-sm-3 am-form-label">电影简介</label>
                                        <div class="am-u-sm-9">
                                            <textarea class="" rows="10" name="des" id="user-intro" placeholder="请输入电影简介内容">${movie.moviedetail.des}</textarea>
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                    <div class="am-u-sm-9 am-u-sm-push-3">
                                        <button type="submit" class="am-btn am-btn-primary tpl-btn-bg-color-success ">提交</button>
                                        <button  onclick="javascript:goback()" class="am-btn am-btn-primary tpl-btn-bg-color-success ">返回</button>
                                        
                                    </div>
                                </div>
                                </form>
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
function goback() {
	location.href="${pageContext.request.contextPath}/movie/movie-show";
}
</script>


</html>