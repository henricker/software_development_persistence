package com.serializing.contracts;

import java.io.InputStream;
import java.io.OutputStream;

public interface MapperContract<T> {
  public void serialization(OutputStream source, Object value) throws Exception;
  public T deserialization(InputStream source, Class<T> valueType) throws Exception;
}
