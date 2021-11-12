
package employees.shared.Error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorBody {
  private String code;
  private String message;
  private String shortMessage;
}