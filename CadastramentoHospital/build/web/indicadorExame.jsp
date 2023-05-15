<%-- 
    Document   : indicadorExame
    Created on : May 3, 2023, 12:04:21 AM
    Author     : larissa.a.da.silva
--%>

<%@page import="com.hospital.model.entities.Indicador"%>
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
    
        <h1>Indicadores Exames</h1>
        
        <button class="btn btn-primary" data-bs-toggle="modal"
                data-bs-target="#modalCadastro">Cadastrar um Indicador de Exame</button><br/>
        <%
            List<Indicador> indicadorExame = (List<Indicador>) session.getAttribute("indicadorExame");
            if (indicadorExame == null) {
                response.sendRedirect("IndicadorServlet");
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
            <tr><th>Código</th><th>Indicador</th><th>Descrição</th><th>Valor Mínimo de Referência</th><th>Valor Máximo de Referência</th>
            <th>Operações</th></tr>
                
            <%
                for (Indicador in : indicadorExame) {
                    request.setAttribute("in", in);
            %>
            
            <tr>
                <td>${requestScope.in.codigo}</td>
                <td><%= in.getIndicador()%></td>
                <td><%= in.getDescricao()%></td>
                <td><%= in.getMinValorReferencia()%></td>
                <td><%= in.getMaxValorReferencia()%></td>
                <td><a href="IndicadorServlet?codigo=<%= in.getCodigo() %>">detalhar</a>
                    <a href="IndicadorServlet?codigo=<%= in.getCodigo() %>&op=atualizar">atualizar</a>
                    <a href="IndicadorServlet?codigo=<%= in.getCodigo() %>&op=deletar">deletar</a></td>
            </tr>
            
            <% }%>
        </table>
        
        <tags:carregaIndicadoresExame/>
        
        <div class="modal fade" id="modalCadastro" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hibben="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    
                    <div class="modal-body">
                        <%@include file="cadastroIndicadorExame.jsp" %>
                    </div>
                </div>
                
            </div>
        </div>
                    
    
</html>
