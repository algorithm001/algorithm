Method 1:
class Solution {
public:
    vector<int> diffWaysToCompute(string input) {
        vector<int> res;
        
        res = dfs(input, 0, input.size());
        
        return res;
    }
    
    
    vector<int> dfs(string input, int begin, int end) {
        vector<int> res;
        bool sign = false;
        for(int i = begin; i < end; i++) {
            if((input[i] == '+') || (input[i] == '-') || (input[i] == '*')) {
                sign = true;
                break;
            }
        }
        if(!sign) {
            int tmp = 0;
            string validation = "";
            for(int i = begin; i < end; i++) {
                tmp = tmp * 10 + (input[i] - '0');
                validation += input[i];
            }
            res.push_back(tmp);
            return res;
        }
        for(int i = begin; i < end; i++) {
            if((input[i] == '+') || (input[i] == '-') || (input[i] == '*')) {
                vector<int> left = dfs(input, begin, i);
                vector<int> right = dfs(input, i + 1, end);
                //cout << "left:" << left << " right:" << right << endl;
                if(input[i] == '+'){
                    for(int le : left) {
                        for(int ri : right) {
                            res.push_back(le + ri);
                        }
                    }
                }
                else if(input[i] == '-') {
                    for(int le : left) {
                        for(int ri : right) {
                            res.push_back(le - ri);
                        }
                    }
                }
                else{
                    for(int le : left) {
                        for(int ri : right) {
                            res.push_back(le * ri);
                        }
                    }
                }
            } 
        }
        
        return res;
    }
};

// 2 * 3 - 4 * 5
// 2 * 3 - 4    * 5

// (2 * 3) - 4
// 2 * (3 - 4)

// (2 * 3 - 4) * 5
//  ((2 * 3) - 4) * 5 = 10
//  (2 * (3 - 4)) * 5 = -10
// 2 * (3 - 4 * 5)
//   2 * ((3 - 4) * 5) = -10
//   2 * (3 - (4 * 5)) = -34
// 2 * 3 - (4 * 5) = -14

// 2 * 3 - 4 * 5  * 6

// (2 * 3 - 4 * 5) * 6
// 2 * (3 - 4 * 5 * 6)
// 2 * 3 - (4 * 5 * 6)
// 2 * 3 - 4 * (5 * 6)

Method 2:

class Solution {
	
public:
	bool isoperator(char c){
		if(c == '+' || c == '*' || c =='-')
			return true;
		return false;
	}
	
	vector<int> diffWaysToCompute(string input) {
  		vector<int> ans;
		if(input.size() == 0){
			return ans;
		} else{
			for(int i = 0; i < input.length(); i++){
				if(isoperator(input[i])){
					vector<int> l = diffWaysToCompute(input.substr(0,i));
					vector<int> r = diffWaysToCompute(input.substr(i+1));
					
					for(int j = 0; j < l.size(); j++){
						for(int k = 0; k < r.size(); k++){
							int a = l[j];
							int b = r[k];
							switch(input[i]){
								case '+':{
									ans.push_back(a+b);
									break;
								} 
								case '-':{
									ans.push_back(a-b);
									break;
								}
								case '*':{
									ans.push_back(a*b);
									break;
								}
							}
						}
					}
				}
			}
			if(ans.empty()){
				ans.push_back(atoi(input.c_str()));
			}
			return ans;
		}
    }
    
};
