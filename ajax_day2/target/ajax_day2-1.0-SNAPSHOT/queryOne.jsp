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

            //通过jQuery形式发送ajax
            $("#btn").click(function () {
                var id = $("#One").val();
                //url   传参   处理响应
                $.get("${pageContext.request.contextPath}/ajax/queryOne","id="+id,function (msg) {
                    //var obj = eval("("+msg+")");
                    var li1 = $("<li></li>").html("id:"+msg.id);
                    var li2 = $("<li></li>").html("id:"+msg.name);
                    var li3 = $("<li></li>").html("id:"+msg.age);
                    var li4 = $("<li></li>").html("id:"+msg.birthday);
                    $("#ul1").empty().append(li1).append(li2).append(li3).append(li4);
                },"JSON")
            })
        })
    </script>
</head>
<body>

        输入id：<input type="text" name="id" value="" id="One">
        <input id="btn" type="button" value="查一个" >

    <ul id="ul1">

    </ul>
</body>
</html>
