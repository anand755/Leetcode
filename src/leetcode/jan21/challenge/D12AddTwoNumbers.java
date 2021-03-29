package leetcode.jan21.challenge;

import java.io.*;
import java.util.*;

class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class D12AddTwoNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int[] arrL1 = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int[] arrL2 = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();


            ListNode headL1 = prepareNodeList(arrL1);
            ListNode headL2 = prepareNodeList(arrL2);

            System.out.println("Completed");
            ListNode headNode = addTwoNumbers(headL1, headL2);
            while (headNode != null) {
                System.out.print(headNode.val + " ");
                headNode = headNode.next;
            }
            System.out.println();
        }

    }

    private static ListNode prepareNodeList(int[] arrL) {
        ListNode node = new ListNode(arrL[0]);
        ListNode headTempNode = node;

        for (int i = 1; i < arrL.length; i++) {
            node.next = new ListNode(arrL[i]);
            node = node.next;
        }
        return headTempNode;
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*ListNode revL1 = reverseLinkedList(l1);
        ListNode revL2 = reverseLinkedList(l2);*/

        ListNode revL1 = l1;
        ListNode revL2 = l2;

        ListNode sumL = new ListNode();
        ListNode headOfSum = sumL;

        int carry = 0;
        while (revL1 != null && revL2 != null) {
            int i = revL1.val;
            int j = revL2.val;

            int t = i + j + carry;
            carry = t / 10;
            int s = t % 10;

            sumL.next = new ListNode(s);
            sumL = sumL.next;

            revL1 = revL1.next;
            revL2 = revL2.next;
        }

        while (revL1 != null) {
            int i = revL1.val;
            int t = i + carry;
            carry = t / 10;
            int s = t % 10;
            sumL.next = new ListNode(s);
            sumL = sumL.next;
            revL1 = revL1.next;
        }

        while (revL2 != null) {
            int j = revL2.val;
            int t = j + carry;
            carry = t / 10;
            int s = t % 10;
            sumL.next = new ListNode(s);
            sumL = sumL.next;
            revL2 = revL2.next;
        }
        if (carry != 0) {
            sumL.next = new ListNode(carry);
        }

        //ListNode headOfSum = reverseLinkedList(tempHeadOfSum.next);

        return headOfSum.next;
    }

    private static ListNode reverseLinkedList(ListNode node) {
        Stack<Integer> nodeStack = new Stack<>();

        ListNode revListNode;
        ListNode headNode;

        while (node != null) {
            nodeStack.push(node.val);
            node = node.next;
        }
        revListNode = new ListNode(nodeStack.pop());
        headNode = revListNode;

        while (!nodeStack.isEmpty()) {
            revListNode.next = new ListNode(nodeStack.pop());
            revListNode = revListNode.next;
        }
        return headNode;
    }
}
