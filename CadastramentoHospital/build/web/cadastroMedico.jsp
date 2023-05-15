<%-- 
    Document   : cadastroMedico
    Created on : May 3, 2023, 5:49:29 PM
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
        <h1>${(requestScope.medico eq null)?'Cadastro':'Atualização'} do Médico</h1>
        
        <form method="post" action="MedicoServlet">
            ${(requestScope.medico ne null)?'<input type="hidden" name="crm" value="'.concat(requestScope.medico.crm).concat('"/>'):''}
            ${(requestScope.medico ne null)?'<input type="hidden" name="op" value="atualizar"/>':''}
            <table class="table">
                <tr>
                    <th>
                        Crm: 
                    </th>
                    <td>
                        <input type="text" name="crm" class="form-control"
                               value="${(requestScope.medico ne null)?requestScope.medico.crm:''}"/>
                    </td>
                </tr><tr>
                    <th>
                        Nome: 
                    </th>
                    <td>
                        <input type="text" name="nome" class="form-control"
                               value="${(requestScope.medico ne null)?requestScope.medico.nome:''}"/>
                    </td>
                </tr><tr>
                    <th>
                        Especialidade: 
                    </th>
                    <td>
                        <textarea name="especialidade" class="form-control">${(requestScope.medico ne null)?requestScope.medico.especialidade:''}</textarea>
                    </td>
                </tr><tr>
                    <th>
                        Contato: 
                    </th>
                    <td>
                        <textarea name="contato" class="form-control">${(requestScope.medico ne null)?requestScope.medico.contato:''}</textarea>
                    </td>
                </tr>
                
            </table>
            <button type="submit" class="btn btn-primary">
            ${(requestScope.medico eq null)?'Cadastrar':'Atualizar'}</button>
        </form>
    </body>
</html>
