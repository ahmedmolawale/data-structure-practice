package ng.shoppi;

import java.util.Stack;

public class LinkedListPractice {

    private Node head;
    private Stack<Integer> forPalindrome;

    public LinkedListPractice() {
        forPalindrome = new Stack<>();
        head = null;
    }

    public void insert(int data) {
        Node a = new Node(data);
        if (head == null) {
            head = a;
            return;
        }
        a.next = head;
        head = a;
    }

    public Node returnMElement(int m) throws IllegalArgumentException {
        if (head == null || m < 0)
            throw new IllegalArgumentException("Invalid input");
        //get the number of elements therein
        Node temp = head;
        int n = 0;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        //check that the element can be obtained
        if (!(n >= m + 1)) {
            return null;
        }
        temp = head;
        int j = n - m - 1;
        for (int i = 0; i < j; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public Node printMElementUsingTwoPointer(int m) {
        Node fast = initFastPointer(m);
        if (fast == null)
            return null;
        Node slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    private Node initFastPointer(int m) {
        Node temp = head;
        try {
            for (int i = 0; i < m; i++) {
                temp = temp.next;
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Invalid input for m");
        }
        return temp;
    }

    public boolean checkPalindrome() {
        if (head == null) return false;
        if (head.next == null) return true;
        Node temp = head;
        while (temp != null) {
            forPalindrome.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (!forPalindrome.empty()) {
            if (temp.data != forPalindrome.pop()) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    public Node reverse() {
        if (head == null) return null;
        Node prev = null;
        Node current = head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public void printInReverse(Node head) {
        if (head == null) return;
        printInReverse(head.next);
        System.out.print(head.data + " ");
    }

    public void printAll() {
        if (head == null)
            return;
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedListPractice linkedListPractice = new LinkedListPractice();
        linkedListPractice.insert(5);
        linkedListPractice.insert(6);
        linkedListPractice.insert(5);
        linkedListPractice.insert(0);
//        linkedListPractice.insert(2);
//        linkedListPractice.insert(1);
        linkedListPractice.printAll();
        //linkedListPractice.head = linkedListPractice.reverse();
        System.out.println();
        linkedListPractice.printInReverse(linkedListPractice.head);
        System.out.println();
        System.out.println("M element from last " + linkedListPractice.returnMElement(1).data);
        System.out.println("M element from last 2 is " + linkedListPractice.printMElementUsingTwoPointer(1).data);
        System.out.println("Is it palindrome? " + linkedListPractice.checkPalindrome());

    }

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
