package company.com.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TASKS")
@Getter
@Setter
public class Task implements Serializable {

    public Task() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ABBREVIATION")
    @Size(max = 3)
    private String abbreviation;

    private String identifier;

    private String title;

    private String description;

    @ManyToMany(mappedBy = "tasks")
    private List<Worker> workers;

    public void setIdentifier() {
        this.identifier = this.abbreviation + this.id.toString();
    }

    public String getIdentifier(){
        return this.identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) &&
                Objects.equals(identifier, task.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, identifier);
    }
}
