<%--
  Created by IntelliJ IDEA.
  User: AlanLee
  Date: 2019/8/10
  Time: 7:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取并保存属性参数</title>
</head>
<body>

<!--RequestAttribute-->

<%
    //设置请求参数
    request.setAttribute("id", 1);
    //转发给控制器
    request.getRequestDispatcher("./attr/reqAttr.do").forward(request,response);

    out.clear();      //清空缓存的内容
    out=pageContext.pushBody();  //更新PageContext的out属性的内容

%>
</body>
</html>
