package com.hospital.controllers.tags;

import com.hospital.model.entities.Paciente;
import com.hospital.model.repositorios.RepositorioPaciente;
import java.io.IOException;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author larissa.a.da.silva
 */
public class TagCarregaPacientes extends SimpleTagSupport{

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag(); //To change body of generated methods, choose Tools | Templates.
    
        List<Paciente> pacientes = RepositorioPaciente.getCurrentInstance()
                .lerTudo();
        
        getJspContext().setAttribute("pacientes", pacientes, PageContext.PAGE_SCOPE);
        
        getJspContext().getOut().write("<table class=\"table\">");
        getJspContext().getOut().append("<tr><th>CPF</th><th>Nome</th><th>Endereço</th><th>Contato</th><th>Plano de Saúde</th>");
        getJspContext().getOut().append("<th>Operações</th></tr>");
        
        for (Paciente p: pacientes ) {
            
            getJspContext().getOut().append(p.getCpf() + "<tr><td>" + "</td>");
            getJspContext().getOut().append("<td>" + p.getNome() + "</td>");
            getJspContext().getOut().append("<td>" + p.getEndereco() + "</td>");
            getJspContext().getOut().append("<td>" + p.getContato() + "</td>");
            getJspContext().getOut().append("<td>" + p.getPlanoSaude() + "</td>");
            getJspContext().getOut().append("<td><a href=\"PacienteServlet?cpf=" + p.getCpf() + "\">detalhar</a>&nbsp;");
            getJspContext().getOut().append("<a href=\"PacienteServlet?cpf=" + p.getCpf() + "&op=atualizar\">atualizar</a>&nbsp;");
            getJspContext().getOut().append("<a href=\"PacienteServlet?cpf=" + p.getCpf() + "&op=deletar\">deletar</a></td></tr>");
        }
        getJspContext().getOut().append("</table>");
    }
    
}