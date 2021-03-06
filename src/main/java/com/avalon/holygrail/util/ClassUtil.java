package com.avalon.holygrail.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by 白超 on 2018-1-2.
 */
public class ClassUtil {

    /**
     * 获取所有Field名称
     * @param clazz
     * @return
     */
    public static ArrayList<String> getAllFieldNames(Class<?> clazz) {
        ArrayList<String> rs = new ArrayList<>();
        for (Class<?> cla = clazz; cla != Object.class; cla = cla.getSuperclass()) {
            for (Field field : cla.getDeclaredFields()) {
                rs.add(field.getName());
            }
        }
        return rs;
    }

    /**
     * 获取所有Field
     * @param clazz
     * @return
     */
    public static ArrayList<Field> getAllFields(Class<?> clazz) {
        ArrayList<Field> rs = new ArrayList<>();
        for (Class<?> cla = clazz; cla != Object.class; cla = cla.getSuperclass()) {
            for (Field field : cla.getDeclaredFields()) {
                rs.add(field);
            }
        }
        return rs;
    }

    /**
     * 获取所有Method
     * @param clazz
     * @return
     */
    public static ArrayList<Method> getAllMethods(Class<?> clazz) {
        ArrayList<Method> rs = new ArrayList<>();

        for (Class<?> cla = clazz; cla != Object.class; cla = cla.getSuperclass()) {
            for (Method method : cla.getDeclaredMethods()) {
                rs.add(method);
            }
        }
        return rs;
    }

    /**
     * 根据属性名称和java类型，获取对应的getter方法名
     * @param property 属性名称
     * @param javaType 属性类型
     * @return
     */
    public static String getGetterMethodName(String property, String javaType) {
        StringBuilder sb = new StringBuilder();
        sb.append(property);
        if (Character.isLowerCase(sb.charAt(0))) {
            if (sb.length() == 1 || !Character.isUpperCase(sb.charAt(1))) {
                sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            }
        }
        if ("boolean".equals(javaType)) {
            sb.insert(0, "is");
        } else {
            sb.insert(0, "get");
        }
        return sb.toString();
    }

    /**
     * 根据属性名称获取对应的setter方法名称
     * @param property 属性名称
     * @return
     */
    public static String getSetterMethodName(String property) {
        StringBuilder sb = new StringBuilder();
        sb.append(property);
        if (Character.isLowerCase(sb.charAt(0))) {
            if (sb.length() == 1 || !Character.isUpperCase(sb.charAt(1))) {
                sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            }
        }
        sb.insert(0, "set");
        return sb.toString();
    }
}
