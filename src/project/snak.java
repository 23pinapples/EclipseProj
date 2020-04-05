package project;

import java.io.InputStream;

import edu.princeton.cs.introcs.StdDraw;

public class snak {

	public static void genBoard(double size) {
		//size = 10 by 10
		//double size = 10;
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		for (int i =0; i<size;++i )
		{
			StdDraw.line((i/size), 0, (i/size), 1);
			StdDraw.line(0, (i/size), 1, (i/size));

		}
		
		//initial conditions with andrew, and import dollar bill
		InputStream body = classLoader.getResourceAsStream("body.png");
		InputStream andrew = classLoader.getResourceAsStream("andrew.png");
		InputStream peet = classLoader.getResourceAsStream("peet.png");
		InputStream dolla = classLoader.getResourceAsStream("dolla.png");
		StdDraw.picture(0.5, 0.5, "body.png", 1/size, 1/size);
		StdDraw.picture(0.5, 0.5+(1/size),"andrew.png", 1/size, 1/size);
		StdDraw.picture(0.5, 0.5-(1/size), "peet.png", 1/size, 1/size);
		
		//ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		//InputStream dolla = classLoader.getResourceAsStream("dolla.png");
//		double foodPosX = (1/(2*size))+ (1/size)*(int)(Math.random()*size);
//		double foodPosY = (1/(2*size))+ (1/size)*(int)(Math.random()*size);
//		StdDraw.picture(foodPosX, foodPosY, "dolla.png", 1/size, 1/size);
//		System.out.println("x pos is " + foodPosX + " y pos is " + foodPosY);
		
	}
	
	public static void genFood() {
		int size = 21;
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream dolla = classLoader.getResourceAsStream("dolla.png");
		double foodPosX = 0.5*size+ (1/size)*(int)(Math.random()*size);
		double foodPosY = 0.5*size+ (1/size)*(int)(Math.random()*size);
		StdDraw.picture(foodPosX, foodPosY, "dolla.png", 1/size, 1/size);
	}
	
	


}
