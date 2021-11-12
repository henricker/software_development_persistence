package employees.business.dto.employee;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CreateEmployeeInputDTO extends BaseEmployee {
  public CreateEmployeeInputDTO(String cpf, String registration, String name, String email, String phone) {
    super(cpf, registration, name, email, phone);
  }
}
