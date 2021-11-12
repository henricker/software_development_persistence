package employees.business.dto.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CreateEmployeeInputDTO {
  private String cpf;
  private String registration;
  private String name;
  private String email;
  private String phone;
}
