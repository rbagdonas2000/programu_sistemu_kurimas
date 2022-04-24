package company.com.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

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

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID")
    private Company company;
}
