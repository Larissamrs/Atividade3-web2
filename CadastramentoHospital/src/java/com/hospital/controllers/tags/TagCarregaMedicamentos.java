/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.controllers.tags;

import com.hospital.model.entities.Medicamento;
import com.hospital.model.repositorios.RepositorioMedicamento;
import java.io.IOException;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author larissa.a.da.silva
 */
public class TagCarregaMedicamentos extends SimpleTagSupport{

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag(); //To change body of generated methods, choose Tools | Templates.
    
        List<Medicamento> medicamentos = RepositorioMedicamento.getCurrentInstance()
                .lerTudo();
        
        getJspContext().setAttribute("medicamentos", medicamentos, PageContext.PAGE_SCOPE);
        
        getJspContext().getOut().write("<table class=\"table\">");
        getJspContext().getOut().append("<tr><th>Código</th><th>Nome</th><th>Dosagem</th><th>Tipo de dosagem</th><th>Descrição</th><th>Observação</th>");
        getJspContext().getOut().append("<th>Operações</th></tr>");
        
        for (Medicamento md: medicamentos ) {
            
            getJspContext().getOut().append(Integer.toString(md.getCodigo()) + "<tr><td>" + "</td>");
            getJspContext().getOut().append("<td>" + md.getNome() + "</td>");
            getJspContext().getOut().append("<td>" + md.getDosagem() + "</td>");
            getJspContext().getOut().append("<td>" + md.getTipoDosagem() + "</td>");
            getJspContext().getOut().append("<td>" + md.getDescricao() + "</td>");
            getJspContext().getOut().append("<td>" + md.getObservacao() + "</td>");
            getJspContext().getOut().append("<td><a href=\"MedicamentoServlet?codigo=" + md.getCodigo() + "\">detalhar</a>&nbsp;");
            getJspContext().getOut().append("<a href=\"MedicamentoServlet?codigo=" + md.getCodigo() + "&op=atualizar\">atualizar</a>&nbsp;");
            getJspContext().getOut().append("<a href=\"MedicamentoServlet?codigo=" + md.getCodigo() + "&op=deletar\">deletar</a></td></tr>");
        }
        getJspContext().getOut().append("</table>");
    }
    
}
