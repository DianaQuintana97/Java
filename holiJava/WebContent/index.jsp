<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<title>SaludandoVoy</title>
</head>
<body>
	<div class="container mt-5">
		<div class="row">
			<div class="class="col-sm">
				<form action="index.jsp" method="post">
					<div class="form-group">
						<label>Humano escribe tu nombre</label>
						<input type="text" class="form-control" name="nombreH" placeholder="Nombre">
					</div>
					<div class="form-group">
						<label>Humano escribe tu edad</label> 
						<input type="text" class="form-control" name="edadH" placeholder="Edad">
					</div>
					<button type="submit" class="btn btn-primary">Enviar</button>
				</form>
			</div>
		</div>
		<div class="row">
			<div class="class="col-sm">
				<div class="alert alert-primary" role="alert">
					<%
						String nombre = request.getParameter("nombreH");
						String edad = request.getParameter("edadH");
						if(nombre != null && edad != null){
							int edadNum = Integer.parseInt(edad);
							String mensajeE = "";
							if(edadNum >= 1 && edadNum<=18){
								mensajeE="Eres un humano inexperto";
							}else if (edadNum > 18 && edadNum<=30){
								mensajeE="Eres un humano joven e inexperto";
							}else if (edadNum > 30 && edadNum<=100){
								mensajeE="Eres un humano viejon";
							}
							String saludoH = "Hola " + nombre + " a tus " + edad + " años " + mensajeE;
							out.print(saludoH);
						}else{
							out.print("Humano favor de colocar tus datos");
						}
					%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>