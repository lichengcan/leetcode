package com.example.leetcode.mianshi;

import java.util.*;

/**
 * @author: lichengcan
 * @date: 2023-10-10 15:19
 * @description
 **/
public class RandomizedSet {
    //实现RandomizedSet 类：
    //
    //RandomizedSet() 初始化 RandomizedSet 对象
    //bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
    //bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
    //int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。

    //1.声明一个数组、一个hashmap、一个随机数
    List<Integer> list;
    Map<Integer, Integer> map;
    Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    //数组存val数据
    //map key存val，value存数组下标
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        //获取数组下标
        final Integer index = map.get(val);
        //处理数组
        int listSize = list.size() - 1;
        Integer temp = list.get(listSize);//最后一个元素
        list.set(index, temp);//替换删除的元素
        list.remove(listSize);//删除最后的元素
        //处理map
        map.put(temp, index);//替换删除的元素，把最后一个元素的下标更新
        map.remove(val);//删除元素
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(list.size());//获取一个范围为[0,nums.size())的随机整数
        return list.get(randomIndex);
    }
}
