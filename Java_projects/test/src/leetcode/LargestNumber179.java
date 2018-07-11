package leetcode;

public class LargestNumber179 {
	public String largestNumber(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (compare(nums[i], nums[j]) <= 0) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < nums.length; i++) {
			sb.append(nums[i]);
		}

		return sb.toString().startsWith("0") ? "0" : sb.toString();
	}

	public int compare(int num1, int num2) {
		String result1 = String.valueOf(num1) + String.valueOf(num2);
		String result2 = String.valueOf(num1) + String.valueOf(num2);
		return result1.compareTo(result2);
	}

	public static void main(String[] args) {
		int[] nums = { 0, 0, 10, 9, 99 };
		System.out.println(new LargestNumber179().largestNumber(nums));
	}
}
