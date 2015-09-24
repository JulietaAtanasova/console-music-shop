package engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import interfaces.engine.UserInterface;

public class ConsoleInterface implements UserInterface {

	@Override
	public Iterable<String> input() {
		Scanner in = new Scanner(System.in);
		String currentLine = in.nextLine();
		List<String> input = new ArrayList<>();
		while (!currentLine.equals("End"))
        {
            if (currentLine.equals("") || currentLine.startsWith("//"))
            {
                currentLine = in.nextLine();
                continue;
            }

            //TO DO: Fix yield
            input.add(currentLine);
            currentLine = in.nextLine();
        }
		return input;
	}

	@Override
	public void output(Iterable<String> output) {
		StringBuilder result = new StringBuilder();
        for (String line : output) {
            result.append(line.trim() + "\n");
        }

        System.out.println(result.toString().trim());
	}

}
