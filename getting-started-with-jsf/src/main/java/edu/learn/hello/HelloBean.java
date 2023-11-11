package edu.learn.hello;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "helloBean")
@SessionScoped
public class HelloBean {
    private String message;

    @PostConstruct
    private void init() {
        message = "Hello World!! JFS example.. ";
    }

    public String sayHello() {
        this.setMessage("Hey, JSF is working");
        return this.getMessage();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
