package com.dsalgo.leetcode;

/**
 * Created by knagaraj on 6/2/2015.
 */
public class SwapNodes {
    public ListNode swapPairs(ListNode head) {
        ListNode helper= new ListNode(0);
        helper.next=head;
        ListNode n1=helper,n2=head;

        while(n2.next!=null||n2!=null){
            ListNode temp=n2.next.next;
            n2.next.next=n1.next;
            n1.next=n2.next;
            n2.next=temp;
            n2=n1;
            n1=n2.next;

        }
        return helper.next;
    }
}
