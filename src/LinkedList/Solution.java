package LinkedList;

/**
 * Created by robin on 16/9/1.
 */

class ListNode {
       int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
public class Solution {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return null;
        ListNode voidHead=new ListNode(0);
        voidHead.next=head;

        while(head.next!=null){
            //取
            ListNode tmp=head.next;
            head.next=head.next.next;
            //插
            tmp.next=voidHead.next;
            voidHead.next=tmp;
        }
        return voidHead.next;
    }


    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        return mergeK(lists,0,lists.length-1);
    }

    public ListNode mergeK(ListNode[] lists,int start,int end){
        if(start==end)
            return lists[start];
        if(start+1==end)
            return mergeTwo(lists[start],lists[end]);
        int mid=(start+end)/2;
        ListNode re1=mergeK(lists,start,mid);
        ListNode re2=mergeK(lists,mid+1,end);
        return mergeTwo(re1,re2);
    }

    public ListNode mergeTwo(ListNode first, ListNode second) {
        ListNode dummy = new ListNode(0), merged = dummy;
        while (first != null && second != null) {
            if (first.val <= second.val) {
                merged.next = first;
                merged = merged.next;
                first = first.next;
            } else {
                merged.next = second;
                merged = merged.next;
                second = second.next;
            }
        }
        if (first != null || second != null)
            merged.next = (first != null)? first :second;
        return dummy.next;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode voidHead=new ListNode(0);
        ListNode p=voidHead;
        int adder=0;
        int val;
        while(l1!=null && l2!=null){
            val=(l1.val+l2.val+adder)%10;
            adder=(l1.val+l2.val+adder)/10;
            ListNode node=new ListNode(val);
            p.next=node;
            p=p.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            val=(l1.val+adder)%10;
            adder=(l1.val+adder)/10;
            ListNode node=new ListNode(val);
            p.next=node;
            p=p.next;
            l1=l1.next;
        }
        while(l2!=null){
            val=(l2.val+adder)%10;
            adder=(l2.val+adder)/10;
            ListNode node=new ListNode(val);
            p.next=node;
            p=p.next;
            l2=l2.next;
        }
        if(adder==1){
            ListNode node=new ListNode(1);
            p.next=node;
        }
        return voidHead.next;
    }





}
