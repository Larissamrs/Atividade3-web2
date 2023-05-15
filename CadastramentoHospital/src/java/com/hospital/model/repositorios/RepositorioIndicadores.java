/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.model.repositorios;

import com.hospital.model.entities.Indicador;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author larissa.a.da.silva
 */
public class RepositorioIndicadores {

     private static RepositorioIndicadores myself = null;
    
    private final List<Indicador> indicadores;
    
    private RepositorioIndicadores(){
        
        this.indicadores = new ArrayList<>();
        
    }
    
    public static RepositorioIndicadores getCurrentInstance(){
        
        if(myself == null)
            RepositorioIndicadores.myself = new RepositorioIndicadores();
        
        return myself;
        
    }
    
    public void inserir(Indicador p){
        
        this.indicadores.add(p);
        
    }
    
    public void alterar(Indicador in){
        
        for(Indicador inAux: this.indicadores){
            
            if(in.getCodigo() == inAux.getCodigo()){
                
                //this.indicadores.remove(pAux);
                //this.indicadores.add(p);
                
                inAux.setIndicador(in.getIndicador());
                inAux.setDescricao(in.getDescricao());
                inAux.setMinValorReferencia(in.getMinValorReferencia());
                inAux.setMaxValorReferencia(in.getMaxValorReferencia());
                
                return;
                
            }
            
        }
        
    }
    
    public Indicador ler(int codigo){
        
        for(Indicador in: this.indicadores){
            if(in.getCodigo() == codigo){
                return in;
            }
        }
        
        return null;
        
    }
    
    public void deletar(int codigo){
        
        for(int i = 0; i < this.indicadores.size(); i++){
            
            if(this.indicadores.get(i).getCodigo() == codigo){
                this.indicadores.remove(i);
                
        return;
            }
            
        }
        
    }
    
    public List<Indicador> lerTudo(){
        
        return this.indicadores;
        
    }   

    public void inserir(InputStream in) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
