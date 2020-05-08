package project;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.introcs.StdDraw;
import support.cse131.ArgsProcessor;

public class SnakeGame {

	private final int size = 21;
	public static int score = 0;


	public SnakeGame(int size) {
	}

	public static void genBoard(double size) {
	
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
		
	}





	public static void main(String[] args) {
		System.out.println("I'm a snaaaaaaaake! HISSSSSSSSSSSssssss.....");
		ArgsProcessor ap = new ArgsProcessor(args);
		//Double size= ap.nextDouble("put in size of grid");
		int size = 21;

		LinkedList<Double> positionX = new LinkedList<Double>();
		LinkedList<Double> positionY = new LinkedList<Double>();


		Move.genFood(size);
		//Move move = new Move(size);
		Move.update(positionX, positionY,size);	//init position


		StdDraw.enableDoubleBuffering();
		while(true)
		{
			StdDraw.clear();
			genBoard(size);
			Move.dir(); //set direction

			Move.goSnake(positionX,positionY,size); //change position based dir
			Move.drawSnake(positionX,positionY,size); //draws things based on list

			if (Move.collision(positionX, positionY, size)==false)
			{
				System.out.println("snake is dead");
				break;
			}



			if (Move.getFood(positionX,positionY,size))
			{
				score++;
				System.out.println("yum! you ate " + score + " dollars");
	
			}

			Move.drawFood(size);

			StdDraw.show(100);

		}

	}

}
