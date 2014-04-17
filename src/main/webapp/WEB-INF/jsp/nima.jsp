<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<style type="text/css">
		*{
			font-family:'Microsoft Yahei','å¾®è½¯éé»';
			margin: 0px;
			padding: 0px;
		}
		#user_attention{
			position: absolute;
		 	margin: 60px;
		 	height: 330px;
		 	width: 320px;
		 	border: 5px solid #ddd;
			padding-top: 10px;
			padding-left: 10px;
			padding-right: 10px;
		 } 
		 dd{
		 	height: 36px;
		 	border-bottom:  1px solid #ddd;

		 }
		 .title{
		 	font-size: 16px;
		 	padding-bottom: 5px;
		 	border-bottom: 1px solid #ddd;
		 	margin-bottom: 6px;
		 	margin-top:3px;
		 	font-weight:bold;
		 }
		 .circle{
			float: left;
		 	height: 0px;
		 	width:0px;
		 	border: 10px solid;
		 	border-radius: 10px;
		 	z-index: 1;
		 	margin-top: 8px;
		 }
		 .border_red{
		 	border-color: #950101;
		 }
		 .border_gray{
		 	border-color: #cecece;
		 }

		 .content{
		 	position: absolute;
		 	z-index: 2;
			margin-top: 7px;

		 }
		 .span1{
		 	font-size: 12px;
		 	color: white;
		 	margin-left: 8px;
		 	font-weight:bold;

		 }
		 .span2{
		 	font-size: 12px;
		 	margin-left: 8px;
		 }
		 .span3{
		 	font-size: 12px;
		 	margin-right: 8px;
		 	color: #8c8c8c;
		 }
	</style>
</head>
<body>
	<div id="user_attention">
		<dl>
			<dt class="title">
				ç¨æ·å³æ³¨æ¦
			</dt>
			<dd>
				<div class="circle border_red"></div>
				<div class="content">
					<span class="span1">1</span>
					<span class="span2">è§£æ¾åä¸­å°:éé±¼å²ç©ºåå¨ä¸­å½æ§å¶èå´</span>
					<span class="span3">1532645</span>
				</div>
			</dd>
			<dd>
				<div class="circle border_red"></div>
				<div class="content">
					<span class="span1">2</span>
					<span class="span2">éæ¸æ´åè¿è¥åä¸¾æ¥åææºä¸åå¾ç­ä¿¡å...</span>
					<span class="span3">1532645</span>
				</div>
			</dd>
			<dd>
				<div class="circle border_red"></div>
				<div class="content">
					<span class="span1">3</span>
					<span class="span2">ç¾åå°é 6åé³éé£æº é²ç©ºå¯¼å¼¹è¿½ä¸ä¸</span>
					<span class="span3">1532645</span>
				</div>
			</dd>
			<dd>
				<div class="circle border_gray"></div>
				<div class="content">
					<span class="span1">4</span>
					<span class="span2">ä¸­å°ï¼ä¸ä¼åªæ´¾åæºå·¡éé±¼å²</span>
					<span class="span3">1532645</span>
				</div>
			</dd>
			<dd>
				<div class="circle border_gray"></div>
				<div class="content">
					<span class="span1">5</span>
					<span class="span2">ä¹ è¿å¹³æ¹è¥¿èå¯æ¶è´« èäººä¸è¯æ»ä¹¦è®°é®...</span>
					<span class="span3">1532645</span>
				</div>
			</dd>
			<dd>
				<div class="circle border_gray"></div>
				<div class="content">
					<span class="span1">6</span>
					<span class="span2">å®åå¸æèä¿æåé­å°æ«è´¥ </span>
					<span class="span3">1532645</span>
				</div>
			</dd>
			<dd>
				<div class="circle border_gray"></div>
				<div class="content">
					<span class="span1">7</span>
					<span class="span2">çé¹°é«ææºåæ¶ææ¬éç¾ä¸å</span>
					<span class="span3">1532645</span>
				</div>
			</dd>
			<dd style="border-bottom: none">
				<div class="circle border_gray"></div>
				<div class="content">
					<span class="span1">8</span>
					<span class="span2">æ±åï¼ä¸­å½ç©ºåé¢è´­ä¼å°78</span>
					<span class="span3">1532645</span>
				</div>
			</dd>
		</dl>	
	</div>
</body>
</html>