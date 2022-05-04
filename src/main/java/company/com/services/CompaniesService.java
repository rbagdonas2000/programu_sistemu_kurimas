package company.com.services;

import company.com.entities.Company;
import company.com.persistence.CompaniesDAO;
import lombok.Getter;
import lombok.Setter;
import javax.transaction.Transactional;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class CompaniesService {

    @Inject
    private CompaniesDAO companiesDAO;

    @Getter @Setter
    private Company companyToCreate = new Company();

    @Getter
    private List<Company> allCompanies;

    @PostConstruct
    public void init(){
        loadCompanies();
    }

    private void loadCompanies(){
        this.allCompanies = companiesDAO.getAll();
    }

    @Transactional
    public void createCompany(){
        companiesDAO.persist(companyToCreate);
    }
}
