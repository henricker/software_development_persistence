package com.project.helpers.mappers;

import java.io.InputStream;
import java.io.OutputStream;

public interface MapperContract<T extends Object> {
  public void serialization(OutputStream source, Object value) throws Exception;
  public T deserialization(InputStream source, Class<T> valueType) throws Exception;
}