//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        sc.nextLine();        // Consume the newline character

        while (t-- > 0) {
            String input = sc.nextLine();

            // Replace ][ with ],[
            input = input.replace("][", "],[");

            ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
            String[] rows = input.split("],\\s*\\[");

            for (String row : rows) {
                row = row.replaceAll("[\\[\\]]", ""); // Remove any surrounding brackets
                ArrayList<Integer> intRow = new ArrayList<>();
                for (String num : row.split(",")) {
                    intRow.add(Integer.parseInt(num.trim()));
                }
                mat.add(intRow);
            }

            Solution obj = new Solution();
            ArrayList<String> result = obj.findPath(mat);

            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (String res : result) {
                    System.out.print(res + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static Set<String>paths;
    public void getAllPaths(ArrayList<ArrayList<Integer>> mat,int row, int col, 
    String path, boolean[][]visited){
        if(col < 0 || row < 0 || col == mat.get(0).size() || row == mat.size()){
            return;
        }
        if(visited[row][col] == true || mat.get(row).get(col) == 0){
            return ;
        }
        if(row == mat.size() - 1 && col == mat.get(0).size() - 1){
            paths.add(path);
            return;
        }
        visited[row][col] = true;
        getAllPaths(mat, row + 1, col, path + "D",visited);
        getAllPaths(mat,row,col + 1,path+ "R",visited);
        getAllPaths(mat,row-1,col,path+"U",visited);
        getAllPaths(mat,row,col-1,path + "L",visited);
        visited[row][col] = false;
    }
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        paths = new HashSet<>();
        int n = mat.size();
        int m = mat.get(0).size();
        boolean[][] visited = new boolean[n][m];
        getAllPaths(mat,0,0,"",visited);
        ArrayList<String> pathset = new ArrayList<>(paths);
        Collections.sort(pathset);
        return pathset;
    }
}