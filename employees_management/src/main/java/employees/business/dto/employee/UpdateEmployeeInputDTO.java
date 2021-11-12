package employees.business.dto.employee;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UpdateEmployeeInputDTO extends BaseEmployee {
  private String id;
  public UpdateEmployeeInputDTO(String id, String registration, String name, String email, String phone) {
   super(registration, name, email, phone);
   this.id = id;
  }
}
