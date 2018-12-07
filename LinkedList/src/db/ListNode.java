package ds;

public class ListNode {
	public int key;
	public ListNode prev;
	public ListNode next;
	
	public ListNode () {
		prev = next = null;
	}
	
	public ListNode (int _key) {
		key = _key;
		prev = next = null;
	}
}