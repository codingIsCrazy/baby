<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/commons/taglibs.jsp"%>
<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>worksunny</title>
  <meta name="keywords" content="网址导航,网址保存,网址存储,worksunny,worksunny.com,workSunny,工作,工作方便,提高工作效率,备忘,保存备忘">
  <meta name="description" content="给工作带来方便，存储工作中常用的网站，方便存网址，备忘，方便存备忘，提高工作效率，worksunny,worksunny.com">
  <meta name="author" content="liujianjun">
  <link rel="shortcut icon" href="/favicon.ico">
  <link rel="stylesheet" href="${path }/ws/css/index.css">
  <script>
    var _hmt = _hmt || [];
    (function() {
      var hm = document.createElement("script");
      hm.src = "//hm.baidu.com/hm.js?6f5729733d3b10f953991ed9b94fda16";
      var s = document.getElementsByTagName("script")[0];
      s.parentNode.insertBefore(hm, s);
    })();
  </script>
</head>
<body>
<div id="popup-overlay"></div>
<div id="popup-login" class="popup">
  <h2>登录</h2>
      <div style="margin-top:10px;"><font class="input_error"  id="login-error"></font></div>
      <div style="margin-top:30px;">
        <label for="login-username">邮箱:</label>
        <input type="text" name="" id="login-username" class="pop_input">
        <div style="margin-top:5px;"><font class="input_error"  id="login-username-error"></font></div>
      </div>
      <div style="margin-top:25px;">
        <label for="login-password">密码:</label>
        <input type="password" name="" id="login-password" class="pop_input" onkeypress="loginEnterPress(event)">
        <div style="margin-top:5px;"><font class="input_error"  id="login-password-error"></font></div>
      </div>
    <button class="pop_button" onclick="login();">登录</button>
    <a class="close" href="#"></a>
</div>

<div class="popup" id="popup-register">
  <h2>注册</h2>
    <div style="margin-top:30px;">
      <label for="login-username">邮箱:</label>
      <input type="text" name="" id="register-username" class="pop_input">
      <div style="margin-top:5px;"><font class="input_error"  id="register-username-error"></font></div>
    </div>
    <div style="margin-top:20px;">
      <label for="login-password">密码:</label>
      <input type="password" name="" id="register-password" class="pop_input">
      <div style="margin-top:5px;"><font class="input_error"  id="register-password-error"></font></div>
    </div>
    <div style="margin-top:20px;">
      <label for="login-password">性别:</label>
      
      <input type="radio" name="sex" checked="checked" value="1"/>男  <input type="radio" name="sex" value="2"/>女
    </div>
    <div style="margin-top:20px;">
      <label for="login-password">职业:</label>
      <select style="margin-left:8px;line-height:25px;width:130px;border:2px;height:30px;" id="job">
        <option value="1"/>技术</option>
        <option value="2"/>运营</option>
        <option value="3"/>销售</option>
        <option value="4"/>策划</option>
        <option value="5"/>财务</option>
        <option value="6"/>人力资源</option>
        <option value="7"/>其它</option>
      </select>
    </div>
  <button class="pop_button" onclick="register();">提交</button>
  <a class="close" href="#"></a>
</div>

<div id="head_bar" style="height:40px;line-height:0px;width:1000px;margin:0 auto;">
		<ul id="login_bar">
	    <!--  <li><a  href="#" onclick="AddFavorite(window.location,document.title)"> 收藏本站 </a></li>
	    <li><a href="#" onclick="SetHome(this,window.location)" > 设为首页 </a></li>-->
	    		<li><a href="#" id="register-btn" onclick="rigistShow();">注册</a></li>
			<li><a href="#" id="login-btn" onclick="loginShow();">登录</a></li>
			<!--  <li><img alt="" src="${path }/ws/images/Sun.png" style="width:30px;height:30px;" id="imageSun"><li>-->
		</ul>
</div>
<div style="border-top:1px solid #f60;width:100%;height:0px;">
	
</div>
<!--  <hr class="head_hr">-->
  
