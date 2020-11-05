<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>爱电影后台管理项目</title>
    <meta name="description" content="这是一个 register 页面">
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
                <div class="tpl-login-title">注册用户</div>
                <span class="tpl-login-content-info">
                  创建一个新的用户
              </span>


                <form:form class="am-form tpl-form-line-form" action="${pageContext.request.contextPath }/user/user-register" method="post" id="registerForm" modelAttribute="user">
                   

                    <div class="am-form-group">
                        <form:input type="text"  id="user-name" path="username" placeholder="请输入用户名" onblur="checkName(this.value)"></form:input>
                        <form:errors path="username" cssStyle="color:red;" ></form:errors>
                        <span style="color:red" id="spanname"></span>
                    </div>

                    <div class="am-form-group">
                        <form:input type="password" path="password" class="tpl-form-input" id="user-pwd1"  placeholder="请输入密码"/>
                        <form:errors path="password" cssStyle="color:red;"></form:errors>   
                                     <span style="color:red" id="spanpwd1"></span>
                        
                    </div>

                    <div class="am-form-group">
                        <input type="password" class="tpl-form-input" id="user-pwd2" value="${user.password }" placeholder="再次输入密码">
                                    <span style="color:red" id="spanpwd2"></span>
                        
                    </div>

                    <div class="am-form-group tpl-login-remember-me">
                        <input id="remember-me" type="checkbox">
                        <label for="remember-me">
       
                        我已阅读并同意 <a href="javascript:;">《用户注册协议》</a> 
                         </label>

                    </div>

                    <div class="am-form-group">
						
                        <a href="javascript:register()" class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn" onblur="repeatPassword()">提交</a>
						 <a href="javascript:showLogin()" class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn">返回登录界面</a>
						
                    </div>
                </form:form>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath }/assets/js/amazeui.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/app.js"></script>

</body>
<script type="text/javascript">
 function showLogin() {
	 location.href = "${pageContext.request.contextPath }/user/user-login-show";
	 }

//检查用户名是否存在
	var cn=false;
 function checkName(name) {
	//alert(name);
	//执行检测
	$.ajax({
		url:"${pageContext.request.contextPath }/user/check-username",
		type:"post",
		data:"name="+name,
		dataType:"json",
		success:function(obj){
			console.log(obj);
			//true表示存在
			 if(obj.key){
				$("#spanname").text("用户名已经存在，换一个吧！");
			}
			
			else{
				$("#spanname").text("");
					cn=true;
			}
			
		}
	});
				}
 
 function repeatPassword() {
	//获取密码
	var p1= $("#user-pwd1").val();
	var p2= $("#user-pwd2").val();
	//alert(p1);
	//alert(p2);
	if(p1!=null&&p1.length>0){
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
 
 //拓展函数校验用户名和密码是否符合约束
 //不在前端实现约束校验，把用户名和密码的校验放到后台controller
 function checkNameAndPassword() {
	
}
 
 
  	function register() {
		var rp= repeatPassword();

		//再次验证用户名是否存在  cn= true /false
		//再次验证两次密码是否一致  repeatPassword() true/false
		if(cn&&rp){
			//表单提交
			$("#registerForm").submit();//等价于标签的submit
			
		}
	}
</script>
</html>