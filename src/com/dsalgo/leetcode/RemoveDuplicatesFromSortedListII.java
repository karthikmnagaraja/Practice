package com.dsalgo.leetcode;

/**
 * Created by knagaraj on 4/20/2015.
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;

        ListNode help= new ListNode(0);
        help.next=head;
        ListNode cur= help;
        while(cur!=null){
            if(cur.next!=null&&cur.next.next!=null&&cur.next.val==cur.next.next.val){
                int val=cur.next.val;
                ListNode next=cur.next.next.next;
                while(next!=null&& next.val==val){
                    next=next.next;
                }
                cur.next=next;
            }else{
                cur=cur.next;
            }
        }
        return help.next;
    }
}
