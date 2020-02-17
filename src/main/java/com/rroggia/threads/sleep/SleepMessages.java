package com.rroggia.threads.sleep;

public class SleepMessages {

	public static void main(String[] args) throws InterruptedException {
		String importantInfo[] = { "Rosas são vermelhas", "Violetas são azuis", "o nintendo switch é preto",
				"e o cabo daciolo" };

		for (String string : importantInfo) {
			Thread.sleep(4000);

			System.out.println(string);
		}
	}

}
