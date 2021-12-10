package com.serializing.helpers.mappers;

import java.io.InputStream;
import java.io.OutputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serializing.contracts.MapperContract;

public class MapperJSON<T> implements MapperContract<T> {

  private ObjectMapper objectMapper;

  public MapperJSON() {
    this.objectMapper = new ObjectMapper();
  }


  @Override
  public void serialization(OutputStream source, Object value) throws Exception {
    this.objectMapper.writeValue(source, value);
  }

  @Override
  public T deserialization(InputStream source, Class<T> valueType) throws Exception {
    T valueObject = this.objectMapper.readValue(source, valueType);
    return valueObject;
  }
  
}
