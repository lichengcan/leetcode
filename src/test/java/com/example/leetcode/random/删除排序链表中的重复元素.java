package com.example.leetcode.random;

/**
 * @author: lichengcan
 * @date: 2023-09-13 13:49
 * @description
 **/
public class 删除排序链表中的重复元素 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        //head头节点 只是一个节点而已
        //cur是当前检查的节点
        //修改cur里面的指针指向，head也会随着改变，因为他们公用同一个指针
        //如果修改cur里面的值，head也会随之改变，因为也是指针指向某个节点的值
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }else {
                //遍历
                cur=cur.next;
            }
        }

        return head;
    }
}
