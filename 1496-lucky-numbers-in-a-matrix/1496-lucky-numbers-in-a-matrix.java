class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer>list = new ArrayList<Integer>();
        for(int i =0; i<row; i++){
            int idx=0 ;
            int min = matrix[i][0];
            for(int j=1;j<col; j++){
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                    idx = j;
                }
            }
            int max = matrix[i][idx];
            int flag =0;
            for(int k =0; k< row; k++){
                if(matrix[k][idx] > max){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                list.add(max);
            }
        }
        return list;
    }
}