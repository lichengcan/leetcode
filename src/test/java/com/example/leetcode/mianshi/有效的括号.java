package com.example.leetcode.mianshi;

import java.util.Stack;

/**
 * @author: lichengcan
 * @date: 2023-09-22 11:22
 * @description 有效的括号
 **/
public class 有效的括号 {
    //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
    //
    //有效字符串需满足：
    //
    //左括号必须用相同类型的右括号闭合。
    //左括号必须以正确的顺序闭合。
    //每个右括号都有一个对应的相同类型的左括号。

    public boolean isValid(String s) {
        // 判空
        if (s.isEmpty()) return true;
        // 新建一个栈
        Stack<Character> stack = new Stack<>();
        //当遇到( { [时新增) } ]到栈里，
        for (char c : s.toCharArray()) {
            if (c=='(') {
                stack.push(')');
            }else if(c=='{'){
                stack.push('}');
            }else if(c=='['){
                stack.push(']');
                //判断非( { [ 时 栈顶元素是否等于当前，
            }else if(stack.isEmpty()||c!=stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
