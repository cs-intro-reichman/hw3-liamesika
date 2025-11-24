
public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int sum_x = x1;
		if (x2 >= 0) {
			for (int i = 0; i < x2; i++) {
				sum_x++;
			}
		} else {
			for (int i = 0; i > x2; i--) {
				sum_x--;
			}
		}
		return sum_x;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int minus_x = x1;
		if (x2 >= 0) {
			for (int i = 0; i < x2; i++) {
				minus_x--;
			}
		} else {
			for (int i = 0; i > x2; i--) {
				minus_x++;
			}
		}
		return minus_x;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int times_x = 0;
		boolean negative = false;

		if ((x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0)) {
			negative = true;
		}

		int absX1 = x1 < 0 ? minus(0, x1) : x1;
		int absX2 = x2 < 0 ? minus(0, x2) : x2;
		for (int i = 0; i < absX2; i++) {
			times_x = plus(times_x, absX1);
		}

		return negative ? minus(0, times_x) : times_x;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (n == 0) {
			return 1;
		}
		int pow_x = x;
		for (int i = 0; i < n - 1; i++) {
			pow_x = times(pow_x, x);
		}
		return pow_x;
	}

	// Returns the integer part of x1 / x2
	public static int div(int x1, int x2) {
		int div_x = 0;
		boolean negative = false;

		if ((x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0)) {
			negative = true;
		}

		int absX1 = x1 < 0 ? minus(0, x1) : x1;
		int absX2 = x2 < 0 ? minus(0, x2) : x2;

		while (absX1 >= absX2) {
			div_x = plus(div_x, 1);
			absX1 = minus(absX1, absX2);
		}

		return negative ? minus(0, div_x) : div_x;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int mod_x = 0;
		if (x1 < x2){
			return x1;
		}
		else {
			int div_num = div(x1,x2);
			int times_num = times(x2, div_num);
			mod_x = (minus(x1, times_num));
		}
		return mod_x;
	}	

	// Returns the integer part of sqrt(x)
	public static int sqrt(int x) {
		if (x == 0) {
			return 0;
		}
		if (x == 1) {
			return 1;
		}
		int count = 0;
		for (int i = 0; i <= x; i++) {
			if (times(i, i) == x) {
				return i;
			}
			if (times(i, i) > x) {
				return minus(i, 1);
			}
			count = i;
		}
		return count;
	}	  	  
}