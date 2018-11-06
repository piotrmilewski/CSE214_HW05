public class FullDirectoryException extends Exception{

    public FullDirectoryException(){
	//default message
	super("Current Directory is full");
    }

    public FullDirectoryException(String message){
	//passed message
	super(message);
    }    
}
