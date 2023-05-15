<%-- 
    Document   : cadastroIndicadorExame
    Created on : May 3, 2023, 11:48:22 PM
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
        <h1>${(requestScope.indicadorExame eq null)?'Cadastro':'Atualização'} de Indicador de Exame</h1>
        <form method="post" action="IndicadorServlet">
            ${(requestScope.indicadorExame ne null)?'<input type="hidden" name="codigo" value="'.concat(requestScope.indicadorExame.codigo).concat('"/>'):''}
            ${(requestScope.indicadorExame ne null)?'<input type="hidden" name="op" value="atualizar"/>':''}
            <table class="table">
                <tr>
                    ${(requestScope.indicadorExame ne null)?'<tr><th>Código</th><td>'.concat(requestScope.indicadorExame.codigo).concat('</td></tr>'):''}
                    <th>
                        Indicador:
                    </th>
                    <td>
                        <input type="text" name="indicador" class="form-control"
                               value="${(requestScope.indicadorExame ne null)?requestScope.indicadorExame.indicador:''}"/>                        
                    </td>
                </tr>
                <tr>
                    <th>
                        Descrição:
                    </th>
                    <td>
                        <textarea name="descricao" class="form-control">${(requestScope.indicadorExame ne null)?requestScope.indicadorExame.descricao:''}</textarea>                        
                    </td>
                </tr>
                <tr>
                    <th>
                        Valor Mínimo de Referência:
                    </th>
                    <td>
                        <input type="text" name="minValorReferencia" class="form-control"
                               value="${(requestScope.indicadorExame ne null)?requestScope.indicadorExame.minValorReferencia:''}"/>                        
                    </td>
                </tr>                
                <tr>
                    <th>
                        Valor Máximo de Referência:
                    </th>
                    <td>
                        <input type="text" name="maxValorReferencia" class="form-control"
                               value="${(requestScope.indicadorExame ne null)?requestScope.indicadorExame.maxValorReferencia:''}"/>                        
                    </td>
                </tr>                  
            </table>
            <button type="submit" class="btn btn-primary">
            ${(requestScope.indicadorExame eq null)?'Cadastrar':'Atualizar'}</button>                    
        </form>
    </body>
</html>
