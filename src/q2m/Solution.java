package q2m;

public class Solution {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode curr = result;
		int yu = 0;
		for (;;) {
			if (l1 != null || l2 != null) {
				int x = (l1 != null) ? l1.val : 0;
				int y = (l2 != null) ? l2.val : 0;
				curr.next = new ListNode((x + y + yu) % 10);
				curr = curr.next;
				yu = (x + y+ yu) / 10;
				if (l1 != null)
					l1 = l1.next;
				if (l2 != null)
					l2 = l2.next;
			} else {

				break;
			}
		}
		if (yu > 0) {
			curr.next = new ListNode(yu);
			curr = curr.next;
		}
		return result.next;

	}

	public static void main(String[] args) {
		Solution su = new Solution();
		ListNode currentL1 = new ListNode(1);
//		currentL1.next = new ListNode(4);
//		currentL1.next.next = new ListNode(3);
//		currentL1.next.next.next = new ListNode(6);
		ListNode currentL2 = new ListNode(9);
		currentL2.next = new ListNode(9);
//		currentL2.next.next = new ListNode(4);
		ListNode result = su.addTwoNumbers(currentL1, currentL2);
		System.out.println(result);

	}
}
