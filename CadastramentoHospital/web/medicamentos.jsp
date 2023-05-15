<%-- 
    Document   : medicamentos
    Created on : May 4, 2023, 12:05:59 PM
    Author     : larissa.a.da.silva
--%>

<%@page import="com.hospital.model.entities.Medicamento"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="definirtags" uri="com.hospital.tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>        
        
        <title>Sistema de cadastramento do Hospital</title>
    </head>
    <body>
        <h1>Cadastramento de Medicamento</h1>
        
        <button class="btn btn-primary" data-bs-toggle="modal"
                data-bs-target="#modalCadastro">Cadastrar um Medicamento</button><br/>
        <%
            List<Medicamento> medicamentos = (List<Medicamento>) session.getAttribute("medicamentos");
            if (medicamentos == null) {
                response.sendRedirect("medicamentoServlet");
                return;
            }
        %>
        
        <%
            String msg = (String) session.getAttribute("msg");
            
            if (msg != null) {
                
        %>
        
        <h2><%= msg%></h2>
        
        <%
                session.removeAttribute("msg");
            }
        %>
        
        <table class="table">
            <tr><th>Código</th><th>Nome</th><th>Dosagem</th><th>Tipo de dosagem</th><th>Descrição</th><th>Observação</th>
                <th>Operações</th></tr>
            
            <%
                for (Medicamento md : medicamentos) {
                    request.setAttribute("md", md);
            %>
                
            <tr>
                <td>${requestScope.md.codigo}</td>
                <td><%= md.getNome() %></td>
                <td><%= md.getDosagem() %></td>
                <td><%= md.getTipoDosagem() %></td>
                <td><%= md.getDescricao() %></td>
                <td><%= md.getObservacao() %></td>
                <td><a href="MedicamentoServlet?codigo=<%= md.getCodigo() %>">detalhar</a>
                    <a href="MedicamentoServlet?codigo=<%= md.getCodigo() %>&op=atualizar">atualizar</a>
                    <a href="MedicamentoServlet?codigo=<%= md.getCodigo() %>&op=deletar">deletar</a></td>
            </tr><% }%>
        </table>
        
        <tags:carregaMedicamentos/>
        
        <div class="modal fade" id="modalCadastro" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    
                    <div class="modal-body">
                        <%@include file="cadastroMedicamento.jsp" %>
                    </div>

                </div>
            </div>
        </div>
    </body>
</html>