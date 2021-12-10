package br.quixada.dspersist.employees.mocks.dto.employee;

import br.quixada.dspersist.employees.domain.business.dto.employee.CreateEmployeeInputDTO;
import br.quixada.dspersist.employees.domain.business.dto.employee.ListEmployeeInputDTO;
import br.quixada.dspersist.employees.domain.business.dto.employee.UpdateEmployeeInputDTO;

public class FakeEmployeeDTOFactory {

  public static CreateEmployeeInputDTO createEmployeeInput() {
    return new CreateEmployeeInputDTO(
        "valid_cpf", 
        "valid_registration", 
        "valid_name", 
        "valid@email.com", 
        "valid_phone"
      );
  }
  
  public static ListEmployeeInputDTO listEmployeeInput() {
    return new ListEmployeeInputDTO();
  }

  public static UpdateEmployeeInputDTO updateEmployeeInput() {
    return new UpdateEmployeeInputDTO("valid_id", "valid_cpf", "valid_registration", "valid_name", "valid_email", "valid_phone");
  }
  
}
