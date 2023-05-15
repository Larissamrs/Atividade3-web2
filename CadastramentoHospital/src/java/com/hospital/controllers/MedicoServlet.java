/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.controllers;

import com.hospital.model.entities.Medico;
import com.hospital.model.repositorios.RepositorioMedico;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author larissa.a.da.silva
 */
@WebServlet(name = "MedicoServlet", urlPatterns = {"/MedicoServlet"})
public class MedicoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String crm = request.getParameter("crm");
        String operacao = request.getParameter("op");
        
        if (crm != null) {
            if (operacao != null && operacao.equals("deletar")) {
                
                RepositorioMedico.getCurrentInstance().deletar(crm);
                
                request.getSession().setAttribute("msg", "Médico removido com sucesso!");
                
                response.sendRedirect("medicos.jsp");
                
                return;
            }
            
            Medico m = RepositorioMedico.getCurrentInstance()
                    .ler(crm);
            
            request.setAttribute("medico", m);
            
            if(operacao != null && operacao.equals("atualizar")){
                getServletContext().getRequestDispatcher("/cadastroMedico.jsp")
                        .forward(request, response);
            }
            else {
                getServletContext().getRequestDispatcher("/detalharMedico.jsp")
                        .forward(request, response);
            }
            
            return;
        }
        
        List<Medico> medicos = RepositorioMedico.getCurrentInstance().lerTudo();
        
        request.getSession().setAttribute("medicos", medicos);
        
        response.sendRedirect("medicos.jsp");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String operacao = request.getParameter("op");
        
        String crm = request.getParameter("crm");
        String nome = request.getParameter("nome");
        String especialidade = request.getParameter("especialidade");
        String contato = request.getParameter("contato");
        
        Medico m = new Medico();
        
        m.setCrm(crm);
        m.setNome(nome);
        m.setEspecialidade(especialidade);
        m.setContato(contato);
        
        HttpSession session = request.getSession();
        
        if (operacao == null) {
            RepositorioMedico.getCurrentInstance().inserir(m);
            session.setAttribute("msg", "Médico cadastrado com sucesso!");
        }
        else  {
            RepositorioMedico.getCurrentInstance().alterar(m);
            session.setAttribute("msg", "Médico Alterado com sucesso!");
        }
        
        response.sendRedirect("MedicoServlet");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}