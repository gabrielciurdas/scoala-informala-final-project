[#ftl]
[#import "/spring.ftl" as spring /]
<head>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Lista invatatorilor</title>
    <link  href="[@spring.url '/css/bootstrap.min.css' /]" rel="stylesheet">
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="[@spring.url '/js/bootstrap.min.js' /] "></script>
	
	<script>
	function goToAccount() {
		window.location.href = '/parent/account';
	}
	
	</script>
</head>
[#escape x as x?html]


<div class="container">
			<a href="/"> <img src="[@spring.url '/images/it4kids.png' /]" width="125"/>
		</a>


		<ol class="breadcrumb">
			<li><a href="/parent/parent">Pagina Principala</a></li>
		</ol>

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Invatator</h3>
			</div>

			<div class="panel-body">
			
			    [#if errors??]
				    <div>
				        <ul>
				            [#list errors as error]
				            <br>
				                <b style="color:red">
				                [#if error.field??]${error.field}: [/#if]${error.defaultMessage}
				                </b>
				            [/#list]
				        </ul>
				    </div>
				[/#if]
			    
		<form action="/parent/save" method="post">
		<input type="hidden" name="id" value="[#if user.id??]${user.id?c}[/#if]">
					<div class="form-group">
						<label for="firstName">Prenume</label> 
						<input type="text"
							class="form-control" id="firstName" name="firstName"
							placeHolder="Prenume" value="${user.firstName}"/>
					</div>
					<div class="form-group">
						<label for="lastName">Nume</label> 
						<input type="text"
							class="form-control" id="lastName" name="lastName"
							placeHolder="Nume" value="${user.lastName}"/>
					</div>


					<div class="form-group">
						 <label for="accountType">Tip de cont:</label>
      						<select class="form-control" id="accountType" name="accountType"  disabled>
       							 <option value="PARENT" selected>Parinte</option>
					      </select>
					</div>

					<div class="form-group">
						<label for="email">Adresa de email</label> 
						<input type="email"
							class="form-control" id="email" name="email"
							placeHolder="Adresa de email" value="${user.email}" />
					</div>
					
					<div class="form-group">
						<label for="userName">Nume de utilizator</label> 
						<input type="text"
							class="form-control" id="userName" name="userName"
							placeHolder="Nume de utilizator" value="${user.userName}"  disabled/>
					</div>
					
					<div class="form-group">
						<label for="password">Parola</label> 
						<input type="password"
							class="form-control" id="password" name="password"
							placeHolder="Parola" value="${user.password}"  disabled/>
					</div>


					<div class="container-fluid">
						<div class="collapse navbar-collapse">
							<ul class="nav navbar-nav navbar-right">
								<li><button type="submit" class="btn btn-danger" 
								onclick="javascript:goToAccount();return false">Anuleaza</button></li>
								<li>&nbsp;&nbsp;&nbsp;</li>
								<li><button type="submit" class="btn btn-success">Salveaza</button></li>
							</ul>
						</div>
					</div>
			</form>
			</div>
		</div>
	</div>

[/#escape]