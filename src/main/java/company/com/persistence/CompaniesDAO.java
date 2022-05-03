package company.com.persistence;

import company.com.entities.Company;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class CompaniesDAO {

    @Inject
    @PersistenceContext
    @Setter
    private EntityManager em;

    public List<Company> getAll() {
        return em.createNamedQuery("Company.getAll", Company.class).getResultList();
    }

    public void persist(Company company){
        System.out.println("Atejom i persist");
        System.out.println(company.getName());
        em.persist(company);
    }

    public Company getOne(Integer id){
        return em.find(Company.class, id);
    }
}
