/**
 * @param {string} S
 * @return {string[]}
 * https://leetcode.com/problems/letter-case-permutation/
 */
var letterCasePermutation = function(S) {
  const strArray=S.toLocaleLowerCase().split('');
  const ACharCode='A'.charCodeAt()
  const charactorCount=strArray
    .filter(item=>item.charCodeAt()>=ACharCode)
    .length;
  
  const arr=Array.from({length:Math.pow(2,charactorCount)},(_v,k)=>k)
    .map(digit=>{
      const digitArray=digit.toString(2).split('').reverse();//转二进制字符串。
      let charactorIndex=-1;
      return strArray.map(item=>{
        //数字
        if(item.charCodeAt()<ACharCode){
          return item;
        }
        charactorIndex++;
        if(digitArray[charactorIndex]==='1'){
          return item.toLocaleUpperCase()
        }
        return item;
      }).join('');
    })

  //不是必须的
  arr.sort((a,b)=>a>b?-1:1);
  
  return arr;
  
    
};