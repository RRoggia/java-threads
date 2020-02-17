package com.rroggia.threads.interruption;

public class SleepMessages implements Runnable {

	public static void main(String[] args) throws InterruptedException {
		SleepMessages sleepMessagesThread = new SleepMessages();

		Thread thread = new Thread(sleepMessagesThread);
		thread.start();

		Thread.sleep(22000);
		thread.interrupt();

		System.out.println("Fim principal");
	}

	@Override
	public void run() {
		String importantInfo[] = { "Rosas s�o vermelhas", "Violetas s�o azuis", "o nintendo switch � preto",
				"e o cabo daciolo" };

		for (String string : importantInfo) {
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				return;
			}

			System.out.println(string);
		}

		int count = 0;
		while (true) {

			count++;
			if (count == 100)
				System.out.println("processing...");

			if (Thread.interrupted())
				return;
		}

	}

}