<div id="logo">
	<img src="${path }/ws/images/worksunny3.png" />
</div>

<div id="search" class="clearfix">
    <div class="search">
      	<select name="classid" id="choose">
          <option value="1">bing</option>
          <option value="2">谷歌</option>
          <option value="3" selected="selected">百度</option>
      	</select>
    </div>
    <div id="baiduSearch" >
  		<form action="http://www.baidu.com/baidu" target="_blank" class="baidu_form">
  			<input name="tn" type="hidden" value="SE_zzsearchcode_shhzc78w" >
  			<input type="text"  name="word" size="30" baiduSug="1" class="search_input">
  			<button type="submit"  class="search_btn">百度</button>
  		</form>
  	</div>
  	<div id="otherSearch">
  		<input type="text" name="word" id="word" onkeypress="EnterPress(event)" class="search_input"/>
  		<button  id="otherSearchVal" onclick="search()" class="search_btn"></button>
  	</div>
</div>

<div id="addRecordSite" class="popup">
  <a class="close" href="#"></a>
  <h2>网址</h2>
      <div style="margin-top:5px;"><font class="input_error"  id="webSite-error"></font></div>
      <div style="margin-top:30px;">
        <label for="login-username">标题:</label>
        <input type="text" name="" id="weisiteTitle" class="pop_input">
        <div style="margin-top:5px;"><font class="input_error"  id="webSite-title-error"></font></div>
      </div>
      <div style="margin-top:25px;">
        <label for="login-password">网址:</label>
        <input type="text" name="" id="weisiteUrl" class="pop_input" onkeypress="webSiteEnterPress(event)">
        <div style="margin-top:5px;"><font class="input_error"  id="webSite-content-error"></font></div>
    </div>
    <input type="hidden" id="webSiteType" />
    <button class="pop_button" onclick="addWebSiteUrl();">提交</button>

</div>

<div id="addRecord" class="popup">
  <h2>备忘</h2>
      <div style="margin-top:5px;"><font class="input_error"  id="remark-error"></font></div>
      <div style="margin-top:30px;">
        <label for="">标题:</label>
        <input type="text" name="" id="remarkTitle" style="margin-left:8px;line-height:25px;width:390px;">
        <div style="margin-top:5px;"><font class="input_error"  id="remarkTitle-error"></font></div>
      </div>
      <div style="margin-top:25px;">
        <label for="login-password">内容:</label>
        <textarea name="" id="remarkContent" style="margin-left:8px;width:390px;height:223px;" onkeypress="recordEnterPress(event)"></textarea>
        <div style="margin-top:5px;"><font class="input_error"  id="remarkContent-error"></font></div>
      </div>
      <input type="hidden" id="recordType" />
      <input type="hidden" id="recordId" />
    <button class="pop_button" onclick="addWebRecord();">提交</button>
    <a class="close" href="#"></a>
</div>

<div class="record clearfix">
  <div class="record_classify">
    <ul id="record_type">
        <li><img src="${path }/ws/images/add.png" class="add_image" onclick="addRecord(1);"/><a href="#" value="1" style="color:#f60;">工作</a></li>
        <li><img src="${path }/ws/images/add.png" class="add_image" onclick="addRecord(2);"/><a href="#" value="2">娱乐</a></li>
        <li><img src="${path }/ws/images/add.png" class="add_image" onclick="addRecord(3);"/><a href="#" value="3">收藏</a></li>
        <li><img src="${path }/ws/images/add.png" class="add_image" onclick="addRecord(4);"/><a href="#" value="4">备忘</a></li>
    </ul>
  </div>
  <div class="div_line"></div>
  <div class="record_list clearfix" id="record_list_val">
       <ul id="record_val">

       </ul>
  </div>
</div>


</body>
<script charset="gbk" src="http://www.baidu.com/js/opensug.js"></script>
<script type="text/javascript" src="${path }/ws/js/libs/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${path }/ws/js/jquery.select.js"></script>
<script src="${path }/ws/js/index.js"></script>

</html>
