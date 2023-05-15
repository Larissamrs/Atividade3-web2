<%-- 
    Document   : cadastroMedicamento
    Created on : May 4, 2023, 11:50:09 PM
    Author     : larissa.a.da.silva
--%>

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
        <h1>${(requestScope.medicamento eq null)?'Cadastro':'Atualizar'} de Medicamento</h1>
    
        <form method="post" action="MedicamentoServlet">
            ${(requestScope.medicamento ne null)?'<input type="hidden" name="codigo" value="'.concat(requestScope.medicamento.codigo).concat('"/>'):''}
            ${(requestScope.medicamento ne null)?'<input type="hidden" name="op" value="atualizar"/>':''}
        
            <table class="table">
                <tr>
                    ${(requestScope.medicamento ne null)?'<tr><th>Código</th><td>'.concat(requestScope.medicamento.codigo).concat('</td></tr>'):''}
                    <th>
                        Nome:
                    </th>
                    <td>
                        <input type="text" name="nome" class="form-control"
                            value="${(requestScope.medicamento ne null)?requestScope.medicamento.nome:''}"/>
                    </td>
                <tr>
                    <th>
                        Dosagem:
                    </th>
                    <td>
                        <input type="text" name="dosagem" class="form-control"
                               value="${(requestScope.medicamento ne null)?requestScope.medicamento.dosagem:''}"/>                    
                    </td>
                </tr>
                <tr>
                    <th>
                        Tipo de dosagem:
                    </th>
                    <td>
                        <input type="text" name="tipoDosagem" class="form-control"
                               value="${(requestScope.medicamento ne null)?requestScope.medicamento.tipoDosagem:''}"/>
                    </td>     
                </tr>
                <tr>
                    <th>
                        Descrição: 
                    </th>
                    <td>
                        <textarea name="descricao" class="form-control">${(requestScope.medicamento ne null)?requestScope.medicamento.descricao:''}</textarea>
                    </td>
                </tr>
                <tr>
                    <th>
                        Observação:
                    </th>
                    <td>
                        <textarea name="observacao" class="form-control">${(requestScope.medicamento ne null)?requestScope.medicamento.observacao:''}</textarea>
                    </td>     
                </tr>                
            </table>
                    <button type="submit" class="btn btn-primary">
                    ${(requestScope.medicamento eq null)?'Cadastrar':'Atualizar'}</button>
        </form>
    </body>
</html>
