<%-- 
    Document   : detalharMedicamento
    Created on : May 4, 2023, 11:55:09 PM
    Author     : larissa.a.da.silva
--%>

<%@page import="com.hospital.model.entities.Medicamento"%>
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
        <h1>Medicamentos Cadastrados</h1>
        <a href="MedicamentoServlet">Medicamentos Cadastrados</a><br/>
        
        <table class="table">
            <tr>
                <th>Código</th>
                <td>${requestScope.medicamento.codigo}</td>
            </tr>
            <tr>
                <th>Nome</th>
                <td>${requestScope.medicamento.nome}</td>
            </tr>      
            <tr>
                <th>Dosagem</th>
                <td>${requestScope.medicamento.dosagem}</td>
            </tr>     
            <tr>
                <th>Tipo de dosagem</th>
                <td>${requestScope.medicamento.tipoDosagem}</td>
            </tr>     
            <tr>
                <th>Descrição</th>
                <td>${requestScope.medicamento.descricao}</td>
            </tr>
            <tr>
                <th>Observacao</th>
                <td>${requestScope.medicamento.observacao}</td>
            </tr>               
        </table>
    </body>
</html>
