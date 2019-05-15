class Solution {
public:
      int maxProfit(int k, vector<int>& prices) {
      if(prices.size()<=1) return 0;
      int days = prices.size();
      if(k>days>>1){
          k = days>>1;
          int sum=0;
          for(int i=1; i<days; i++){
              if(prices[i]>prices[i-1])
                  sum += prices[i]-prices[i-1];
          }
          return sum;
      } 
      vector<vector<int>> sell(days,vector<int>(k+1,0));
      vector<vector<int>> buy(days,vector<int>(k+1,0));
      for(int i=0; i<=k; i++){
          sell[0][i] = 0;
          buy[0][i] = -prices[0];
      }
      /*for(int i=0; i<days; i++){
          sell[i][0] = 0;
          buy[i][0] = -prices[0];
      }*/
      for(int i=1; i<days; i++){
          for(int j=0; j<=k; j++){
              if(j==0)
                  sell[i][j] = sell[i-1][j];
              else
                  sell[i][j] = max(sell[i-1][j],buy[i-1][j-1]+prices[i]);
              buy[i][j] = max(buy[i-1][j],sell[i-1][j]-prices[i]);
          }
      }
      int result=sell[days-1][0];
      for(int i=1; i<=k; i++){
          if(result<sell[days-1][i])
              result =sell[days-1][i];
      }
      return result;
  }
};
