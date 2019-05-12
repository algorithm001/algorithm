import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<String> letterCasePermutation(String S) {
		
	    if(null == S || S.length() == 0 ){
	    	return null;
	    }
	    List<String> result = new ArrayList<>(2048);
	    result.add( S );
	    char ss[] = S.toCharArray();
	    int lent = ss.length;
	    for(int in = 0; in < lent; in++){
	    	if(('A' <= ss[in] && ss[in] <= 'Z') || ( 'a' <= ss[in] && ss[in] <= 'z' ) ){
	    		int len = result.size();
	    		for(int index = 0 ; index < len; index ++){
	    			String resStr = new String (result.get(index));
	    			char te[] = resStr.toCharArray();
	    			te[in] = switchChar(te[in]);
	    			result.add( new String(te) );
	    		}
	    	}
	    }
		
		return result;
	}

	public char switchChar(char c){
	    if(c>='A' &&c<='Z'){
	    	c = (char) (c + 32);
	        return c;
	    }
	    else if(c>='a' &&c<='z'){
	    	c = (char) (c - 32);
	        return c;
	    }else{
	    	return c;
	    }
	}
}