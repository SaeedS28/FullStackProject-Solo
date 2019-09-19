package com.fdmgroup.util;

import java.util.Random;

public class IdGenerator {

	private static Random random = new Random();
	
	public static int generate() {
		return Math.abs(random.nextInt());
	}

}
