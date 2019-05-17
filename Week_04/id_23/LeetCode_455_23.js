 /**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 * https://leetcode.com/problems/assign-cookies/
 */
var findContentChildren = function(g, s) {
  let sum=0;
  g.sort((a,b)=>a<b?-1:1);
  s.sort((a,b)=>a<b?-1:1);
  
  
  let i=0;
  let j=0;
  while(i<g.length&&j<s.length){
      if(s[j]>=g[i]){
          j++;
          i++;
          sum++;
      }else{
          j++;
      }
  }
  return sum;
  
};