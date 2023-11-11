package edu.learn.hello;

import edu.learn.hello.dto.Players;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "simpleTableBean")
@ViewScoped
public class SimpleTableBean implements Serializable {
    private List<Players> data = new ArrayList<>();

    public SimpleTableBean() {

        data.add(new Players(2, "NOVAK DJOKOVIC", (byte) 26,
                "Belgrade, Serbia", "Monte Carlo, Monaco", (short) 188,
                (byte) 80, "Boris Becker, Marian Vajda",
                LocalDateTime.now()));
        data.add(new Players(1, "RAFAEL NADAL", (byte) 27, "Manacor Mallorca, Spain",
                "Manacor, Mallorca, Spain", (short) 185,
                (byte) 85, "Toni Nadal", LocalDateTime.now()));
        data.add(new Players(7, "TOMAS BERDYCH", (byte) 28,
                "Valasske Mezirici, Czech", "Monte Carlo, Monaco",
                (short) 196, (byte) 91, "Tomas Krupa",
                LocalDateTime.now()));

    }

    public List<Players> getData() {
        return data;
    }

    public void setData(List<Players> data) {
        this.data = data;
    }
}
