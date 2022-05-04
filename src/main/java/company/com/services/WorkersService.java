package company.com.services;

import company.com.entities.Worker;
import company.com.persistence.WorkersDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class WorkersService {

    @Inject
    private WorkersDAO workersDAO;

    @Getter
    private List<Worker> allWorkers;

    @PostConstruct
    public void init(){
        loadWorkers();
    }

    private void loadWorkers(){
        this.allWorkers = workersDAO.getAll();
    }

}
