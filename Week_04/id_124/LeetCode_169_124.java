import java.util.List;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int cnt = 1;
        int result = nums[0];
        for (int i = 1;  i < nums.length ; i++){
            if (nums[i] == result){
                cnt ++;
                if (cnt > nums.length /2){
                    return result;
                }
            }else {
                cnt --;
            }
            if (cnt <= 0 ){
                result = nums[i];
                cnt = 1;
            }
        }

        return result;
    }

    public List<Integer> majorityElement2(int[] nums) {

        return null;
    }

    public static void main(String[] args) {

    }
}
