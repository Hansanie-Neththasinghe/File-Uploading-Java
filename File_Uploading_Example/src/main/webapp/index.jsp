<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>File Upload Example</h1>
   
    <form action="UploadServlet2" method="post" enctype="multipart/form-data">
	
	<h2 >Insert Your New Song Details</h2>
		name<input type="text" name="name" required><br>
		artistName<input type="text" name="artistName" required><br>
		genre<br><br>
		<select name="genre" id="genre" required>
    		<option value="pop">Pop</option>
    		<option value="jazz">Jazz</option>
    		<option value="love">Love</option>
    		<option value="acoustic">Acoustic</option>
  		</select>
 	 <br><br>
		releasedDate<br><br><input type="date" name="releasedDate" required><br><br>
		lyricist<input type="text" name="lyricist" required><br>
		producer<input type="text" name="producer" required><br>
		lyrics<input type="text" name="lyrics" required><br>
		coverart<br>
		<input type="file" name="file1" required><br>
		songtrack<br>
		<input type="file" name="file2" required><br>
		<br><br>
		<input type="submit" name="submit" value="Upload Song">
	
	</form>
</body>
</html>