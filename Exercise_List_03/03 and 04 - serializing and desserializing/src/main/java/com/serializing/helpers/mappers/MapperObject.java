package com.serializing.helpers.mappers;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import com.serializing.contracts.SerializationContract;

public class MapperObject<T> implements SerializationContract<T> {

  public MapperObject() {}

  @Override
  public void serialization(OutputStream source, Object value) throws Exception {
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(source);
    objectOutputStream.writeObject(value);
    objectOutputStream.close();
  }

  @Override
  public T deserialization(InputStream source, Class<T> valueType) throws Exception {
    ObjectInputStream objectInputStream = new ObjectInputStream(source);
    @SuppressWarnings("unchecked")
    T valueObject = (T) objectInputStream.readObject();
    objectInputStream.close();

    return valueObject;
  }
  
}
