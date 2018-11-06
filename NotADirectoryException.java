public class NotADirectoryException extends Exception{

    public NotADirectoryException(){
	//default message
	super("No such directory exists.");
    }

    public NotADirectoryException(String message){
	//passed message
	super(message);
    }    
}
