package employees.business.dto.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class BaseEmployee {
  public String id;
  @NonNull public String cpf;
  @NonNull public String registration;
  @NonNull public String name;
  @NonNull public String email;
  @NonNull String phone;
}
