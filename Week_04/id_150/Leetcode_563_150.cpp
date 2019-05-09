class Solution {
public:
    int maxProfit(vector<int>& prices, int fee) {
        if(prices.size() == 1) 
            return 0;
        
        int buy = prices[0];
        int money = 0;
        for(int i = 1; i < prices.size(); i++) {
            if((prices[i] - buy) > fee) {
                cout << prices[i] << " " << buy <<  " " << endl;
                money += prices[i] - buy - fee;
                buy = prices[i] - fee;
            } else {
                if(prices[i] < buy) 
                    buy = prices[i];
            }
        }
        
        return money;
    }
};

