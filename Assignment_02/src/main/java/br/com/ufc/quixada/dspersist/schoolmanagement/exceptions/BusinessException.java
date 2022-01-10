package br.com.ufc.quixada.dspersist.schoolmanagement.exceptions;

import lombok.Getter;

public class BusinessException extends RuntimeException {
  @Getter Integer code;
  @Getter String shortMessage;

  public BusinessException(Integer code, String shortMessage, String message) {
    super(message);
    this.code = code;
    this.shortMessage = shortMessage;
  }
}
