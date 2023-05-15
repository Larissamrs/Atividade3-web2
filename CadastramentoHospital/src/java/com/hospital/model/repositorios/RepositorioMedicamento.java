package com.hospital.model.repositorios;

/**
 *
 * @author larissa.a.da.silva
 */
import com.hospital.model.entities.Medicamento;
import java.util.ArrayList;
import java.util.List;

public class RepositorioMedicamento {

     private static RepositorioMedicamento myself = null;

    public static Medicamento getCurrentInstance(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private final List<Medicamento> medicamentos;
    
    private RepositorioMedicamento(){
        
        this.medicamentos = new ArrayList<>();
        
    }
    
    public static RepositorioMedicamento getCurrentInstance(){
        
        if(myself == null)
            RepositorioMedicamento.myself = new RepositorioMedicamento();
        
        return myself;
        
    }
    
    public void inserir(Medicamento p){
        
        this.medicamentos.add(p);
        
    }
    
    public void alterar(Medicamento p){
        
        for(Medicamento pAux: this.medicamentos){
            
            if(p.getCodigo() == pAux.getCodigo()){
                
                //this.medicamentos.remove(pAux);
                //this.medicamentos.add(p);
                pAux.setNome(p.getNome());
                pAux.setDosagem(p.getDosagem());
                pAux.setTipoDosagem(p.getTipoDosagem());
                pAux.setDescricao(p.getDescricao());
                pAux.setObservacao(p.getObservacao());
                
                return;
                
            }
            
        }
        
    }
    
    public Medicamento ler(int codigo){
        
        for(Medicamento p: this.medicamentos){
            if(p.getCodigo() == codigo){
                return p;
            }
        }
        
        return null;
        
    }
    
    public void deletar(int codigo){
        
        for(int i = 0; i < this.medicamentos.size(); i++){
            
            if(this.medicamentos.get(i).getCodigo() == codigo){
                this.medicamentos.remove(i);
                
                return;
            }
            
        }
        
    }
    
    public List<Medicamento> lerTudo(){
        
        return this.medicamentos;
        
    }   

    public void deletar(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Medicamento ler(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
