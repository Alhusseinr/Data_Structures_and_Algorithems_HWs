package db;

import java.util.*;

public class LinkedList {

    public ListNode head;

    public LinkedList () {
        head = null;
    }

    public ListNode search (int k) {
        ListNode x = head;
        while (x != null && x.key != k){
            x = x.next;
        }
        return x;
    }

    public void insert (int i) {
        ListNode x = head;

        if(head != null){
            head.prev = x;
        }
        head = x;
        x.prev = null;
    }

    public void delete (ListNode x) {
        if(x.prev != null){
            x.prev.next = x.next;
        }
        else{
            head = x.next;
        }
        if(x.next != null){
            x.next.prev = x.prev;
        }
    }

    public String toString () {
        String str;
        ListNode n;

        str = "[";
        n = this.head;
        while (n != null) {
            str += n.key + ",";
            n = n.next;
        }

        str += "]";
        return str;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LinkedList l;

        l = new LinkedList();
        for (int i = 1; i < 5; i++)
            l.insert(i);
        System.out.println(l.toString());
        for (int i = 0; i < 2; i++)
            l.delete(l.head.next);
        System.out.println(l.toString());
    }

}