class Solution {
public:
    bool checkValid(vector<vector<int>>& matrix) {
        int n = matrix.size();

        for(int i = 0; i < n; i++)
        {
            vector<int> num(n+1, 0);
            for(int j = 0; j < n; j++)
            {
                num[matrix[i][j]] += 1;
            }

            for(int k = 1; k <= n; k++)
            {
                if(num[k] > 1 || num[k] == 0)
                    return false;
            }
        }

        for(int i = 0; i < n; i++)
        {
            vector<int> num(n+1, 0);
            for(int j = 0; j < n; j++)
            {
                num[matrix[j][i]] += 1;
            }

            for(int k = 1; k <= n; k++)
            {
                if(num[k] > 1 || num[k] == 0)
                    return false;
            }
        }
        return true;
    }
};