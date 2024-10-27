class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer>spiral = new ArrayList<>(matrix.length * matrix[0].length);
       int fc=0, lc=matrix[0].length-1, fr=0, lr=matrix.length-1;
       while(true){
         for(int i=fc; i<=lc;i++){
            spiral.add(matrix[fr][i]);
         }
         fr++;
         if(fr > lr) break;
         for(int i=fr; i<=lr;i++){
            spiral.add(matrix[i][lc]);
         }
         lc--;
         if(fc > lc) break;
         for(int i=lc;i>=fc;i--){
            spiral.add(matrix[lr][i]);
         }
         lr--;
         if(fr > lr) break;
         for(int i=lr ; i>=fr ;i--){
            spiral.add(matrix[i][fc]);
         }
         fc++;
         if(fc > lc)break;
       }
       return spiral;

    }
}