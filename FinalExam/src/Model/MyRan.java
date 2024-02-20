package Model;

import java.util.Random;

public class MyRan {
	
	public static int getRan() {
		Random random = new Random(); 
		
		int numRan = random.nextInt(100 - 1) + 1;
		return numRan;
	}
}
