package com.rroggia.threads.sleep;

public class SleepMessages {

	public static void main(String[] args) throws InterruptedException {
		String importantInfo[] = { "Rosas s�o vermelhas", "Violetas s�o azuis", "o nintendo switch � preto",
				"e o cabo daciolo" };

		for (String string : importantInfo) {
			Thread.sleep(4000);

			System.out.println(string);
		}
	}

}
