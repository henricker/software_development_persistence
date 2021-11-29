package br.com.quixada.dspersist.employees.domain.business.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
public class ListEmployeeInputDTO {
  @NonNull @Getter @Setter private Integer page;
  @NonNull @Getter @Setter private Integer limit;
}