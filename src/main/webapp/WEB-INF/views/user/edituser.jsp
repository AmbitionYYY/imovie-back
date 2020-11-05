<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>修改账户设置界面</title>
    <meta name="description" content="这是一个 index 页面">
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

</head>

<body data-type="login">
    <script src="${pageContext.request.contextPath }/assets/js/theme.js"></script>
    <div class="am-g tpl-g">
        <!-- 风格切换 -->
        <div class="tpl-skiner">
            <div class="tpl-skiner-toggle am-icon-cog">
            </div>
            <div class="tpl-skiner-content">
                <div class="tpl-skiner-content-title">
                    选择主题
                </div>
                <div class="tpl-skiner-content-bar">
                    <span class="skiner-color skiner-white" data-color="theme-white"></span>
                    <span class="skiner-color skiner-black" data-color="theme-black"></span>
                </div>
            </div>
        </div>
        <div class="tpl-login">
            <div class="tpl-login-content">
                <div class="tpl-login-title">修改账户信息</div>
                <span class="tpl-login-content-info">
                 修改密码
              </span>


               <form:form class="am-form tpl-form-line-form" id="editForm" action="${pageContext.request.contextPath }/user/edituser" method="post" modelAttribute="user">
                    

                    <div class="am-form-group">
                       <form:input  type="text"  class="tpl-form-input" path="username" readonly="true" value="${username}"   id="username1" ></form:input>
                    </div>

                    <div class="am-form-group">
                       <form:input type="password" path="password" class="tpl-form-input" id="password1" placeholder="请输入密码"></form:input>
                         <span style="color:red" id="spanpwd1"></span>
                    </div>

                    <div class="am-form-group">
                        <input type="password" class="tpl-form-input" id="password2" placeholder="再次输入密码">
                         <span style="color:red" id="spanpwd2"></span>
                    </div>

                    <div class="am-form-group">

                        <a href="javascript:eidtpassword()" class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn">保存修改</a>

                    </div>
                </form:form>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath }/assets/js/amazeui.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/app.js"></script>

</body>
<script type="text/javascript">
	
//对输入的密码进行校验
	function checkPassword() {
		//获取密码
		var p1= $("#password1").val();
		var p2= $("#password2").val();
		if(p1!=null && p1.length>0){
			
			if(p1==p2){
				$("#spanpwd1").text("");
				$("#spanpwd2").text("");
				return true;
		}else{
			$("#spanpwd1").text("");
			$("#spanpwd2").text("两次密码不一致！");
			return false;
		     }		
	  }else{
		  $("#spanpwd1").text("密码不能为空！");
			$("#spanpwd2").text("");
			return false;
	  }
   }
	

	function eidtpassword() {
		var cp= checkPassword();
		//再次验证两次密码是否一致  repeatPassword() true/false
		if(cp){
			//表单提交
			$("#editForm").submit();//等价于标签的submit	
		}else{
			alert("设置密码出现错误，请重新输入！");
			location.href="${pageContext.request.contextPath}/user/edituser-show";
		}
	}
</script>
</html>