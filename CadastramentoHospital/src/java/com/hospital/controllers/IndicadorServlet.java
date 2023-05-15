/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.controllers;

import com.hospital.model.entities.Indicador;
import com.hospital.model.repositorios.RepositorioIndicadores;
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
@WebServlet(name = "IndicadorServlet", urlPatterns = {"/IndicadorServlet"})
public class IndicadorServlet extends HttpServlet {
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
        
        if(codigo != null){
            
            if(operacao!=null && operacao.equals("deletar")){
                
                RepositorioIndicadores.getCurrentInstance().deletar(Integer.parseInt(codigo));
                
                request.getSession().setAttribute("msg", "Indicador deletado com sucesso!");
                
                response.sendRedirect("indicadorExame.jsp");
                
                return;
            }
            
            
           Indicador in = RepositorioIndicadores.getCurrentInstance()
                    .ler(Integer.parseInt(codigo));
        
            request.setAttribute("indicadorExame", in);
            
            if(operacao != null && operacao.equals("atualizar")){
                getServletContext().getRequestDispatcher("/cadastroIndicadorExame.jsp")
                        .forward(request, response);
            }
            else {
                getServletContext().getRequestDispatcher("/detalharIndicadorExame.jsp")
                .forward(request, response);
            }
            
            return;
        }
        
        List<Indicador> indicadorExame = RepositorioIndicadores.getCurrentInstance()
                .lerTudo();
        
        request.getSession().setAttribute("indicadorExame", indicadorExame);
    
        response.sendRedirect("indicadorExame.jsp");
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
        
        String indicador = request.getParameter("indicador");
        String descricao = request.getParameter("descricao");
        String minValorReferenciaTemp = request.getParameter("minValorReferencia");
        String maxValorReferenciaTemp = request.getParameter("maxValorReferencia");
        
        minValorReferenciaTemp = minValorReferenciaTemp.replaceAll(",", ".");
        Double minValorReferencia = Double.parseDouble(minValorReferenciaTemp);
        
        maxValorReferenciaTemp = maxValorReferenciaTemp.replaceAll(",", ".");
        Double maxValorReferencia = Double.parseDouble(maxValorReferenciaTemp);
        
        Indicador in = new Indicador();
        
        in.setIndicador(indicador);
        in.setDescricao(descricao);
        in.setMinValorReferencia(minValorReferencia);
        in.setMaxValorReferencia(maxValorReferencia);
        
        HttpSession session = request.getSession();
        
        if(operacao==null){
            RepositorioIndicadores.getCurrentInstance().inserir(in);
            session.setAttribute("msg", "Indicador cadastrado com sucesso!");
        }else{
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            in.setCodigo(codigo);
            RepositorioIndicadores.getCurrentInstance().alterar(in);
            session.setAttribute("msg", "Indicador Alterado com sucesso!");
            
        }
 
        
        response.sendRedirect("IndicadorServlet");
        
        
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