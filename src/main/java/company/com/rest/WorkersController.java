package company.com.rest;

import company.com.entities.Company;
import company.com.entities.Worker;
import company.com.persistence.CompaniesDAO;
import company.com.persistence.WorkersDAO;
import company.com.rest.dtos.WorkerDto;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/workers")
public class WorkersController {

    @Inject
    @Getter @Setter
    private WorkersDAO workersDAO;

    @Inject
    @Getter @Setter
    private CompaniesDAO companiesDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id){
        System.out.println("Got request to workers controller");
        Worker worker = workersDAO.getOne(id);
        System.out.println(worker);
        if(worker == null){
            System.out.println("Worker not found");
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        WorkerDto workerDto = new WorkerDto();
        workerDto.setFirstName(worker.getFirstName());
        workerDto.setLastName(worker.getLastName());
        workerDto.setRole(worker.getRole());
        workerDto.setCompanyName(worker.getCompany().getName());

        return Response.ok(workerDto).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") final Integer id, WorkerDto worker){
        try{
            Worker existingWorker = workersDAO.getOne(id);
            if(existingWorker == null){
                System.out.println("Worker not found");
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingWorker.setFirstName(worker.getFirstName());
            existingWorker.setLastName(worker.getLastName());
            existingWorker.setRole(worker.getRole());

            workersDAO.update(existingWorker);

            return Response.ok().build();
        } catch (OptimisticLockException ex){
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @Path("/{id}/role")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateRole(@PathParam("id") final Integer id, WorkerDto worker){
        try{
            Worker existingWorker = workersDAO.getOne(id);
            if(existingWorker == null){
                System.out.println("Worker not found");
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingWorker.setRole(worker.getRole());

            workersDAO.update(existingWorker);

            return Response.ok().build();
        } catch (OptimisticLockException ex){
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response insert(WorkerDto worker){
        try{
            Company company = companiesDAO.getByName(worker.getCompanyName());
            if(company == null){
                System.out.println("Company not found");
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            Worker newWorker = new Worker();

            newWorker.setFirstName(worker.getFirstName());
            newWorker.setLastName(worker.getLastName());
            newWorker.setRole(worker.getRole());
            newWorker.setPersonalId(worker.getPersonalId());
            newWorker.setBirthDate(worker.getBirthDate());
            newWorker.setCompany(company);

            workersDAO.persist(newWorker);

            return Response.ok().build();
        } catch (OptimisticLockException ex){
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
