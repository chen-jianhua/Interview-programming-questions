package org.example.over;

import java.util.*;

public class zhihu {
    public static List<Integer> mergeList;

    public static void main(String[] args) {
    /*
    将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

    输入：l1 = [1,2,4], l2 = [1,3,4]
    输出：[1,1,2,3,4,4]
    示例 2：

    输入：l1 = [], l2 = []
    输出：[]
    示例 3：

    输入：l1 = [], l2 = [0]
    输出：[0]

    提示：

    两个链表的节点数目范围是 [0, 50]
    -100 <= Node.val <= 100
    l1 和 l2 均按 非递减顺序 排列
     */
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    //TODO：考虑方法的副作用，不直接在l1或者l2上修改，而是新建一个链表对象将其返回
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(); // 创建一个虚拟头节点
        ListNode current = dummy; // 用于迭代的指针

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // 将剩余部分直接连接到合并后的链表
//        if (l1 != null) {
//            current.next = l1;
//        } else {
//            current.next = l2;
//        }
        //if-else 优化
        current.next = l1 != null ? l1 : l2;


        return dummy.next; // 返回合并后的链表，不包括虚拟头节点
    }




 /*
    以下是面试时紧张的错误解法
    public static List<Integer> mergelist(List<Integer> l1, List<Integer> l2) {
        if (l1.size() == 0 && l2.size() == 0) {
            return new ArrayList<Integer>();
        } else if (l1.size() == 0) {
            return l2;
        } else if (l2.size() == 0) {
            return l1;
        }
        int l1_point = 0;
        int l2_point = 0;
        while (l1_point < l1.size() && l2_point < l2.size()) {
            if (l1.get(l1_point) <= l2.get(l2_point)) {
                mergeList.add(l1.get(l1_point));
                l1_point++;
            } else {
                mergeList.add(l2.get(l2_point));
                l2_point++;
            }
        }
        if (l1.size() == l2.size()) {
            return mergeList;
        } else if (l1.size() > l2.size()) {
            List<Integer> list = lastList(l1, l1_point);
        } else {
            List<Integer> list = lastList(l2, l2_point);
        }

        return mergeList;
    }

    private static List<Integer> lastList(List<Integer> l1, int l1_point) {
        return l1;
    }
*/

}

//定义单链表.
class ListNode {
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

