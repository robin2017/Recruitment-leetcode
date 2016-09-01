package sword;

/**
 * Created by robin on 16/9/1.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public static void main(String[] args){
        ListNode h=new ListNode(1);

        ListNode h2=new ListNode(2);
        ListNode h3=new ListNode(3);
        ListNode h4=new ListNode(4);
    h.next=h2;h2.next=h3;h3.next=h4;


        new Solution().printList(h);

    }
    public void printList(ListNode node){
        if(node==null)
            return;
        printList(node.next);
        System.out.println(node.val);
    }
}
