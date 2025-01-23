package com.example.utils;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class Validations {
    //Para validar nulo o vacios
    public static void notNull(Object obj, String message) {
        if (obj == null) {
            throw new IllegalArgumentException(message);
        }
    }

    //Que no hayan listas vacias
    public static void notEmpty(Collection<?> collection, String message) {
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    //Strings vacios
    public static void StringNotEmpty(String str, String message) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    //valores unicos para dni, numss, nombre y descripcion
    public static <T> void uniqueValue(List<T> list, Predicate<T> predicate,String message) {
        boolean exists = list.stream().anyMatch(predicate);
        if (exists) {
            throw new IllegalArgumentException(message);
        }
    }
}
