<%-- 
    Document   : medicos
    Created on : May 4, 2023, 12:08:50 PM
    Author     : larissa.a.da.silva
--%>

<%@page import="com.hospital.model.entities.Medico"%>
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
        <h1>Cadastramento do Médico</h1>
        
        <button class="btn btn-primary" data-bs-toggle="modal"
                data-bs-target="#modalCadastro">Cadastrar um Médico</button><br/>
        <%
            List<Medico> medicos = (List<Medico>) session.getAttribute("medicos");
            if (medicos == null) {
                response.sendRedirect("MedicoServlet");
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
            <tr><th>CRM</th><th>Nome</th><th>Especialidade</th><th>Contato</th>
                <th>Operações</th></tr>
            
            <%
                for (Medico m : medicos) {
                    request.setAttribute("m", m);
            %>
            
            <tr>
                <td>${requestScope.m.crm}</td>
                <td><%= m.getNome()%></td>
                <td><%= m.getEspecialidade()%></td>
                <td><%= m.getContato()%></td>
                <td><a href="MedicoServlet?crm=<%= m.getCrm() %>">detalhar</a>
                    <a href="MedicoServlet?crm=<%= m.getCrm() %>&op=atualizar">atualizar</a>
                    <a href="MedicoServlet?crm=<%= m.getCrm() %>&op=deletar">deletar</a></td>
            </tr><% }%>
        </table>
        
        <tags:carregaMedicos/>
        
        <div class="modal fade" id="modalCadastro" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    
                    <div class="modal-body">
                        <%@include file="cadastroMedico.jsp" %>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
