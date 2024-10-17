package cn.xf._04Collection_Map.collection.list;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    ListNode head;
    ListNode tail;
    int size;

    public ListNode() {
        head = null;
        tail = null;
        size = 0;
    }
}
