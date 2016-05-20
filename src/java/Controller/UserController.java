package Controller;

import Entity.Administrator;
import Entity.User;
import Service.tool.JPA.MetierFactory;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

/**
 *
 * @author jupiter
 */
@ManagedBean
@SessionScoped
public class UserController implements Serializable {

    public UserController() {
    }

    private String firstName;
    private String name;
    private String login;
    private String password;
    private String nationality;
    private String email;
    private String image;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void save(ActionEvent event) {
        FacesMessage message = null;
        RequestContext context = RequestContext.getCurrentInstance();
        ExternalContext content = FacesContext.getCurrentInstance().getExternalContext();
        User usr = new User();
        Administrator admin = new Administrator();

        try {
            usr = MetierFactory.getUserService().getByLogin(this.login);
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Doublon detecté", "L'utilisateur " + this.login + " existe déjà !");
        } catch (Exception ex) {
            if (this.password.contains("@+")) {
                admin.setFirstName(this.firstName);
                admin.setName(this.name);
                admin.setLogin(this.login);
                admin.setPassword(this.password);
                admin.setNationality(this.nationality);
                admin.setEmail(this.email);
                admin.setImage("images/avatars/" + this.image);
                admin.setIsAdmin(this.password);
            } else {
                usr.setFirstName(this.firstName);
                usr.setName(this.name);
                usr.setLogin(this.login);
                usr.setPassword(this.password);
                usr.setNationality(this.nationality);
                usr.setEmail(this.email);
                usr.setImage("images/avatars/" + this.image);
                usr.setIsAdmin(this.password);
            }

            try {
                usr = MetierFactory.getUserService().add(usr);
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succés", "L'utilisateur " + this.login + " a été crée !");
            } catch (Exception ex1) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex1);
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Problème connexion", "Impossible suite à un problème de connexion");
            }
            LoginController ctrl = (LoginController) content.getSessionMap().get("loginController");
            ctrl.setLoginName(usr.getLogin());
            ctrl.setPassword(usr.getPassword());
            ctrl.login(event);
            try {
                content.redirect("./index.xhtml");
            } catch (IOException ex1) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
