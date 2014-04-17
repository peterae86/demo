package me.peterae86.demo.util;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.google.common.collect.Lists;


public class StringToListUtil {
    public static List<Long> toLongList(String arrayString){
        List<Long> list=Lists.newArrayList();
        if(StringUtils.isBlank(arrayString)){
            return list;
        }
        String[] strList=StringUtils.split(arrayString, ",");
        for(String str:strList){
            list.add(NumberUtils.toLong(str));
        }
        return list;
    }
    public static List<String> toStringList(String arrayString){
        List<String> list=Lists.newArrayList();
        if(StringUtils.isBlank(arrayString)){
            return list;
        }
        String[] strList=StringUtils.split(arrayString, ",");
        return Lists.newArrayList(strList);
    }
}
