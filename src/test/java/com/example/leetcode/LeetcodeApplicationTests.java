package com.example.leetcode;

import com.example.leetcode.tree.TreeNodeTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class LeetcodeApplicationTests {

    @Test
    void contextLoads() {
        TreeNodeTest test = new TreeNodeTest();
        final int i = test.pseudoPalindromicPaths();
        System.out.println("i = " + i);

        List<Integer> tem = new ArrayList<>();
        tem.add(1);
        tem.add(1);
        tem.add(2);
        System.out.println(test.canFormPalindrome(tem));
    }

}
