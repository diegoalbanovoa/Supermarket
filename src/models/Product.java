package models;

import java.util.Random;

public class Product {
	
	public int time;
	
	public Product() {
		Random r = new Random();
		this.time = r.nextInt(50);
	}
}
