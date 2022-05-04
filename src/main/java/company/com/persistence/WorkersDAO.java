package company.com.persistence;

import company.com.entities.Worker;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class WorkersDAO {

    @Inject
    private EntityManager em;

    public void setEm(EntityManager em) { this.em = em; }

    public List<Worker> getAll() {
        return em.createNamedQuery("Worker.getAll", Worker.class).getResultList();
    }

    public void persist(Worker worker){
        this.em.persist(worker);
    }

    public Worker getOne(Integer id){
        return em.find(Worker.class, id);
    }

    public void update(Worker worker){
        em.merge(worker);
    }
}
