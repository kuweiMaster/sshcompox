<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>ListPage</title>
    <link rel="stylesheet" type="text/css" href="<%=path %>/kuweiCss/index_work.css">
<SCRIPT type="text/javascript">
  		function fenye(page){
  			document.getElementById("page").value = page;
  			document.forms[0].submit();
  		}
</SCRIPT>
  </head>
  
  <body>
	<form action="xk_list" method="post">
	  <input type="hidden" id="page" name="currentPage"/>
	      按姓名查询：<input type="text" name="mohu" value="${mohu}"/>
	  <input type="submit" value="查询"/>
	</form>
  <table>
  	<tr>
  		<td></td>
  		<td>编号</td>
  		<td>姓名</td>
  		<td>生日</td>
  		<td>密码</td>
  		<td>课程</td>
  		<td>课程数</td>
  		<td>课程学时</td>
  		<td>班级</td>
  		<td>
  			操作【<a href="<%=path%>/xk_toAdd">添加</a>】
  		</td>
  	</tr>
	<c:set var="n" value="0"></c:set>				<!-- 学时超过10统计 -->
  	<c:forEach items="${list }" var="s" varStatus="a">
  		<tr>
	  		<td></td>
	  		<td>${a.index+1 }</td>
	  		<td>${s.name }</td>
	  		<td>${s.birthday }</td>
	  		<td>${s.password }</td>
	  		<td>
	  			<c:set var="num" value="0"></c:set>				<!-- 课程数 -->
	  			<c:set var="totalptime" value="0"></c:set>		<!-- 学时总数 -->
	  			<c:forEach items="${s.courses }" var="c">
	  				${c.cname }&nbsp;
	  				<c:set var="num" value="${num+1 }"></c:set>
	  				<c:set var="totalptime" value="${totalptime+c.ptime }"></c:set>
	  			</c:forEach>
		  		<c:if test="${totalptime>=10 }">
					<c:set var="n" value="${n+1 }"></c:set>
				</c:if>
	  		</td>
	  		<td>${num }</td>
	  		<td>${totalptime }</td>
	  		<td>${s.classes.bname }</td>
	  		<td>
  				【<a href="<%=path%>/xk_toUpdate?stu.id=${s.id}">选课</a>】
  				【<a href="<%=path%>/xk_deleteStu?stu.id=${s.id}">删除</a>】
  			</td>
	  	</tr>
  	</c:forEach>
  		<tr>
	  		<td colspan="10">
	  			本页有【${n }名学生】课时达到10学时
	  		</td>
	  	</tr>
  </table>
  <table>
    <tr>
    	<td >
    	第${page.currentPage}/${page.pageCount}页
  			<a onclick="fenye(1)">首页</a>
  			<a onclick="fenye(${page.previousPage})">上一页</a>
  			<a onclick="fenye(${page.nextPage})">下一页</a>
  			<a onclick="fenye(${page.pageCount})">尾页</a>
	</td>
    </tr>
</table>
  </body>
</html>
