package edu.learn.hello.tables;

import edu.learn.hello.dto.Players;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "simpleTableBean")
@ViewScoped
public class SimpleTableBean implements Serializable {
    private List<Players> data = new ArrayList<>();
    private String startDate;
    private String endDate;
    private UIComponent uis;

    public SimpleTableBean() {
    }

    public void showData() {
        data.add(new Players(2, "NOVAK DJOKOVIC", (byte) 26,
                "Belgrade, Serbia", "Monte Carlo, Monaco", (short) 188,
                (byte) 80, "Boris Becker, Marian Vajda",
                Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC))));

        data.add(new Players(1, "RAFAEL NADAL", (byte) 27, "Manacor Mallorca, Spain",
                "Manacor, Mallorca, Spain", (short) 185,
                (byte) 85, "Toni Nadal",
                Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC))));
        data.add(new Players(7, "TOMAS BERDYCH", (byte) 28,
                "Valasske Mezirici, Czech", "Monte Carlo, Monaco",
                (short) 196, (byte) 91, "Tomas Krupa",
                Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC))));
    }

    public void validateDateCriteria(ComponentSystemEvent event) {
        this.uis = event.getComponent();
        UIInput uiStartDate = (UIInput) this.uis.findComponent("startDate");
        Object startDateObj = uiStartDate.getLocalValue();
        if (startDateObj != null) {
            this.setStartDate(String.valueOf(startDateObj).trim());
        } else {
            this.setStartDate(null);
        }

        UIInput uiEndDate = (UIInput) this.uis.findComponent("endDate");
        Object endDateObj = uiEndDate.getLocalValue();
        if (endDateObj != null) {
            this.setEndDate(String.valueOf(endDateObj).trim());
        } else {
            this.setEndDate(null);
        }

        if ((this.getStartDate() == null) || (this.getEndDate() == null)) {
            UIOutput uiCriteria = (UIOutput) this.uis.findComponent("criteria");
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("Please provide start and end dates");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(uiCriteria.getClientId(), facesMessage);
            facesContext.renderResponse();
        }
    }

    public List<Players> getData() {
        return data;
    }

    public void setData(List<Players> data) {
        this.data = data;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
