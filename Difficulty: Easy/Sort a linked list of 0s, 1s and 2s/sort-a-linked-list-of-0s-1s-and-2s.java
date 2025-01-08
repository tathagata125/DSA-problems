//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


// } Driver Code Ends
// User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        Node curr = head;
        Node dummy0 = new Node(-1);
        Node tail0 = dummy0;
        Node dummy1 = new Node(-1);
        Node tail1 = dummy1;
        tail1.next = null;
        Node dummy2 = new Node(-1);
        Node tail2 = dummy2;
        while(curr != null){
            if(curr.data == 0){
                tail0.next = curr;
                tail0=tail0.next;
            }
            else if(curr.data == 1){
                tail1.next = curr;
                tail1 = tail1.next; 
            }
            else{
                tail2.next = curr;
                tail2 = tail2.next;
            }
            curr = curr.next;
        }
        tail0.next = dummy1.next != null ? dummy1.next : dummy2.next;
        tail1.next = dummy2.next;
        tail2.next = null;
        return dummy0.next;
        
    }
}


//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            head = new Solution().segregate(head);
            printList(head);
        }
    }
}
// } Driver Code Ends