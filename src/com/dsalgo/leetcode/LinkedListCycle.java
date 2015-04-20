package com.dsalgo.leetcode;

/**
 * Created by knagaraj on 4/20/2015.
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null) return false;

        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) return true;
        }

        return false;

    }
}
