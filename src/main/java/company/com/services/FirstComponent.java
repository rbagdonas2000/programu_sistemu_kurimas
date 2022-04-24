package company.com.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;



@Named
@SessionScoped
public class FirstComponent implements Serializable {

    //@Inject
    private SecondComponent second;

    @Inject
    public FirstComponent(SecondComponent second)
    {
        this.second = second;
    }

    public String sakykLabas() {
        return "Labas " + new Date() + " " + toString();
    }

    @PostConstruct
    public void init() {
        System.out.println(toString() + " constructed.");
        System.out.println(second.getClass().getName());
    }

    @PreDestroy
    public void aboutToDie() {
        System.out.println(toString() + " ready to die.");
    }

}
