
package cadastro.manager;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import org.primefaces.event.FlowEvent;



@Named
@ViewScoped
public class ManegerCadastro implements Serializable {
    
 private cadastro user = new cadastro();
 private String nome;
 private String datanascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
      
    public void mensagem(){
               
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Seja bem vinda(a)-" + nome));
         
       
    }    

    private boolean skip;

    public cadastro getUser() {
        return user;
    }

    public void setUser(cadastro user) {
        this.user = user;
    }

    public String getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }
    

    public void save() {
        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + user.getPrimeironome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false; //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
    
}
