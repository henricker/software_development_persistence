package com.developers.helpers.mappers.implementations;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import com.developers.helpers.mappers.MapperContract;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class MapperXML<T extends Object> implements MapperContract<T> {

  private XmlMapper mapper;

  public MapperXML() {
    this.mapper = new XmlMapper();
  }

  @Override
  public void serialization(OutputStream source, Object value) throws Exception {
    this.mapper.writerWithDefaultPrettyPrinter().writeValue(source, value); 
  }

  @Override
  public T deserialization(InputStream source, Class<T> valueType) throws Exception {
    T valueObject = this.mapper.readValue(source, valueType);
    return valueObject;
  }

  @Override
  public void serializationAll(OutputStream source, List<T> values) throws Exception  {
    this.mapper.writerWithDefaultPrettyPrinter().writeValue(source, values);
  }

  @Override
  public void deserializationAll(OutputStream source, Class<T>[] valueType) throws Exception  {
    // TODO Auto-generated method stub
    
  }
}