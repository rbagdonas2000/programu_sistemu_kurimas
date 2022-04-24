package company.com.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "WORKER")
@Getter @Setter
public class Worker {

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
