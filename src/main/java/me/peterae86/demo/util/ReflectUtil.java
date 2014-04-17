package me.peterae86.demo.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;

/**
 * @author xiaolong.chang
 * @date Oct 11, 2013
 */
public class ReflectUtil {
    private static Logger logger = LoggerFactory.getLogger("xcd.util");

    /**
     * 利用反射获取指定对象的指定属�?     * 
     * @param obj 目标对象
     * @param fieldName 目标属�?
     * @return 目标属�?的�?
     */
    public static Object getFieldValue(Object obj, String fieldName) {
        Object result = null;
        Field field = ReflectUtil.getField(obj, fieldName);
        if (field != null) {
            field.setAccessible(true);
            try {
                result = field.get(obj);
            } catch (IllegalArgumentException e) {
                logger.error(e.getMessage(), e);
            } catch (IllegalAccessException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return result;
    }

    /**
     * 利用反射获取指定对象里面的指定属�?     * 
     * @param obj 目标对象
     * @param fieldName 目标属�?
     * @return 目标字段
     */
    private static Field getField(Object obj, String fieldName) {
        Field field = null;
        for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                break;
            } catch (NoSuchFieldException e) {
                // 这里不用做处理，子类没有该字段可能对应的父类有，都没有就返回null�?                logger.error(e.getMessage(), e);
            }
        }
        return field;
    }

    /**
     * 利用反射设置指定对象的指定属性为指定的�?
     * 
     * @param obj 目标对象
     * @param fieldName 目标属�?
     * @param fieldValue 目标�?     */
    public static void setFieldValue(Object obj, String fieldName, String fieldValue) {
        Field field = ReflectUtil.getField(obj, fieldName);
        if (field != null) {
            try {
                field.setAccessible(true);
                field.set(obj, fieldValue);
            } catch (IllegalArgumentException e) {
                logger.error(e.getMessage(), e);
            } catch (IllegalAccessException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }
    public static Map<String, Object> relectFieldValueMap(String singleKey, Object singleValue) {
        Map<String, Object> paramsMap = Maps.newHashMap();
        Field[] fields = singleValue.getClass().getDeclaredFields();
        if (isSimpleType(singleValue) || fields.length == 0) {
            paramsMap.put(singleKey, singleValue);
            return paramsMap;
        }
        for (Field field : fields) {
            paramsMap.put(field.getName(), getFieldValue(singleValue, field.getName()));
        }
        return paramsMap;
    }

    private static boolean isSimpleType(Object singleValue) {
        String packageName = singleValue.getClass().getPackage().getName();
        if (packageName.startsWith("java.")) {
            return true;
        }
        if (singleValue.getClass().isEnum()) {
            return true;
        }
        return false;
    }
    
    private static void makeAccessible(Field field) {
        if (!Modifier.isPublic(field.getModifiers())) {
            field.setAccessible(true);
        }
    }

    private static Field getDeclaredField(Object object, String filedName) {
        for (Class<?> superClass = object.getClass(); superClass != Object.class; superClass = superClass
                .getSuperclass()) {
            try {
                return superClass.getDeclaredField(filedName);
            } catch (NoSuchFieldException e) {
                // Field 不在当前类定义, 继续向上转型
            }
        }
        return null;
    }

    public static void setFieldValue(Object object, String fieldName, Object value) {
        Field field = getDeclaredField(object, fieldName);

        if (field == null)
            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + object + "]");

        makeAccessible(field);

        try {
            field.set(object, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
