/**
 * Definition for a singly-linked list.
 * class ListNode {
 *     public $val = 0;
 *     public $next = null;
 *     function __construct($val) { $this->val = $val; }
 * }
 */

class Solution {
    public function deleteDuplicates($headNode) { 
        $current = $headNode;
        while($current->next !=null){
            if($current->val == $current->next->val ){
               $current->next = $current->next->next;
            }else{
                $current = $current->next;
            }
        }    
        return $headNode;
    }
}
