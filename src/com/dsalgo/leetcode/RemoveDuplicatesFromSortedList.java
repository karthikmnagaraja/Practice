package com.dsalgo.leetcode;


/**
 * Created by knagaraj on 4/20/2015.
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode node=head;
        while(node!=null && node.next!=null){
            if(node.val==node.next.val){
                node.next=node.next.next;
            }else{
                node=node.next;
            }
        }
        return head;
    }
}
