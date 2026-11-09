class Solution {
    public ListNode sortList(ListNode head) {
        if (head==null || head.next== null){
            return head ;
        }
        ListNode prev=null;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next != null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        return merge(sortList(head),sortList(slow));
    }
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode d=new ListNode(0);
        ListNode c=d;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                c.next=l1;
                l1=l1.next;
            }
            else{
                c.next=l2;
                l2=l2.next;
            }
            c=c.next;
        }
        c.next=l1!=null ?l1:l2;
        return d.next;
    }
}