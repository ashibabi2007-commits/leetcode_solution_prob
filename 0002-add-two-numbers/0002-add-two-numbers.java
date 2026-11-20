class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode dummy=new ListNode(0);
      ListNode current=dummy;
      int carry=0;
      while(l1!=null||l2!=null||carry!=0)  {
        int x=0;
        int y=0;
        if(l1!=null){
            x=l1.val;
        }
        if(l2!=null){
            y=l2.val;
        }
        int sum=carry+x+y;
        carry=sum/10;
        current.next=new ListNode(sum%10);
        current=current.next;
        if(l1!=null){
            l1=l1.next;
        }
        if(l2!=null){
            l2=l2.next;
        }
      }
      return dummy.next;
    }
}