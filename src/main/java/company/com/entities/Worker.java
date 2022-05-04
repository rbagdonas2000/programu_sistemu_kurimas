package company.com.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NamedQueries({
        @NamedQuery(name = "Worker.getAll", query = "select w from Worker as w")
})
@Entity
@Table(name = "WORKERS")
@Getter @Setter
public class Worker implements Serializable {

    public Worker() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "FIRST_NAME")
    @Size(max = 50)
    private String firstName;

    @Column(name = "LAST_NAME")
    @Size(max = 50)
    private String lastName;

    @Column(name = "ROLE")
    @Size(max = 50)
    private String role;

    @Column(name = "BIRTH_DATE")
    @Size(max = 50)
    private String birthDate;

    private boolean isManager;

    @Column(name = "PERSONAL_ID", nullable = false)
    private String personalId;

    @ManyToMany
    @JoinTable(name = "WORKER_TASK")
    private List<Task> tasks = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Objects.equals(id, worker.id) &&
                Objects.equals(firstName, worker.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, personalId);
    }
}
