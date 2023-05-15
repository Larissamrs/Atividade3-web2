package com.hospital.controllers.tags;

import com.hospital.model.entities.Medico;
import com.hospital.model.repositorios.RepositorioMedico;
import java.io.IOException;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author larissa.a.da.silva
 */
public class TagCarregaMedicos extends SimpleTagSupport{

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag(); //To change body of generated methods, choose Tools | Templates.
    
        List<Medico> medicos = RepositorioMedico.getCurrentInstance()
                .lerTudo();
        
        getJspContext().setAttribute("medicos", medicos, PageContext.PAGE_SCOPE);
        
        getJspContext().getOut().write("<table class=\"table\">");
        getJspContext().getOut().append("<tr><th>CRM</th><th>Nome</th><th>Especialidade</th><th>Contato</th>");
        getJspContext().getOut().append("<th>Operações</th></tr>");
        
        for (Medico m: medicos ) {
            
            getJspContext().getOut().append(m.getCrm() + "<tr><td>" + "</td>");
            getJspContext().getOut().append("<td>" + m.getNome() + "</td>");
            getJspContext().getOut().append("<td>" + m.getEspecialidade() + "</td>");
            getJspContext().getOut().append("<td>" + m.getContato() + "</td>");
            getJspContext().getOut().append("<td><a href=\"MedicoServlet?crm=" + m.getCrm() + "\">detalhar</a>&nbsp;");
            getJspContext().getOut().append("<a href=\"MedicoServlet?crm=" + m.getCrm() + "&op=atualizar\">atualizar</a>&nbsp;");
            getJspContext().getOut().append("<a href=\"MedicoServlet?crm=" + m.getCrm() + "&op=deletar\">deletar</a></td></tr>");
        }
        getJspContext().getOut().append("</table>");
    }
    
}
