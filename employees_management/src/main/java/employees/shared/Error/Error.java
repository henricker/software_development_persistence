package employees.shared.Error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Error extends RuntimeException{
  private Integer statusCode;
  private ErrorBody body;
}
