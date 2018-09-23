<html>
<body>
<h2>Book Manager</h2>
<form action="/write" method="POST">
  <input type="text" name="isbn" placeholder="ISBN" /><br />
  <input type="text" name="name" placeholder="Name" /><br />
  <input type="text" name="author" placeholder="Author" /><br />
  <input type="submit" value="Save" />
</form>
<form action="/read" method="GET">
  <input type="number" name="id" placeholder="BookID" /><br />
  <input type="submit" value="Get" />
</form>
</body>
</html>