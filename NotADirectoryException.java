/**
 * The <code>NotADirectoryException</code> class extended the <code>Exception</code> class and is used to 
 * indicate that the user has provided the terminal with a directory that does not exist.
 *
 *
 * @author Piotr Milewski
 *    email: piotr.milewski@stonybrook.edu
 *    Stony Brook ID: 112291666
 **/

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
