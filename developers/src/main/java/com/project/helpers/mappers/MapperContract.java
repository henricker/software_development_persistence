package com.project.helpers.mappers;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public interface MapperContract<T extends Object> {
  public void serialization(OutputStream source, Object value) throws Exception;
  public T deserialization(InputStream source, Class<T> valueType) throws Exception;
  public void serializationAll(OutputStream source, List<T> values) throws Exception ;
  public void deserializationAll(OutputStream source, Class<T>[] valueType) throws Exception ;
}