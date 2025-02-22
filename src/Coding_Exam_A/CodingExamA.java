package Coding_Exam_A;

import java.awt.Color;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {
	public static void main(String[] args) {
		/*
		 * Write a program that asks the user for three pieces of information.
		 * 1. How many robots
		 * 2. The color of the shapes
		 * 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the requested number of robots
		 * each draw the requested shape in the requested color. The robots should execute at the same time so 
		 * Threads will need to be used. Arrange the robots so that the shapes do not overlap.
		 * For full credit, define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product should look like.
		 */
		int count = Integer.parseInt(JOptionPane.showInputDialog("How many robots?"));
		Color color;
		switch (JOptionPane.showInputDialog("What color? (Red, Green, Blue)").toLowerCase())
		{
		case "red":
			color = Color.red;
			break;
		case "green":
			color = Color.green;
			break;
		case "blue":
			color = Color.blue;
			break;
		default:
			color = Color.black;
			break;
		}
		int sides = Integer.parseInt(JOptionPane.showInputDialog("How many sides?"));
		
		Thread[] threads = new Thread[count];
		for (int i = 0; i < threads.length; i++)
		{
			int x = ((i % 4) * 200) + 50;
			int y = ((i / 4) * 200) + 200;
			threads[i] = new Thread(() -> {
				Robot rob = new Robot(x, y);
				rob.setSpeed(5);
				rob.setPenColor(color);
				rob.penDown();
				for (int j = 0; j < sides; j++) {
					rob.move(400/sides);
					rob.turn(360/sides);
				}
			});
			threads[i].start();
		}
	}
}
