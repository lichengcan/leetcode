package com.example.leetcode.hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: lichengcan
 * @date: 2023-09-11 18:30
 * @description
 **/
public class 随机数 {


        public static List<Integer> selectRandomIds(List<Integer> idList, int num) {
            if (idList == null || idList.isEmpty() || num <= 0) {
                throw new IllegalArgumentException("Invalid input");
            }

            if (num >= idList.size()) {
                return new ArrayList<>(idList);
                // 返回所有ID的副本
            }

            Random random = new Random();
            List<Integer> selectedIds = new ArrayList<>();

            while (selectedIds.size() < num) {
                int randomIndex = random.nextInt(idList.size());
                int selectedId = idList.get(randomIndex);

                if (!selectedIds.contains(selectedId)) {
                    selectedIds.add(selectedId);
                }
            }

            return selectedIds;
        }

        public static void main(String[] args) {
            List<Integer> idList = new ArrayList<>();
            idList.add(1);
            idList.add(2);
            idList.add(3);
            idList.add(4);
            idList.add(5);

            int num = 3;

            List<Integer> selectedIds = selectRandomIds(idList, num);
               System.out.println("Randomly selected IDs:");
            for (Integer id : selectedIds) {
                System.out.println(id);
            }
        }

}
