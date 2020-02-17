package com.rroggia.threads.join;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		PlayerOne playerOne = new PlayerOne();
		PlayerTwo playerTwo = new PlayerTwo();

		Thread threadPlayerOne = new Thread(playerOne);
		Thread threadPlayerTwo = new Thread(playerTwo);

		threadPlayerOne.start();
		threadPlayerOne.join();
		threadPlayerTwo.start();

		new Thread(playerOne).start();
		new Thread(playerTwo).start();

	}

}
