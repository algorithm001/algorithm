class Solution {
public:
    int maxProfit(vector<int>& prices) {
      if(prices.size()<=1) return 0;
      int days = prices.size(); 
      vector<vector<int>> sell(days,vector<int>(3,0));
      vector<vector<int>> buy(days,vector<int>(3,0));
      for(int i=0; i<=2; i++){
          sell[0][i] = 0;
          buy[0][i] = -prices[0];
      }
      for(int i=1; i<days; i++){
          for(int j=0; j<=2; j++){
              if(j==0)
                  sell[i][j] = sell[i-1][j];
              else
                  sell[i][j] = max(sell[i-1][j],buy[i-1][j-1]+prices[i]);
              buy[i][j] = max(buy[i-1][j],sell[i-1][j]-prices[i]);
          }
      }
      int result=sell[days-1][0];
      for(int i=1; i<=2; i++){
          if(result<sell[days-1][i])
              result =sell[days-1][i];
      }
      return result;
    }
};
