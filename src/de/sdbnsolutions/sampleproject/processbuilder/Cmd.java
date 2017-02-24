package de.sdbnsolutions.sampleproject.processbuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public abstract class Cmd {

	public int execute() throws IOException, InterruptedException {
		
		List<String> command = new ArrayList<String>();
		
		command.add(getCmdFile());
		
		List<String> parameters = new ArrayList<String>();
		setParameters(parameters);
		
		for (String parameter : parameters) {
			command.add(parameter);
		}
		
		ProcessBuilder processBuilder = new ProcessBuilder(command);
		
		Process process = processBuilder.start();
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		
		String line = null;
		
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
		}
		
		return process.waitFor();
	}

	private void setParameters(List<String> parameters) {
		// TODO Auto-generated method stub
		
	}

	private String getCmdFile() {
		// TODO Auto-generated method stub
		return null;
	}
}
