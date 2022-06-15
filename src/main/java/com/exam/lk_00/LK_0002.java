package com.exam.lk_00;

public class LK_0002 {

    public static void main(String[] args) {
        LK_0002 LK_0002 = new LK_0002();

        ListNode l1 = LK_0002.get1();
        ListNode l2 = LK_0002.get2();
        ListNode listNode = LK_0002.addTwoNumbers(l1, l2);

        System.out.println(listNode);
    }



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode();
        resultNode.val = 0;
        ListNode listNode = resultNode;
        do {
            int temp;
            if (l1 != null && l2 != null) {
                temp = l1.val + l2.val;
            } else if (l1 != null) {
                temp = l1.val;
            } else {
                temp = l2.val;
            }
            temp = temp + listNode.val;
            int a = temp % 10;
            int b = temp / 10;
            listNode.val = a;
            if ((l1 != null && l1.next != null) || (l2 != null && l2.next != null) || b > 0) {
                ListNode tempNode = new ListNode();
                tempNode.val = b;
                listNode.next = tempNode;
                listNode = tempNode;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        } while (l1 != null || l2 != null);
        return resultNode;
    }

    public ListNode get1() {
        ListNode l1 = new ListNode();
        l1.val = 5;
        ListNode l2 = new ListNode();
        l2.val = 6;
        ListNode l3 = new ListNode();
        l3.val = 4;
        l1.next = l2;
        l2.next = l3;
        return l1;
    }

    public ListNode get2() {
        ListNode l1 = new ListNode();
        l1.val = 2;
        ListNode l2 = new ListNode();
        l2.val = 4;
        ListNode l3 = new ListNode();
        l3.val = 3;
        l1.next = l2;
        l2.next = l3;
        return l1;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}


