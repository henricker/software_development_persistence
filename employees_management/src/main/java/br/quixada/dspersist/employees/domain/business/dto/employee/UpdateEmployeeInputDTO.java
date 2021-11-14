package br.quixada.dspersist.employees.domain.business.dto.employee;

public class UpdateEmployeeInputDTO extends BaseEmployee {
  public UpdateEmployeeInputDTO(String id, String cpf, String registration, String name, String email, String phone) {
   super(id, cpf, registration, name, email, phone);
  }
}
