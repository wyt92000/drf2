<%@ page pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        //页面加载完毕后
        $(function () {
            //设置点击事件
            $("#btn").click(function () {
                //发送异步请求
                $.get("${pageContext.request.contextPath}/ajax/queryAll",function (msg) {
                    $("#ul1").empty()
                    for(var i=0;i<msg.length;i++){
                        console.log(msg[i]);
                        var user = msg[i];
                        var li1 = $("<li></li>").text(user.id);
                        var li2 = $("<li></li>").text(user.name);
                        var li3 = $("<li></li>").text(user.age);
                        var li4 = $("<li></li>").text(user.birthday);
                        $("#ul1").append(li1).append(li2).append(li3).append(li4);
                    }
                },"JSON")
            })
        })
    </script>
</head>
<body>
    <a href="${pageContext.request.contextPath}/queryOne.jsp">跳转查一个界面</a>
    <input id="btn" type="button" value="查所有">
    <ul id="ul1">

    </ul>
</body>
</html>
