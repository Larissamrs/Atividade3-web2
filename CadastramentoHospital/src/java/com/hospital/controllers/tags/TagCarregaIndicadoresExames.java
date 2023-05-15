/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.controllers.tags;

import com.hospital.model.entities.Indicador;
import com.hospital.model.repositorios.RepositorioIndicadores;
import java.io.IOException;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author larissa.a.da.silva
 */
public class TagCarregaIndicadoresExames extends SimpleTagSupport{

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag(); //To change body of generated methods, choose Tools | Templates.
    
        List<Indicador> indicadorExame = RepositorioIndicadores.getCurrentInstance()
                .lerTudo();
        
        getJspContext().setAttribute("indicadorExame", indicadorExame, PageContext.PAGE_SCOPE);
        
        getJspContext().getOut().write("<table class=\"table\">");
        getJspContext().getOut().append("<tr><th>Código</th><th>Indicador</th><th>Descrição</th><th>Valor Mínimo de Referência</th><th>Valor Máximo de Referência</th>");
        getJspContext().getOut().append("<th>Operações</th></tr>");
        
        for (Indicador in: indicadorExame ) {
            
            getJspContext().getOut().append(Integer.toString(in.getCodigo()) + "<tr><td>" + "</td>");
            getJspContext().getOut().append("<td>" + in.getIndicador() + "</td>");
            getJspContext().getOut().append("<td>" + in.getDescricao() + "</td>");
            getJspContext().getOut().append("<td>" + Double.toString(in.getMinValorReferencia()) + "</td>");
            getJspContext().getOut().append("<td>" + Double.toString(in.getMaxValorReferencia()) + "</td>");
            getJspContext().getOut().append("<td><a href=\"IndicadorServlet?codigo=" + in.getCodigo() + "\">detalhar</a>&nbsp;");
            getJspContext().getOut().append("<a href=\"IndicadorServlet?codigo=" + in.getCodigo() + "&op=atualizar\">atualizar</a>&nbsp;");
            getJspContext().getOut().append("<a href=\"IndicadorServlet?codigo=" + in.getCodigo() + "&op=deletar\">deletar</a></td></tr>");
        }
        getJspContext().getOut().append("</table>");
    }
    
}

