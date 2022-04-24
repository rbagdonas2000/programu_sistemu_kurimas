package company.com.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "COMPANY")
@Getter @Setter
public class Company {

    public Company() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "company")
    private List<Worker> workers = new ArrayList<>();
}
