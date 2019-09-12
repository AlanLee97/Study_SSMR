package com.study.pojo;

/**
 * 搅拌机类
 */
public class Blender {
    /**
     * 混合方法
     * @param water 液体
     * @param fruit 水果
     * @param sugar 糖
     * @return 结果
     */
    public String mix(String water, String fruit, String sugar){
        String juice = "果汁原料：" + water + "," + fruit + "，" + sugar + "";
        return juice;
    }
}
