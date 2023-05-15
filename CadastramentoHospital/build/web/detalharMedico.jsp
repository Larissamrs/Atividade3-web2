<%-- 
    Document   : detalharMedico
    Created on : May 3, 2023, 11:57:27 PM
    Author     : larissa.a.da.silva
--%>

<%@page import="com.hospital.model.entities.Medico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>        
        
        <title>Sistema de cadastramento do Hospital</title>
    </head>
    <body>
        <h1>Médicos Cadastrados</h1>
        <a href="MedicoServlet">Médicos Cadastrados</a><br/>
        
        <table class="table">
            <tr>
                <th>CRM</th>
                <td>${requestScope.medico.crm}</td>
            </tr>
            <tr>
                <th>Nome</th>
                <td>${requestScope.medico.nome}</td>
            </tr>        
            <tr>
                <th>Especialidade</th>
                <td>${requestScope.medico.especialidade}</td>
            </tr>      
            <tr>
                <th>Contato</th>
                <td>${requestScope.medico.contato}</td>
            </tr>            
        </table>
    </body>
</html>