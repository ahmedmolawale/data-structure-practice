package ng.shoppi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Palindrome {


    Stack<Character> stack = new Stack<>();
    Queue<Character> queue = new LinkedList<>();


    public void pushCharacter(char a) {
        stack.push(a);
    }

    public void enqueueCharacter(char a) {
        queue.add(a);
    }

    public char popCharacter(char a) {
        return stack.pop();
    }

    public char dequeueCharacter() {
        return queue.remove();
    }

    public static void main(String[] args) {
        //07083804464
        // write your code here

//        Map<String, Integer> phoneBook = new HashMap<>();
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        for (int i = 0; i < n; i++) {
//            String name = in.next();
//            int phone = in.nextInt();
//            // Write code here
//            phoneBook.put(name, phone);
//        }
//        while (in.hasNext()) {
//            String s = in.next();
//            // Write code here
//            if (phoneBook.containsKey(s)){
//                System.out.println(s+"="+phoneBook.get(s));
//            }else{
//                System.out.println("Not Found");
//            }
//        }
//        in.close();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int result = factorial(n);
        System.out.println(result);
    }

    static int factorial(int n) {
        // Complete this function
        if (n <= 1)
            return 1;
        else
            return n * factorial(n - 1);
    }


}
