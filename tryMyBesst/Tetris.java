/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
class Tetris
{
	public static void main (String[] args) throws java.lang.Exception
	{

		Board board = new Board(20, 20);
		board.Start();

		Boolean isRunning = true;

		
		    PieceShape piece = new PieceShape();
			int[][] shape = piece.getShape();
			Block block = new Block(1, shape);


		while(isRunning) {

			Scanner userInputScanner = new Scanner(System.in);
			System.out.print("\nWhat is your move? ");
        	String direction = userInputScanner.nextLine().trim();

        	
			block.move(direction);

			if (block.offsetY == 19) {

				board.AddBlock(block);
				piece = new PieceShape();
				shape = piece.getShape();
				block = new Block(1, shape);
				board.Update();

			} else {

				board.AddBlock(block);
				board.Update();
				board.RemoveBlock(block);

			}
		}
	}
}

class Board {
	int height;
	int width;
	int[][] board;

	 public Board(int height, int width) {
        this.height = height;
        this.width = width;
        this.board = new int[width][height];
    }
    
    public void Start() {
    	for (int i = 0; i < this.width; i++) {
    		for (int j = 0; j < this.height; j++) {
    			if (this.width - 1 == i) {
    				this.board[i][j] = 1;
    			} else {
    					if (j == 0 || j == height - 1) {
    						this.board[i][j] = 1;
    					} else {
    						this.board[i][j] = 0;
    					}
    			}
    		}
    	}
    }
    

    public void Update() {
    	for(int[] x: this.board)
		{
		    for(int val: x) {
		    	if (val == 1) {
		    		System.out.print("*");
		    	} else {
		    		System.out.print(" ");
		    	}
		    }
		   	System.out.println("");
		}
    }

    
    public void AddBlock(Block block) {

    		for (int y = block.y, i = 0; i < block.pieceShape.length; y++, i++) {
	    		for (int x = block.x, j = 0; j < block.pieceShape[0].length; x++, j++) {
	    				
	    				this.board[y][x] = block.pieceShape[i][j];
	    			
    			}
    		}
    		
	}

	public void RemoveBlock(Block block) {

			for (int i = block.y; i <= block.offsetY; i++) {
				for (int j = block.x; j <= block.offsetX; j++) {
					this.board[i][j] = 0;
				}
			}
	}

}

class Block {
	int x;
	int y;
	int offsetX;
	int offsetY;
	Boolean isStopped;
	int[][] pieceShape;
	
	public Block(int x, int[][] pieceShape) {
		this.x = x;
		this.y = 0;
		this.isStopped = false;
		this.pieceShape = pieceShape;
		updateOffset();
	}

	public void moveLeft() {
		
		if (this.x > 1) {
			this.x = this.x - 1;
			updateOffset();
		}
		
		
	}

	public void moveRight() {

		if (this.x < 20) {
			this.x = this.x + 1;
			updateOffset();
		}
		
	}

	public void moveUp() {

		if (this.offsetY < 19) {
			this.y = this.y + 1;
			updateOffset();
		} else {
			this.isStopped = true;
		}
		
	}

	private void updateOffset() {
		this.offsetY = this.y + this.pieceShape.length; //height
		this.offsetX = this.x + this.pieceShape[0].length; //width
	}

	public void move(String direction) {
			if (direction.equals("a")) {
				this.moveLeft();
        	} else if (direction.equals("d")) {
        		this.moveRight();
        	}
        	this.moveUp();
	} 

}

class PieceShape {
	
	int[][] first = {
						{1,1,1,1}
					};
					
	int[][] second = {
						{1,0},
						{1,0},
						{1,1}
					 };

	int[][] third = {
						{0,1},
						{0,1},
						{1,1}
					};

	int[][] fourth = {
						{0,1},
						{1,1},
						{1,0}
					};

	int[][] fifth = {
						{1,1},
						{1,1}
					};
	int[][][] shapes = new int[5][][];
	
	public PieceShape() {
		shapes[0] = first;
		shapes[1] = second;
		shapes[2] = third;
		shapes[3] = fourth;
		shapes[4] = fifth;

	}

	public int[][] getShape() {
		int i = (int)(Math.random() * 5);
		return shapes[i];
	}
}