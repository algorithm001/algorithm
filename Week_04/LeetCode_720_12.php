class Solution {

    /**
     * @param String[] $words
     * @return String
     */
    function longestWord($words) {
        
        asort($words);
        $arrTem = array();
        $res = '';
        foreach($words as $key=>$val){
            $strLen = strlen($val);
            $strTem = substr($val,0,$strLen-1);
            if($strLen == 1 || in_array($strTem,$arrTem)){
                $arrTem[$key] = $val;
                $res =  $strLen > strlen($res) ? $val : $res;
            }
        }
        return $res;

    }

}
