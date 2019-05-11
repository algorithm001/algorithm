class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function majorityElement($nums) {
        $numsTem = $maxArr = array();
        foreach($nums as $key=>$val){
            if(in_array($val,$numsTem)){
                $maxArr[$val]++;
            }else{
                $numsTem[$val] = $val;
                $maxArr[$val] = 1;
            }
        }
        return array_search(max($maxArr),$maxArr);    
    }
}
