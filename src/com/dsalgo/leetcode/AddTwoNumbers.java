package com.dsalgo.leetcode;

/**
 * Created by knagaraj on 4/20/2015.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head=new ListNode(0);
        ListNode p=head;
        int carry=0;
        while(l1!=null||l2!=null){
            int val1=0,val2=0;
            if(l1!=null){
                val1=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                val2=l2.val;
                l2=l2.next;
            }
            ListNode node=new ListNode((val1+val2+carry)%10);
            carry=(val1+val2+carry)/10;
            p.next=node;
            p=p.next;

        }

        if(carry>0){
            ListNode node=new ListNode(carry);
            p.next=node;

        }

        return head.next;


    }
}
