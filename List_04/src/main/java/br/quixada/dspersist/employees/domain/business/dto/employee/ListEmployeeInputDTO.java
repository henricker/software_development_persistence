package br.quixada.dspersist.employees.domain.business.dto.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ListEmployeeInputDTO {
  private Integer page = 0;
  private Integer limit = 10;
}
