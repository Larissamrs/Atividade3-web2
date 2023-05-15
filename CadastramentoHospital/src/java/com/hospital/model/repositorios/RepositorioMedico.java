package com.hospital.model.repositorios;

/**
 *
 * @author larissa.a.da.silva
 */
import com.hospital.model.entities.Medico;
import java.util.ArrayList;
import java.util.List;

public class RepositorioMedico {

     private static RepositorioMedico myself = null;
    
    private final List<Medico> medicos;
    
    private RepositorioMedico(){
        
        this.medicos = new ArrayList<>();
        
    }
    
    public static RepositorioMedico getCurrentInstance(){
        
        if(myself == null)
            RepositorioMedico.myself = new RepositorioMedico();
        
        return myself;
        
    }
    
    public void inserir(Medico m){
        
        this.medicos.add(m);
        
    }
    
    public void alterar(Medico m){
        
        for(Medico mAux: this.medicos){
            
            if(m.getCrm().equals(mAux.getCrm())){
                
                //this.medicos.remove(pAux);
                //this.medicos.add(p);
                mAux.setCrm(m.getCrm());
                mAux.setNome(m.getNome());
                mAux.setEspecialidade(m.getEspecialidade());
                mAux.setContato(m.getContato());
                
                return;
                
            }
            
        }
        
    }
    
    public Medico ler(String crm){
        
        for(Medico m: this.medicos){
            if(m.getCrm().equals(crm)){
                return m;
            }
        }
        
        return null;
        
    }
    
    public void deletar(String crm){
        
        for(int i = 0; i < this.medicos.size(); i++){
            
            if(this.medicos.get(i).getCrm().equals(crm)){
                this.medicos.remove(i);
                
                return;
            }
            
        }
        
    }
    
    public List<Medico> lerTudo(){
        
        return this.medicos;
        
    }   

}
