package employees.business.dto.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BaseEmployee {
  public String registration;
  public String name;
  public String email;
  public String phone;
}
