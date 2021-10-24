package com.project.helpers.mappers.implementations;

import java.io.InputStream;
import java.io.OutputStream;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.project.helpers.mappers.MapperContract;

public class MapperXML<T extends Object> implements MapperContract<T> {

  private XmlMapper mapper;

  public MapperXML() {
    this.mapper = new XmlMapper();
  }

  @Override
  public void serialization(OutputStream source, Object value) throws Exception {
    this.mapper.writeValue(source, value); 
  }

  @Override
  public T deserialization(InputStream source, Class<T> valueType) throws Exception {
    T valueObject = this.mapper.readValue(source, valueType);
    return valueObject;
  }
}