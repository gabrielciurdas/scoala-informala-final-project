[#ftl]
[#import "/spring.ftl" as spring /]
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Admin</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
<a href="/"> <img src="[@spring.url '/images/it4kids.png' /]" width="125"/>
		</a>
  <ul class="nav nav-pills">
    <li class="active"><a data-toggle="tab" href="#home">Pagina Principala</a></li>
    <li><a data-toggle="tab" href="#child">Copii</a></li>
     <li><a data-toggle="pill" href="#account">Cont</a></li>
  </ul>

  <div class="tab-content">
  
    <div id="home" class="tab-pane fade in active">
    <br>
      <p> Bine ai venit, ${currentUser.userName}!</p>
       <br>
      <p> <a href="/logout">Delogare</a> <p>
    </div>
    
   <div id="child" class="tab-pane fade">
      <h3>Copii    </h3>
   		<br>
		<p> <a href="/primary_parent/cList">Vezi lista</a> <p>
    </div>
    
    <div id="account" class="tab-pane fade">
       <h3>Cont    </h3>
       <br>
				<a href="/primary_parent/register">Inregistreaza parinti sau copii</a><br><br>
				<a href="/primary_parent/assign">Asigneaza un parinte</a><br><br>
				<a href="/primary_parent/account">Detalii cont</a><br><br>
    </div>
    
    </div>
  </div>
</div>

</body>
</html>


