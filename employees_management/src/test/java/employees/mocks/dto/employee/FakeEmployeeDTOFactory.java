package employees.mocks.dto.employee;

import employees.business.dto.employee.CreateEmployeeInputDTO;
import employees.business.dto.employee.ListEmployeeInputDTO;

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
  
}
