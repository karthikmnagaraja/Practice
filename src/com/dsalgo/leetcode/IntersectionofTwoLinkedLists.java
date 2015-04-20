package com.dsalgo.leetcode;

/**
 * Created by knagaraj on 4/20/2015.
 */
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode temp1=headA;
        ListNode temp2=headB;
        int countA=countLength(temp1);
        int countB=countLength(temp2);


        if(countA>countB){
            while(countA!=countB){

                countA--;
                headA=headA.next;

            }
        }else if(countA<countB){
            while(countA!=countB){

                countB--;
                headB=headB.next;

            }
        }

        while(headA!=null&&headB!=null){
            if(headA==headB) return headA;
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }

    private static int countLength(ListNode node){
        int count=0;
        while(node!=null){
            node=node.next;
            count++;
        }
        return count;
    }
}
