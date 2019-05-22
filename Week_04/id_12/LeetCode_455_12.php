class Solution {

    /**
     * @param Integer[] $g
     * @param Integer[] $s
     * @return Integer
     */
    function findContentChildren($g, $s) {
        
        asort($g);
        asort($s);
        $g = array_values($g);
        $s = array_values($s);
        $child = $cake = 0;
        while($child < count($g) && $cake < count($s)){
            if($g[$child] <= $s[$cake]){
                $child++;
                var_dump($child);
            }
            $cake++;
        }
        return $child;
    }
}
