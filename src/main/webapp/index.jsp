<html>
<body>
<h2>Book Manager</h2>
<h1>CREATE BOOK</h1>
<form action="/create" method="POST">
    <input type="text" name="isbn" placeholder="ISBN"/><br/>
    <input type="text" name="name" placeholder="Name"/><br/>
    <input type="text" name="author" placeholder="Author"/><br/>
    <input type="submit" value="Save"/>
</form>
<br>
<h1>UPDATE BOOK</h1>
<form action="/update" method="POST">
    <input type="text" name="id" placeholder="BookID"><br/>
    <input type="text" name="isbn" placeholder="ISBN"/><br/>
    <input type="text" name="name" placeholder="Name"/><br/>
    <input type="text" name="author" placeholder="Author"/><br/>
    <input type="submit" value="Save"/>
</form>
<br>
<h1>FIND BOOK BY ID</h1>
<form action="/read" method="GET">
    <input type="number" name="id" placeholder="BookID"/><br/>
    <input type="submit" value="Get"/>
</form>
<h1>DELETE BOOK BY ID</h1>
<form action="/delete" method="GET">
    <input type="number" name="id" placeholder="BookID"/><br/>
    <input type="submit" value="Delete"/>
</form>

</body>
</html>