package employees.mocks.dto.employee;

import employees.business.dto.employee.CreateEmployeeInputDTO;

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
  
}
