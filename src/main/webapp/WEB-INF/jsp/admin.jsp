<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
  <link rel="stylesheet" href="http://freshzz.corp.qunar.com/collegesearch/prd/css/reset/reset@dev.css" />
    <link rel="stylesheet" type="text/css" href="http://freshzz.corp.qunar.com/collegesearch/prd/css/common/common@dev.css">
  <link rel="stylesheet" type="text/css" href="http://freshzz.corp.qunar.com/collegesearch/prd/css/style@dev.css">
  <link rel="stylesheet" href="http://freshzz.corp.qunar.com/collegesearch/prd/css/admin@dev.css" />
<%--    <link rel="stylesheet" type="text/css" href="http://freshzz.corp.qunar.com/collegesearch/prd/css/page@dev.css">--%>

    <script type="text/javascript"
            src="http://freshzz.corp.qunar.com/collegesearch/prd/scripts/common@dev.js"></script>

  <title>管理员页面</title>
</head>
<body>
  <div class="wrap">

   

        <div class="content_wrap">

      <div class="content" id="content">

        <div id="schoolsss">

          <b>省份</b>
          <select name="province" id="province">
              <option value="">请选择</option>
          <c:forEach  items="${map.province}"  var="province">
          			<option value='${province }' class="item-option">${province}</option>
          </c:forEach>
		 </select>
				


            <b>城市</b>
         <select name="city" id="city">
             <option value="" >请选择</option>

				</select>
			

            <b>学校</b>
           <select name="schoolName" id="schoolName">
               <option value="" >请选择</option>

				</select>
		


          <span id="sosowrap"><input type="text" id="sousuo" placeholder="请输入学校关键字" />
               <span id="soso" /></span>
            </span>
          <input type="button" id="addschool" value="添加学校" />

        </div>

        <table id='table1' class='gridtable'>
            <thead><tr>
                <th>学校名称</th>
                <th>类型</th>
                <th>软件类排名分</th>
                <th>类型排名</th>
                <th>211/985</th>
                <th>学校地址</th>

                <th>微博</th>
                <th>BBS</th>
                <th>操作</th>
            </tr></thead>
            <tbody></tbody>

        </table>

      </div>

      

<div class="pagewrap" >
      <div id="Pagination" class="pagination  schooladmin-page"> </div>
</div>
  </div>

  

  <div class="foot_wrap">
    <label>Copyright © 2013 Qunar.com Inc. All Rights Reserved.</label>
  </div>
      <div id="background"></div>
</div>
  <script>
      var adminpages=${map.schools.pages}
  </script>
  <script type="text/javascript" src="http://freshzz.corp.qunar.com/collegesearch/prd/scripts/index1@dev.js"></script>
  <script type="text/javascript" src="http://freshzz.corp.qunar.com/collegesearch/prd/scripts/admin/schoolmodify@dev.js"></script>
  <script type="text/javascript" src="http://freshzz.corp.qunar.com/collegesearch/prd/scripts/admin/adminpaging@dev.js"></script>
  <script type="text/javascript" src="http://freshzz.corp.qunar.com/collegesearch/prd/scripts/admin/admin@dev.js"></script>
</body>
</html>