package com.algorithm.other;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 取出BENE-BENB的值，大于等于4个一组做计算，小于忽略
 */
public class Test {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"BENE");
        map.put(2,"2222");
        map.put(3,"BENB");
        map.put(4,"BENE");
        map.put(5,"5555");
        map.put(6,"6666");
        map.put(7,"7777");
        map.put(8,"8888");
        map.put(9,"BENB");
        map.put(10,"101010");
        map.put(11,"BENE");
        map.put(12,"121212");
        map.put(13,"131313");
        map.put(14,"141414");
        map.put(15,"151515");
        map.put(16,"BENB");
        map.put(17,"BENB");
        map.put(18,"BENE");

        int controlNum = 0;
        List<Integer> rowsNumList = new ArrayList<>();
        for (int i = 0; i < map.size(); i = controlNum) {
            if ("BENE".equals(map.get(i))) {
                for (int j = i; j < map.size(); j++) {
                    rowsNumList.add(j);
                    if ("BENB".equals(map.get(j))) {
                        if (rowsNumList.size() < 4) {
                            rowsNumList.clear();
                        }
                        controlNum = j;
                        break;
                    }
                }
                //引入计算
                if (CollectionUtils.isNotEmpty(rowsNumList) && map.get(rowsNumList.get(rowsNumList.size() - 1)).equals("BENB")) {
                    System.out.println("开始计算");
                    for (Integer a : rowsNumList) {
                        System.out.println(map.get(a));
                    }
                    System.out.println("结束计算");
                    rowsNumList.clear();
                }
            }
            controlNum ++;
        }
    }
}
