<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${path}/js/jquery-1.11.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=">
<title>Portal</title>
<script type="text/javascript">
function naaruLight(){
	var rootName = $("#rootName").val();
	var artifactId = $("#artifactId").val();

	var target = "naaruLight.htm";
	var parameters = "rootName="+rootName+"&artifactId="+artifactId;

	$.ajax({
		type: "POST",
		url: target,
		data: parameters,
		async: true,
		success: function(msg){
			var json = eval('(' + msg + ')');
			$("#mybatisXmlPath").val(json.mybatisXmlPath);
			$("#mybatisClassPath").val(json.mybatisClassPath);
			$("#mybatisClassPackageName").val(json.mybatisClassPackageName);

			$("#modelPath").val(json.modelPath);
			$("#modelPackageName").val(json.modelPackageName);

			$("#daoPath").val(json.daoPath);
			$("#daoImplPath").val(json.daoImplPath);
			$("#servicePath").val(json.servicePath);
			$("#serviceImplPath").val(json.serviceImplPath);

			$("#controllerPath").val(json.controllerPath);
		}
	});
}

</script>
<body>
<table border=0>
<form method="post" id="fm" action="activate.htm">
<tr>
	<td>RootName: </td>
	<td>
		<input id="rootName" name="rootName" value="alliance"/>
	</td>
</tr>
<tr>
	<td>ArtifactId: </td>
	<td>
		<input id="artifactId" name="artifactId" value="alliance-portal"/>
		<input type="button" onclick="naaruLight()" value="Naaru Light" />
	</td>
</tr>
<tr>
	<td>MappXML Path: </td>
	<td><input id="mybatisXmlPath" name="mybatisXmlPath" style="width:1000px" /></td>
</tr>
<tr>
	<td>MappClass Path: </td>
	<td><input id="mybatisClassPath" name="mybatisClassPath" style="width:1000px" /></td>
</tr>
<tr>
	<td>MybatisClass PackageName: </td>
	<td><input id="mybatisClassPackageName" name="mybatisClassPackageName" style="width:1000px" /></td>
</tr>

<tr>
	<td>ModelPath: </td>
	<td><input id="modelPath" name="modelPath" style="width:1000px" /></td>
</tr>
<tr>
	<td>ModelPackageName: </td>
	<td><input id="modelPackageName" name="modelPackageName" style="width:1000px" /></td>
</tr>

<tr>
	<td>Dao Path: </td>
	<td><input id="daoPath" name="daoPath" style="width:1000px" /></td>
</tr>
<tr>
	<td>DaoImpl Path: </td>
	<td><input id="daoImplPath" name="daoImplPath"  style="width:1000px" /></td>
</tr>
<tr>
	<td>Service Path: </td>
	<td><input id="servicePath" name="servicePath" style="width:1000px" /></td>
</tr>
<tr>
	<td>ServiceImpl Path: </td>
	<td><input id="serviceImplPath" name="serviceImplPath" style="width:1000px" /></td>
</tr>

<tr>
	<td>Controller Path: </td>
	<td><input id="controllerPath" name="controllerPath" style="width:1000px" /></td>
</tr>




<tr>
	<td>Choose Template:</td>
	<td>
	    <input type="checkbox" value="model">model
		<input type="checkbox" value="mapperXml">mapperXml
		<input type="checkbox" value="mapperClass">mapperClass
		<input type="checkbox" value="dao">dao
		<input type="checkbox" value="daoImpl">daoImpl
		<input type="checkbox" value="service">service
		<input type="checkbox" value="serviceImpl">serviceImpl
		<input type="checkbox" value="controllerClass">controllerClass
	</td>
</tr>

<tr>
	<td>Operation:</td>
	<td>
	 <input type="submit" value="Activate" />
	</td>
</tr>

</table>
</form>
</body>
</html>