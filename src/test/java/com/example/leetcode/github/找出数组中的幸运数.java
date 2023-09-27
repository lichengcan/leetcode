package com.example.leetcode.github;

import java.util.*;

/**
 * @author: lichengcan
 * @date: 2023-09-26 18:29
 * @description
 **/
public class 找出数组中的幸运数 {

    public static void main(String[] args) {

        找出数组中的幸运数 test= new 找出数组中的幸运数();
        int[] ints = new int[]{2,2,3,4};
        int[] ints2 = new int[]{1,2,2,3,3,3};

        System.out.println(test.findLucky(ints));
        System.out.println(test.findLucky(ints2));
    }

    public int findLucky(int[] arr) {
        Map<Integer, Integer> res = new HashMap();
        for(int i = 0;i<arr.length;i++ ){
            if(res.containsKey(arr[i])){
                final Integer val = res.get(arr[i]);
                res.put(arr[i],val+1);
            }else {
                res.put(arr[i],1);
            }
        }
        List<Integer> list = new ArrayList();
        for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
            if (entry.getKey()==entry.getValue()) {
                list.add(entry.getKey());
            }
        }
        if (list.isEmpty()) {
            return -1;
        }else {
            return list.get(list.size()-1);
        }
    }


    /**
     * 错了
     * @param arr
     * @return
     */
    public int findLucky1(int[] arr) {
        Map<Integer, Integer> res = new HashMap();
        for(int i = 0;i<arr.length;i++ ){
            if(res.containsKey(arr[i])){
                final Integer val = res.get(arr[i]);
                res.put(arr[i],val+1);
            }else {
                res.put(arr[i],1);
            }
        }
        List<Map.Entry<Integer, Integer>> entries1 = new ArrayList<>(res.entrySet());
        Collections.sort(entries1, (o1, o2) -> o2.getValue()-o1.getValue());
        return entries1.get(0).getKey();
    }

}
