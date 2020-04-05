package project;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.introcs.StdDraw;
import support.cse131.ArgsProcessor;

public class SnakeGame {

	//TODO: Implement the game of snake
	//		You may add other files/classes, but the game should start by running this file
	//make a board with size, make grid
	//import image to grid, snake head, snake body, snake tail, apple
	//
	//generate food
	//see if player hit food
	//score
	//check if dead
	//initializing stuff(player, grid, ect)
	private final int size = 21;

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
		//StdDraw.picture(0.5, 0.5, "body.png", 1/size, 1/size);
		//StdDraw.picture(0.5, 0.5+(1/size),"andrew.png", 1/size, 1/size);
		//StdDraw.picture(0.5, 0.5-(1/size), "peet.png", 1/size, 1/size);

		//ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		//InputStream dolla = classLoader.getResourceAsStream("dolla.png");
		//		double foodPosX = (1/(2*size))+ (1/size)*(int)(Math.random()*size);
		//		double foodPosY = (1/(2*size))+ (1/size)*(int)(Math.random()*size);
		//		StdDraw.picture(foodPosX, foodPosY, "dolla.png", 1/size, 1/size);
		//		System.out.println("x pos is " + foodPosX + " y pos is " + foodPosY);

	}

	public static void genFood(double size) {

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream dolla = classLoader.getResourceAsStream("dolla.png");
		double foodPosX = (1/(2*size))+ (1/size)*(int)(Math.random()*size);
		double foodPosY = (1/(2*size))+ (1/size)*(int)(Math.random()*size);
		System.out.println("x pos is " + foodPosX + " y pos is " + foodPosY);
		StdDraw.picture(foodPosX, foodPosY, "dolla.png", 1/size, 1/size);
	}





	public static void main(String[] args) {
		System.out.println("I'm a snaaaaaaaake! HISSSSSSSSSSSssssss.....");
		ArgsProcessor ap = new ArgsProcessor(args);
		//Double size= ap.nextDouble("put in size of grid");
		int size = 21;

		List<Double> positionX = new LinkedList<Double>();
		List<Double> positionY = new LinkedList<Double>();


		//genFood(size);
		//Move move = new Move(size);
		Move.update(positionX, positionY,size);	//init position
		System.out.println("**position y is " + positionY);
		//		Move.dir(); //set direction
		//		Move.goSnake(positionX,positionY,size); //change position based dir
		//		Move.drawSnake(positionX,positionY,size); //draws things based on list
		StdDraw.enableDoubleBuffering();
		while(Move.collision(positionX, positionY,size))
		{

			StdDraw.clear();
			genBoard(size);
			Move.dir(); //set direction
			System.out.println("position x is" + positionX);
			System.out.println("position y is " + positionY);
			Move.goSnake(positionX,positionY,size); //change position based dir
			//System.out.println("changed" +positionX);
			Move.drawSnake(positionX,positionY,size); //draws things based on list

			StdDraw.show(100);

		}
		//System.out.println((int)(Math.random()*5));

		// TODO: Run the game from here!
	}

}