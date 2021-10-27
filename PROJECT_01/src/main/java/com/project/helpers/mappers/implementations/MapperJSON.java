package com.project.helpers.mappers.implementations;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.helpers.mappers.MapperContract;

public class MapperJSON<T extends Object> implements MapperContract<T> {

  private ObjectMapper objectMapper;

  public MapperJSON() {
    this.objectMapper = new ObjectMapper();
  }

  @Override
  public void serialization(OutputStream source, Object value) throws Exception {
    this.objectMapper.writerWithDefaultPrettyPrinter().writeValue(source, value);
  }

  @Override
  public T deserialization(InputStream source, Class<T> valueType) throws Exception {
    T valueObject = this.objectMapper.readValue(source, valueType);
    return valueObject;
  }

  @Override
  public void serializationAll(OutputStream source, List<T> values) throws Exception {
    this.objectMapper.writerWithDefaultPrettyPrinter().writeValue(source, values);
  }

  @Override
  public void deserializationAll(OutputStream source, Class<T>[] valueType) throws Exception  {
    // TODO Auto-generated method stub
    
  }
  
}