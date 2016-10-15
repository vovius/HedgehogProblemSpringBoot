<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/main.js" />"></script>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <label for="loadFile">Select the source file:</label>
    <input type="file" id="loadFile" name="loadFile" onchange="fileLoadChange(this);"/>
</div>
<div>
    <input type="button" id="buttonProcess" name="buttonProcess" onclick="process();" value="Process" disabled />
</div>
<div id="resultPane">
    <label>Initial file:</label><br/>
    <table id="tableFile">
        <tbody/>
    </table>
    <div>
        <label for="inputWalkResult">Walk result:</label>
        <input id="inputWalkResult" name="inputWalkResult" disabled />
    </div>
</div>

</body>
</html>
