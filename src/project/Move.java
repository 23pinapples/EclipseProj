package project;


import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.introcs.StdDraw;

import java.io.InputStream;
import java.util.*;

public class Move {
	private static boolean left = false;
	private static boolean right = false;
	private static boolean up = true;
	private static boolean down = false;
	private static boolean leftKey = StdDraw.isKeyPressed(37);
	private static boolean rightKey = StdDraw.isKeyPressed(39);
	private static boolean upKey =  StdDraw.isKeyPressed(38);
	private static boolean downKey = StdDraw.isKeyPressed(40);
	private static boolean alive = true;
	
	private static double foodPosX, foodPosY;
	
	public static void update(List<Double> positionX,List<Double> positionY, int size) {
		//
		//head
		positionX.add(0, 0.5);
		positionY.add(0, 0.5+(1.0/size));
		//body
		positionX.add(1, 0.5);
		positionY.add(1, 0.5);
		//peet
		positionX.add(2, 0.5);
		positionY.add(2, 0.5-(1.0/size));
		
	}

	public static void dir() {
		leftKey = StdDraw.isKeyPressed(37);
		rightKey = StdDraw.isKeyPressed(39);
		upKey =  StdDraw.isKeyPressed(38);
		downKey = StdDraw.isKeyPressed(40);

		//if key is pressed
		if (leftKey && left ==false && right ==false)
		{
			left = true; right = false; up = false; down = false;
		}

		if (rightKey && right==false && left ==false)
		{
			left = false; right = true; up = false; down = false;
		}

		if (upKey && up==false && down==false)
		{
			left = false; right = false; up = true; down = false;
		}

		if (downKey && down==false && up ==false)
		{
			left = false; right = false; up = false; down = true;
		}

		//if no key pressed
		else if (leftKey==false && rightKey==false && upKey==false && downKey==false) 
		{

		}
	}

	public static void goSnake(List<Double> positionX,List<Double> positionY,int size) {
		int length = positionX.size()-1;

		for (int i = length; i>=1; --i)
		{
			positionX.set(i, positionX.get(i-1));
			positionY.set(i, positionY.get(i-1));
		}

		if (left)
		{
			positionX.set(0, positionX.get(0)-(1.0/size));
		}

		else if (right)
		{
			positionX.set(0, positionX.get(0)+(1.0/size));
		}

		else if (up)
		{
			positionY.set(0, positionY.get(0)+(1.0/size));
		}

		else if (down)
		{
			positionY.set(0, positionY.get(0)-(1.0/size));
		}



	}

	public static boolean collision(List<Double> positionX,List<Double> positionY,int size) {
		if (left && positionX.get(0)<(0.5/size))
		{
			alive = false;
			
		}
		if (right && positionX.get(0)>1 )

		{
			alive = false;

		}

		if (up && positionY.get(0)>1)
		{
			alive = false;
		}

		if (down && positionY.get(0)<0)

		{
			alive = false;
		}

		for (int i =1; i<positionX.size(); ++i)
		{
			if (positionX.get(0)==positionX.get(i) && positionY.get(0)==positionY.get(i))
			{
				alive = false;
			}
		}
		
		return alive;
	}
	
	public static boolean getFood(LinkedList<Double> positionX,LinkedList<Double> positionY,int size) 
	{
		if (Math.abs(foodPosX-positionX.get(0))<(0.5/size) && Math.abs(foodPosY-positionY.get(0))<(0.5/size))
		{
			
			genFood(size);
			if (up)
			{
				positionX.addLast(positionX.getLast());
				positionY.addLast(positionY.getLast()+(1.0/size));
			}
			
			if (down)
			{
				positionX.addLast(positionX.getLast());
				positionY.addLast(positionY.getLast()-(1.0/size));
			}
			
			if (left)
			{
				positionX.addLast(positionX.getLast()+(1.0/size));
				positionY.addLast(positionY.getLast());
			}
			
			if (right)
			{
				positionX.addLast(positionX.getLast()-(1.0/size));
				positionY.addLast(positionY.getLast());
			}
			return true;
		}
		
		return false;
	}

	public static void genFood(int size) {

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream dolla = classLoader.getResourceAsStream("dolla.png");
		foodPosX = (1/(2.0*size))+ (1.0/size)*(int)(Math.random()*size);
		foodPosY = (1/(2.0*size))+ (1.0/size)*(int)(Math.random()*size);

	}
	
	public static void drawFood(int size) {
		StdDraw.picture(foodPosX, foodPosY, "dolla.png", 1.0/size, 1.0/size);
	}

	public static void drawSnake(List<Double> positionX,List<Double> positionY,int size){
		int length = positionX.size()-1;

		StdDraw.picture(positionX.get(0), positionY.get(0),"andrew.png", 1.0/size, 1.0/size);

		for (int i = 1; i<length; ++i)
		{
			StdDraw.picture(positionX.get(i), positionY.get(i), "body.png", 1.0/size, 1.0/size);
		}



		StdDraw.picture(positionX.get(length), positionY.get(length), "peet.png", 1.0/size, 1.0/size);
	}


}
