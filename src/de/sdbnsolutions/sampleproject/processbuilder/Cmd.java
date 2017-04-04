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
		
		ProcessBuilder processBuilder = new ProcessBuilder(command);
		
		for (String parameter : parameters) {
			processBuilder.environment().put(parameter.getName(), parameter.getValue());
		}
		
		Process process = processBuilder.start();
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		
		String line = null;
		
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
		}
		
		return process.waitFor();
	}

	public abstract void setParameters(List<String> parameters);

	public abstract String getCmdFile();
}
