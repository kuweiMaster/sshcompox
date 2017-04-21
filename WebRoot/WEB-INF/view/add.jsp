<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>AddPage</title>
    <link rel="stylesheet" type="text/css" href="<%=path %>/kuweiCss/index_work.css">
    <script type="text/javascript" src="<%=path %>/My97DatePicker/WdatePicker.js"></script>

  </head>
  
  <body>
  <form action="xk_add" method="post">
  <table>
  	<tr>
  		<td>姓名</td>
  		<td>
  			<input name="stu.name"/>
  		</td>
  	</tr>
  	<tr>
  		<td>生日</td>
  		<td>
  			<input name="stu.birthday" onclick="WdatePicker()"/>
  		</td>
  	</tr>
  	<tr>
  		<td>密码</td>
  		<td>
  			<input name="stu.password"/>
  		</td>
  	</tr>
  	<tr>
  		<td>课程</td>
  		<td>
  			<c:forEach items="${list }" var="c">
				<input type="checkbox" name="cids" value="${c.cid }"/>${c.cname }
  			</c:forEach>
  		</td>
  	</tr>
  	<tr>
  		<td>班级</td>
  		<td>
  			<select name="bid">
  				<option value="0">请选择</option>
  				<c:forEach items="${classList }" var="c">
  					<option value="${c.bid }">${c.bname }</option>
	  			</c:forEach>
  			</select>
  		</td>
  	</tr>
  	<tr>
  		<td colspan="10">
  			<input type="submit" value="提交"/>
  		</td>
  	</tr>
  </table>
  </form>
  </body>
</html>
