import java.io.*;

public class BashTerminal{

    public static void main(String[] args) throws IOException, NotADirectoryException, FullDirectoryException{
	//Open an input stream for reading from the keyboard
	InputStreamReader inStream = new InputStreamReader(System.in);
	BufferedReader stdin = new BufferedReader(inStream);

	DirectoryTree terminal = new DirectoryTree();
	
	boolean runTerminal = true;
	System.out.println("\nStarting bash terminal.");
	
	while (runTerminal){

	    String prompt, rawInput;
	    String[] input;
	    
	    prompt = "[pmilewski@127.0.0.1]: $ ";
	    System.out.print(prompt);
	    rawInput = stdin.readLine();
	    input = rawInput.split(" ");

	    if (input[0].equals("pwd") && input.length == 1){
		System.out.println(terminal.presentWorkingDirectory());
	    }
	    else if (input[0].equals("ls")  && input.length == 2 && input[1].equals("-R")){
		terminal.printDirectoryTree();
	    }
	    else if (input[0].equals("ls") && input.length == 1){
		System.out.println(terminal.listDirectory());
	    }
	    else if (input[0].equals("cd") && input.length == 2 && input[1].equals("/")){
		terminal.resetCursor();
	    }
	    else if (input[0].equals("cd") && input.length == 2){
		terminal.changeDirectory(input[1]);
	    }
	    else if (input[0].equals("mkdir") && input.length == 2){
		terminal.makeDirectory(input[1]);
	    }
	    else if (input[0].equals("touch") && input.length == 2){
		terminal.makeFile(input[1]);
	    }
	    else if (input[0].equals("exit") && input.length == 1){
		System.out.println("Program terminating normally");
		runTerminal = false;
	    }
	    else{
		System.out.println("lol what");
	    }
	}
    }
}
