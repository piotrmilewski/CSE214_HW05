public class NotADirectoryException extends Exception{

    public NotADirectoryException(){
	//default message
	super("This is not a directory");
    }

    public NotADirectoryException(String message){
	//passed message
	super(message);
    }    
}
