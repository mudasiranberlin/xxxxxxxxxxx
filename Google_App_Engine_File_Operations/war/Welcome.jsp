

<%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>


<%
    BlobstoreService bs = BlobstoreServiceFactory.getBlobstoreService();
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

        <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/grayscale.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome-4.2.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
 
       <script type="text/javascript">
    
      function uploadFile() 
      {	
    	if (window.File && window.FileList) 
    	{      
      	var fd = new FormData();
      	var files = document.getElementById('Upload').files;
      	document.getElementById('n').value=files.length;      
      
      	this.uploadTime();
      
      	document.getElementById('formUpload').submit();
      
      } 
      else 
      {
    	this.uploadTime();
    	document.getElementById('formUpload').submit();	
      }	
  }
  function uploadTime()
  {  	  
  	  var nn = new Date().getTime();
      document.getElementById('d').value=nn;      
  }
</script>
<form id="formUpload" enctype="multipart/form-data" method="post" action="<%= bs.createUploadUrl("/insert") %>">
    <center> <p>Select all files to be be Uploaded</p>
      <p><input type="text" name="number" id="n" value="1" hidden="hidden"/></p>
        <p><input type="text" name="date" id="d" value="1" hidden="hidden"/></p>
        <p><input type="file" name="Upload" id="Upload" multiple /></p>
        <p><input type="button" onclick="uploadFile();" style="color : green" value="Upload Files" /></p> </center>
</form>

    
    
    
       <form action="/listfiles" method="post"> 
        <center>    <p> List of all files : </p>
            <input id="submit" type="submit" style="color : green" value="List" ></center>
        </form>
        
             
        <form action="/findfile" method="post">
        <center><p>Find a File : </p> 
            <input type="text" style="color : black" name="Findfile">
            <input id="submit" type="submit" style="color : green" value="Search" ></center>
        </form>
        
        <form action="/displaycontents" method="post"> 
        <center><p>Content Retrieval: </p>
            <input type="text" style="color : black" name="display">
            <input id="submit" type="submit" style="color : green" value="Display Contents" ></center>
        </form>
        
        <form action="/removethefile" method="post"> 
        <center><p>Remove a selected file: </p>
            <input type="text" style="color : black" name="Remove">
            <input id="submit" type="submit" style="color : green" value="Remove the file" ></center>
        </form>

        
        <form action="/removeall" method="post"> 
        <center><p>Remove all files : </p>
            <input id="submit" type="submit" style="color : green" value="Remove All Files" ></center>
        </form>  
</body>
</html>