package com.example.utils;

import java.util.Collection;

public class Validations {
    //Para validar si un turno, un id...(algun objeto) es nulo
    public static void notNull(Object obj, String message) {
        if (obj == null) {
            throw new IllegalArgumentException(message);
        }
    }

    //Para validar que no hayan listas vacias
    public static void notEmpty(Collection<?> collection, String message) {
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }
    public static void StringNotEmpty(String str, String message) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }
}
