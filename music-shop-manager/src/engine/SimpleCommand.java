package engine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import interfaces.engine.Command;

public class SimpleCommand implements Command {
	private static final char COMMAND_NAME_SEPARATOR = '[';
	private static final String COMMAND_PARAMETER_SEPARATOR = ";";
	private static final String COMMAND_VALUE_SEPARATOR = ":";
	
	private String name;
	private Map<String, String> parameters = new HashMap<String, String>();
	
	public SimpleCommand(String input)
    {
        this.translateInput(input);
    }
	
	@Override
	public String getName() {
		return this.name;
	}
	
	private void setName(String name){
		if(name.equals(null) || name.length() == 0){
			throw new IllegalArgumentException("The command name is required.");
		}
		this.name = name;
	}
	
	@Override
	public Map<String, String> getParameters() {
		return this.parameters;
	}
	
	private void setParameters(Map<String, String> parameters){
		if(parameters == null){
			throw new IllegalArgumentException("The command parameters are required.");
		}
		this.parameters = parameters;
	}
	
    public static SimpleCommand parse(String input)
    {
        return new SimpleCommand(input);
    }
    
	private void translateInput(String input) {
		int parametersBeginning = input.indexOf(COMMAND_NAME_SEPARATOR);
		
		this.setName(input.substring(0, parametersBeginning));
		String subString = input.substring(parametersBeginning + 1, input.length() - 1);
		String[] temp =  subString.split(COMMAND_PARAMETER_SEPARATOR);
		
		List<String> parametersKeysAndValues = Arrays.asList(temp);
		parametersKeysAndValues.removeAll(Arrays.asList("", null));
		
		for (String parameter : parametersKeysAndValues) {
			String[] split = parameter.split(COMMAND_VALUE_SEPARATOR);
			List<String> parameters = Arrays.asList(split);
			parameters.removeAll(Arrays.asList("", null));
			this.getParameters().put(parameters.get(0), parameters.get(1));
			this.setParameters(this.getParameters());
		}
	}
}
