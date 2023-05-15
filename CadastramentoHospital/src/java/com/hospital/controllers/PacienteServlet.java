/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.controllers;

import com.hospital.model.entities.Paciente;
import com.hospital.model.repositorios.RepositorioPaciente;
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
@WebServlet(name = "PacienteServlet", urlPatterns = {"/PacienteServlet"})
public class PacienteServlet extends HttpServlet {

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

        String cpf = request.getParameter("cpf");
        String operacao = request.getParameter("op");
        if (cpf != null) {
            if (operacao != null && operacao.equals("deletar")) {
                
                RepositorioPaciente.getCurrentInstance().deletar(cpf);
                
                request.getSession().setAttribute("msg", "Paciente removido com sucesso!");
                
                response.sendRedirect("pacientes.jsp");
                
                return;
            }            
            Paciente p = RepositorioPaciente.getCurrentInstance()
                    .ler(cpf);
        
            request.setAttribute("paciente", p);
        
            if (operacao != null && operacao.equals("atualizar")) {
                getServletContext().getRequestDispatcher("/cadastroPaciente.jsp")
                        .forward(request, response);
            }
            else {
                getServletContext().getRequestDispatcher("/detalharPaciente.jsp")
                        .forward(request, response);
            }
        
            return;            
        }

        List<Paciente> pacientes = RepositorioPaciente.getCurrentInstance().lerTudo();
        
        request.getSession().setAttribute("pacientes", pacientes);
        
        response.sendRedirect("pacientes.jsp");
        
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
        
        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String contato = request.getParameter("contato");
        String planoSaude = request.getParameter("planoSaude");
        
        Paciente p = new Paciente();
        
        p.setCpf(cpf);
        p.setNome(nome);
        p.setEndereco(endereco);
        p.setContato(contato);
        p.setPlanoSaude(planoSaude);
        
        HttpSession session = request.getSession();
        
        if (operacao == null) {
            RepositorioPaciente.getCurrentInstance().inserir(p);
            session.setAttribute("msg", "Paciente cadastrado com sucesso!");
        }
        else {
            RepositorioPaciente.getCurrentInstance().alterar(p);
            session.setAttribute("msg", "Paciente alterado com sucesso!");
        }
        
        response.sendRedirect("PacienteServlet");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

