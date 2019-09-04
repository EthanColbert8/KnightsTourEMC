package edu.bellarmine.emc;

/**
 * This class represents the chessboard using a 2d array of 64 BoardSquares (8x8).
 * 
 * @author Ethan Colbert
 * @version 1.0
 * Programming Project 1
 * Fall 2019
 */

 class Board {
	 
	 public final BoardSquare[][] boardArray = {
			 
			 {new BoardSquare('a', 8, 0), new BoardSquare('b', 8, 0), new BoardSquare('c', 8, 0), new BoardSquare('d', 8, 0), new BoardSquare('e', 8, 0), new BoardSquare('f', 8, 0), new BoardSquare('g', 8, 0), new BoardSquare('h', 8, 0)},
			 {new BoardSquare('a', 7, 0), new BoardSquare('b', 7, 0), new BoardSquare('c', 7, 0), new BoardSquare('d', 7, 0), new BoardSquare('e', 7, 0), new BoardSquare('f', 7, 0), new BoardSquare('g', 7, 0), new BoardSquare('h', 7, 0)},
			 {new BoardSquare('a', 6, 0), new BoardSquare('b', 6, 0), new BoardSquare('c', 6, 0), new BoardSquare('d', 6, 0), new BoardSquare('e', 6, 0), new BoardSquare('f', 6, 0), new BoardSquare('g', 6, 0), new BoardSquare('h', 6, 0)},
			 {new BoardSquare('a', 5, 0), new BoardSquare('b', 5, 0), new BoardSquare('c', 5, 0), new BoardSquare('d', 5, 0), new BoardSquare('e', 5, 0), new BoardSquare('f', 5, 0), new BoardSquare('g', 5, 0), new BoardSquare('h', 5, 0)},
			 {new BoardSquare('a', 4, 0), new BoardSquare('b', 4, 0), new BoardSquare('c', 4, 0), new BoardSquare('d', 4, 0), new BoardSquare('e', 4, 0), new BoardSquare('f', 4, 0), new BoardSquare('g', 4, 0), new BoardSquare('h', 4, 0)},
			 {new BoardSquare('a', 3, 0), new BoardSquare('b', 3, 0), new BoardSquare('c', 3, 0), new BoardSquare('d', 3, 0), new BoardSquare('e', 3, 0), new BoardSquare('f', 3, 0), new BoardSquare('g', 3, 0), new BoardSquare('h', 3, 0)},
			 {new BoardSquare('a', 2, 0), new BoardSquare('b', 2, 0), new BoardSquare('c', 2, 0), new BoardSquare('d', 2, 0), new BoardSquare('e', 2, 0), new BoardSquare('f', 2, 0), new BoardSquare('g', 2, 0), new BoardSquare('h', 2, 0)},
			 {new BoardSquare('a', 1, 0), new BoardSquare('b', 1, 0), new BoardSquare('c', 1, 0), new BoardSquare('d', 1, 0), new BoardSquare('e', 1, 0), new BoardSquare('f', 1, 0), new BoardSquare('g', 1, 0), new BoardSquare('h', 1, 0)}
			 
	 };
	 
	 /**
	  * Empty-argument constructor
	  */
	 public Board() {
		 
	 }// end empty-argument constructor

	@Override
	public String toString() {
		return "Board [Chess]";
	}
	
}// end "Board" class
