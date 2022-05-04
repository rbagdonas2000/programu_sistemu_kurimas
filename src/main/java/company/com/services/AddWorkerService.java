package company.com.services;

import company.com.entities.Company;
import company.com.entities.Worker;
import company.com.persistence.CompaniesDAO;
import company.com.persistence.WorkersDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class AddWorkerService implements Serializable {

    @Inject
    private CompaniesDAO companiesDAO;

    @Inject
    private WorkersDAO workersDAO;

    @Getter @Setter
    private Company company;

    @Getter @Setter
    private Worker workerToCreate = new Worker();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer companyId = Integer.parseInt(requestParameters.get("companyId"));
        this.company = companiesDAO.getOne(companyId);
    }

    @Transactional
    public void insert(){
        workerToCreate.setCompany(this.company);
        workersDAO.persist(workerToCreate);
    }
}
