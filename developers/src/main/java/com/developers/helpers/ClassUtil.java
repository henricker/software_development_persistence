package com.developers.helpers;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Map;


public class ClassUtil {

  public static <T extends Object> String[] getAttributes(Class<T> classType) {
    Field[] fields= classType.getDeclaredFields();
    String[] attributes = new String[fields.length];

    int counter = 0;
    for(Field field : fields) {
      field.setAccessible(true);
      attributes[counter++] = field.getName();
    }

    return attributes;
  }

  public static <T extends Object> String[] getAttributesValues(T entity) throws Exception {
    Field[] fields = entity.getClass().getDeclaredFields();
    String[] attributesValues = new String[fields.length];

    int counter = 0;
    for(Field field : fields) {
      field.setAccessible(true);
      attributesValues[counter++] = String.valueOf(field.get(entity));
    }

    return attributesValues;
  }

  public static <T extends Object> T getInstance(Class<T> classtype, Map<String, Object> data) throws Exception {
    @SuppressWarnings("unchecked")
    Constructor<T>[] constructors = (Constructor<T>[]) classtype.getConstructors();
    T entity = constructors[0].newInstance(data);

    return entity;
  }
}
