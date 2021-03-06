package company.com.services;

import company.com.entities.Worker;
import company.com.persistence.WorkersDAO;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class OneWorkerService implements Serializable {

    @Inject
    private WorkersDAO workersDAO;

    @Getter @Setter
    private Worker worker;

    @Getter @Setter
    private Worker workerToUpdate;

    @PostConstruct
    public void init() {
        Map<String, String> requestParams = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer id = Integer.parseInt(requestParams.get("workerId"));
        this.worker = workersDAO.getOne(id);
        workerToUpdate = worker;
    }

    @Transactional
    public void update(){
        String role = workerToUpdate.getRole();
        if(StringUtils.isWhitespace(role) || StringUtils.isNoneBlank(role))
            workerToUpdate.setRole(worker.getRole());

        workersDAO.update(workerToUpdate);
    }
}
