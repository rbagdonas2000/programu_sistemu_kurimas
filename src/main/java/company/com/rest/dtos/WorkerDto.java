package company.com.rest.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class WorkerDto {

    private String firstName;
    private String lastName;
    private String role;
    private String birthDate;
    private String personalId;
    private String CompanyName;
}
