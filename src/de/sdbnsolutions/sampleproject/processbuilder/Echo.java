package de.sdbnsolutions.sampleproject.processbuilder;

import java.util.List;

public class Echo extends Cmd{

	private String message;

	public Echo(String message) {
		super();
		this.message = message;
	}

	@Override
	public void setParameters(List<String> parameters) {
		parameters.add(message);
	}

	@Override
	public String getCmdFile() {
		return "cmd/myecho.cmd";
	}

}
