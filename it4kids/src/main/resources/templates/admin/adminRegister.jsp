[#ftl]
[#import "/spring.ftl" as spring /]
<!DOCTYPE html>
<html>
<head lang="en">

<title>it4kids</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<link
	href="[@spring.url '/css/bootstrap.min.css' /]" rel="stylesheet" media="screen" />

</head>
<body>

	<div class="container" >
		<a href="/"> <img src="[@spring.url '/images/it4kids.png' /]" width="125"/>
		</a>
		
		<form action="/teacher/teacherRegister/register" method="post">
			<h5><a href="/teacher/teacher">Pagina Principala</a></h5>
		<center>
			<table height=300 border="0" width="40%"  cellpadding="5">
				<thead>
					<tr>
						<th colspan="2">Introduceti datele</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Prenume</td>
						<td><input type="text" name="firstName" value=""/></td>
					</tr>
					<tr>
						<td>Nume</td>
						<td><input type="text" name="lastName" value=""/></td>
					</tr>
					<tr>
						<td>Tip de cont</td>
						<td><select name="accountType">
								<option value="PRIMARY_PARENT">Parinte</option>
						</select></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="email" name="email" value=""
							oninvalid="this.setCustomValidity(this.willValidate?'':'Trebuie să introduceti o adresă de email valida')" required="required"/></td>
					</tr>
					<tr>
						<td>Nume Utilizator</td>
						<td><input type="text" name="userName" value="" required="required"/></td>
					</tr>
					<tr>
						<td>Parola</td>
						<td><input type="password" name="password" value="" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Submit" /></td>
						<td><input type="reset" value="Reset" /></td>
						<td><a href="/teacher/pList/">Cancel</a></td>
					</tr>
				</tbody>
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
			</table>
		</center>
	</form>
	</div>

</body>
</html>


