package com.serializing.helpers.mappers;

import java.io.InputStream;
import java.io.OutputStream;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.serializing.contracts.SerializationContract;

public class MapperXML<T> implements SerializationContract<T> {

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
