package de.sdbnsolutions.sampleproject.processbuilder;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		new Echo("Hello World!").execute();
	}
	
}
