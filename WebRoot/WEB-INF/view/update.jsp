<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>UpdatePage</title>
    <link rel="stylesheet" type="text/css" href="<%=path %>/kuweiCss/index_work.css">
    <script type="text/javascript" src="<%=path %>/My97DatePicker/WdatePicker.js"></script>

  </head>
  
  <body>
  <form action="xk_update" method="post">
  <table>
  	<tr>
  		<td>姓名</td>
  		<td>
  			<input type="hidden" name="stu.id" value="${stu.id }"/>
  			<input name="stu.name" value="${stu.name }"/>
  		</td>
  	</tr>
  	<tr>
  		<td>生日</td>
  		<td>
  			<input name="stu.birthday" onclick="WdatePicker()" value="${stu.birthday }"/>
  		</td>
  	</tr>
  	<tr>
  		<td>密码</td>
  		<td>
  			<input name="stu.password" value="${stu.password }"/>
  		</td>
  	</tr>
  	<tr>
  		<td>课程</td>
  		<td>
  			<c:forEach items="${list }" var="c">
				<input type="checkbox" name="cids" value="${c.cid }" <c:if test="${fn:contains(courseList,c.cid) }">checked</c:if> />${c.cname }
  			</c:forEach>
  		</td>
  		<%-- <td>
  			<c:forEach items="${list }" var="c">
				<input type="checkbox" name="cids" value="${c.cid }"
					<c:forEach items="${stu.courses }" var="course">
						<c:if test="${c.cid==course.cid }">checked</c:if>
					</c:forEach>
				 />${c.cname }
  			</c:forEach>
  		</td> --%>
  	</tr>
  	<tr>
  		<td>班级</td>
  		<td>
  			<select name="bid">
  				<option value="0">请选择</option>
  				<c:forEach items="${classList }" var="c">
  					<option value="${c.bid }" <c:if test="${c.bid==stu.classes.bid }">selected</c:if> >${c.bname }</option>
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
