package company.com.persistence;

import company.com.entities.Company;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class CompaniesDAO {

    @Inject
    @Setter
    private EntityManager em;

    public List<Company> getAll() {
        return em.createNamedQuery("Company.getAll", Company.class).getResultList();
    }

    public void persist(Company company){
        this.em.persist(company);
    }

    public Company getOne(Integer id){
        return em.find(Company.class, id);
    }
}
