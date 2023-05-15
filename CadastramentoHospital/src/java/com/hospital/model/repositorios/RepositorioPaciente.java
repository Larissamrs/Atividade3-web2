/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.model.repositorios;

import com.hospital.model.entities.Paciente;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author larissa.a.da.silva
 */
public class RepositorioPaciente {
    
    private static RepositorioPaciente myself = null;
    
    private final List<Paciente> pacientes;
    
    private RepositorioPaciente(){
        
        this.pacientes = new ArrayList<>();
        
    }
    
    public static RepositorioPaciente getCurrentInstance(){
        
        if(myself == null)
            RepositorioPaciente.myself = new RepositorioPaciente();
        
        return myself;
        
    }
    
    public void inserir(Paciente p){
        
        this.pacientes.add(p);
        
    }
    
    public void alterar(Paciente p){
        
        for(Paciente pAux: this.pacientes){
            
            if(p.getCpf().equals(pAux.getCpf())){
                
                //this.pacientes.remove(pAux);
                //this.pacientes.add(p);
                pAux.setNome(p.getNome());
                pAux.setEndereco(p.getEndereco());
                pAux.setContato(p.getContato());
                pAux.setPlanoSaude(p.getPlanoSaude());
                
                return;
                
            }
            
        }
        
    }
    
    public Paciente ler(String cpf){
        
        for(Paciente p: this.pacientes){
            if(p.getCpf().equals(cpf)){
                return p;
            }
        }
        
        return null;
        
    }
    
    public void deletar(String cpf){
        
        for(int i = 0; i < this.pacientes.size(); i++){
            
            if(this.pacientes.get(i).getCpf().equals(cpf)){
                this.pacientes.remove(i);
                
                return;
            }
            
        }
        
    }
    
    public List<Paciente> lerTudo(){
        
        return this.pacientes;
        
    }   
    
}
