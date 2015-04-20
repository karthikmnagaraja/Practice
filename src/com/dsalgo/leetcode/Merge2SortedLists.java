package com.dsalgo.leetcode;

/**
 * Created by knagaraj on 4/20/2015.
 */
public class Merge2SortedLists {
    public ListNode partition(ListNode head, int x)
    {
        ListNode cur=head;
        ListNode right= new ListNode(0);

        ListNode left =new ListNode(0);
        ListNode temp1=right,temp2=left;
        while(cur!=null){
            if(cur.val<x){
                left.next=cur;
                left=left.next;
            }else{

                right.next=cur;
                right=right.next;
            }
            cur=cur.next;
        }

        right.next=null;
        left.next=temp1.next;

        return temp2.next;
    }
}
