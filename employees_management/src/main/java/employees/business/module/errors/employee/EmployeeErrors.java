package employees.business.module.errors.employee;

import employees.shared.Error.ErrorBody;
import employees.shared.Error.Error;

public class EmployeeErrors extends Error {
  public EmployeeErrors(Integer statusCode, ErrorBody body) {
    super(statusCode, body);
  }

  public static EmployeeErrors employeeCreationError() {
    return new EmployeeErrors(
      400, 
      new ErrorBody(
        "UE-001", 
        "Error during creation of the employee entity, please try again later", 
        "EmployeeCreationFailed"
        )
      );
  }

  public static EmployeeErrors cpfAlreadyExistsError() {
    return new EmployeeErrors(
      400, 
      new ErrorBody(
        "UE-002", 
        "This cpf already in use", 
        "EmployeeCreationFailed"
        )
      );
  }

  public static EmployeeErrors registrationAlreadyExistsError() {
    return new EmployeeErrors(
      400, 
      new ErrorBody(
        "UE-003", 
        "This registration already in use", 
        "EmployeeCreationFailed"
        )
      );
  }

  public static EmployeeErrors employeeListError() {
    return new EmployeeErrors(
      400
    , new ErrorBody(
      "UE-004", 
      "Error during getting employees, please try again later",
      "EmployeeListFailed"
      )
    );
  }

  public static EmployeeErrors employeeNotFoundError() {
    return new EmployeeErrors(
      404, 
      new ErrorBody(
        "UE-005", 
        "Employee not found on database", 
        "EmployeeNotFoundError"
      )
    );
  }
}
