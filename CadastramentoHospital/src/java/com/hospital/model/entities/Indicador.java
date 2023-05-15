/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.model.entities;

/**
 *
 * @author larissa.a.da.silva
 */
public class Indicador {

    private int codigo;
    private String indicador;
    private String descricao;
    private Double minValorReferencia;
    private Double maxValorReferencia;
    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getMinValorReferencia() {
        return minValorReferencia;
    }

    public void setMinValorReferencia(Double minValorReferencia) {
        this.minValorReferencia = minValorReferencia;
    }
    public Double getMaxValorReferencia() {
        return maxValorReferencia;
    }

    public void setMaxValorReferencia(Double maxValorReferencia) {
        this.maxValorReferencia = maxValorReferencia;
    }
}