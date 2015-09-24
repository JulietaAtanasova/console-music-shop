package interfaces.engine;

import java.util.Map;

public interface Command {
	String getName();

	Map<String, String> getParameters();
}
