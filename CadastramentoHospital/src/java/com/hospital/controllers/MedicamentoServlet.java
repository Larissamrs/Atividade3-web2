/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.controllers;

import com.hospital.model.entities.Medicamento;
import com.hospital.model.repositorios.RepositorioMedicamento;
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
@WebServlet(name = "MedicamentoServlet", urlPatterns = {"/MedicamentoServlet"})
public class MedicamentoServlet extends HttpServlet {
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    String codigo = request.getParameter("codigo");
    String operacao = request.getParameter("op");

     if (codigo != null) {
            if (operacao != null && operacao.equals("deletar")) {
                RepositorioMedicamento.getCurrentInstance().deletar(Integer.parseInt(codigo));
                
                request.getSession().setAttribute("msg", "Medicamento deletado com sucesso!");
                
                response.sendRedirect("medicamentos.jsp");
                
                return;
            }
            
            Medicamento md = RepositorioMedicamento.getCurrentInstance()
                    .ler(Integer.parseInt(codigo));
            
            request.setAttribute("medicamento", md);
            
            if (operacao != null && operacao.equals("atualizar")) {
                getServletContext().getRequestDispatcher("/cadastroMedicamento.jsp")
                        .forward(request, response);
            }
            else {
                getServletContext().getRequestDispatcher("/detalharMedicamento.jsp")
                        .forward(request, response);
            }
            
            return;
        }
        
        List <Medicamento> medicamentos = RepositorioMedicamento.getCurrentInstance()
                .lerTudo();
        
        request.getSession().setAttribute("medicamentos", medicamentos);
        
        response.sendRedirect("medicamentos.jsp");
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
        
        String nome = request.getParameter("nome");
        int dosagem = Integer.parseInt(request.getParameter("dosagem"));
        String tipoDosagem = request.getParameter("tipoDosagem");
        String descricao = request.getParameter("descricao");
        String observacao = request.getParameter("observacao");
        
        Medicamento md = new Medicamento();
        
        md.setNome(nome);
        md.setDosagem(dosagem);
        md.setTipoDosagem(tipoDosagem);
        md.setDescricao(descricao);
        md.setObservacao(observacao);
        
        HttpSession session = request.getSession();
        
        if (operacao == null) {
            RepositorioMedicamento.getCurrentInstance().inserir(md);
            session.setAttribute("msg", "Medicamento cadastrado com sucesso!");
        }
        else {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            md.setCodigo(codigo);
            RepositorioMedicamento.getCurrentInstance().alterar(md);
            session.setAttribute("msg", "Medicamento alterado com sucesso!");
        }
        
        response.sendRedirect("MedicamentoServlet");
        
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