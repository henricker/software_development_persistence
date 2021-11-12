package employees.domain.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Employee {
  @Getter @Setter private String id;
  @NonNull @Getter @Setter private String cpf;
  @NonNull @Getter @Setter private String registration;
  @NonNull @Getter @Setter private String name;
  @NonNull @Getter @Setter private String email;
  @NonNull @Getter @Setter private String phone;
}
