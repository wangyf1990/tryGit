package app;

public class Maxsubarray {
	
	public static int bruteForce(int[] a) {
		int max = 0;
		for(int i=0 ; i<a.length ; i++) {
			for(int j=i+1 ; j<a.length ; j++) {
				int tempSum = 0;
				for(int k=i ; k<=j ; k++) {
					tempSum += a[k];
				}
				if (tempSum > max) max = tempSum;
			}
		}
		return max;
	}
	
	public static int[] maxSubarrayCrossing(int[] a, int low, int hig) {
		int leftSum = -10000000;
		int sum = 0;
		int mid = low + (hig - low) / 2;
		int leftIndex = mid;
		for(int i=mid ; i>=low ; i--) {
			sum += a[i];
			if(sum > leftSum) {
				leftSum = sum;
				leftIndex = i;
			}
			
		}
		
		int rightSum = -10000000;
		sum = 0;
		int rightIndex = mid + 1;
		for(int i=mid+1 ; i<=hig ; i++) {
			sum += a[i];
			if(sum > rightSum) {
				rightSum = sum;
				rightIndex = i;
			}
			
		}
		
		int[] ans = {leftSum + rightSum, leftIndex, rightIndex};
		return ans;
				
	}
	
	public static int[] maximumSubarray(int[] a, int low, int hig) {
		if(low >= hig) {
			int[] ans = {a[low], low, hig};
			return ans;
		}
		
		int mid = low + (hig - low) / 2;
		int[] leftMax = maximumSubarray(a, low, mid);
		int[] rightMax = maximumSubarray(a, mid + 1, hig);
		int[] crossingMax = maxSubarrayCrossing(a, low, hig);
		
		if((leftMax[0] >= rightMax[0]) && (leftMax[0] >= crossingMax[0])) {
			return leftMax;
		} else if((rightMax[0] >= leftMax[0]) && (rightMax[0] >= crossingMax[0])) {
			return rightMax;
		} else {
			return crossingMax;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {4,6,2,7,8,15,7};
		System.out.println(bruteForce(a));
		System.out.println(maximumSubarray(a, 0, a.length - 1)[0]);
		int sumArray = 0;
		for(int i=0 ; i<a.length ; i++) {
			sumArray += a[i];
		}
		System.out.println(sumArray);
	}

}
