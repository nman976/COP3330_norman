// THIS IS A CLASS
public class Decrypter {
    // THIS IS A METHOD
    public String decrypt(String nums) {
        // Gets char value from string
        char char1 = nums.charAt(0);
        char char2 = nums.charAt(1);
        char char3 = nums.charAt(2);
        char char4 = nums.charAt(3);


        //turns char value to integer
        int nums1 = Character.getNumericValue(char1);
        int nums2 = Character.getNumericValue(char2);
        int nums3 = Character.getNumericValue(char3);
        int nums4 = Character.getNumericValue(char4);


        // Convert nums 1-4 to encrypted value
        if (nums1 > 6){
            nums1 = nums1 - 7;
        }
        else {
            nums1 = nums1 + 10 - 7;
        }

        if (nums2 > 6){
            nums2 = nums2 - 7;
        }
        else{
            nums2 = nums2 + 10 - 7;
        }
        if (nums3 > 6){
            nums3 = nums3 - 7;
        }
        else {
            nums3 = nums3 + 10 - 7;
        }
        if (nums4 > 6){
            nums4 = nums4 - 7;
        }
        else{
            nums4 = nums4 + 10 - 7;
        }


        // Switch values around using temp variable
        int temp = nums3;
        nums3 = nums1;
        nums1 = temp;
        temp = nums4;
        nums4 = nums2;
        nums2 = temp;

        // change number value to a string value, to finally put together as an encrypted function
        String str1 = Integer.toString(nums1);
        String str2 = Integer.toString(nums2);
        String str3 = Integer.toString(nums3);
        String str4 = Integer.toString(nums4);
        return str1 + str2 + str3 + str4;
    }
    public Decrypter(){
    }
}

