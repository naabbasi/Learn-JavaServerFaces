package edu.learn.hello;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "sessionBeanDemo")
@SessionScoped
public class SessionBeanDemo {
    private String view;

    @PostConstruct
    public void init() {
        this.view = "Initial value";
    }

    public void changeView() {
        System.out.println("View value: %s".formatted(this.view));
    }

    public String changeView(String view) {
        System.out.println("Old value: %s, New value: %s".formatted(this.view, view));
        this.view = view;
        return this.view;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }
}
