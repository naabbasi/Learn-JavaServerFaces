package edu.learn.hello;

import com.sun.faces.facelets.compiler.UIText;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.validator.FacesValidator;

@ManagedBean(name = "loginBean")
@SessionScoped
/*@FacesValidator*/
public class LoginBean {
    private String username;
    private String password;
    //private String loginMessage;

    private UIComponent uis;

    @PostConstruct
    private void init() {
    }

    public String login() {
        UIOutput uiLoginStatus = (UIOutput) this.uis.findComponent("loginStatus");
        if (this.getUsername().equalsIgnoreCase("nabbasi") && this.getPassword().equals("x")) {
            return "success";
        } else {
            //FacesContext.getCurrentInstance().addMessage("j_idt5:loginStatus", new FacesMessage("Invalid Username and Password"));
            FacesContext.getCurrentInstance().addMessage(uiLoginStatus.getClientId(), new FacesMessage("Invalid Username and Password"));
            return "failure";
        }
    }

    public void validateLoginDetails(ComponentSystemEvent event) {
        this.uis = event.getComponent();
        System.out.println("Validating");
        UIInput uiUsername = (UIInput) this.uis.findComponent("username");
        Object usernameObj = uiUsername.getLocalValue();
        if (usernameObj != null) {
            this.setUsername(String.valueOf(usernameObj).trim());
        } else {
            this.setUsername(null);
        }

        UIInput uiPassword = (UIInput) this.uis.findComponent("password");
        Object passwordObj = uiPassword.getLocalValue();
        if (passwordObj != null) {
            this.setPassword(String.valueOf(passwordObj).trim());
        } else {
            this.setPassword(null);
        }

        if ((this.getUsername() == null) || (this.getPassword() == null)) {
            UIOutput uiLoginStatus = (UIOutput) this.uis.findComponent("loginStatus");
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("Please enter your login credentials");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(uiLoginStatus.getClientId(), facesMessage);
            facesContext.renderResponse();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
