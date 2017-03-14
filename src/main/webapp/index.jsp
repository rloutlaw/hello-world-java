<%@ page import="java.util.Date" %>
<%--
  Copyright (c) Microsoft Corporation. All rights reserved.
  Licensed under the MIT License. See License.txt in the project root for
  license information.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Azure Samples Hello World</title>
</head>
<body>
  <H1>Hello from Microsoft Azure!</H1>
<div>
  Current time: <%= new Date() %>
</div>
<div><h2>Upload a file to show or display an image:</h2>
<form method="POST" action="upload" enctype="multipart/form-data">
<input type="file" name="file"/><br/>
 <input type="submit" value="Upload to Azure Storage" name="upload"></h3></form>
</div>
<img src="https://rlosamplestorage.blob.core.windows.net/helloworld/helloworld.jpg">
</body>
</html>
