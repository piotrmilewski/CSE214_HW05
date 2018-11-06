/**
 * The <code>FullDirectoryException</code> class extends the Exception class and is used to indicate that the 
 * user has tried to add an element to a directory that is already full.
 *
 *
 * @author Piotr Milewski
 *    email: piotr.milewski@stonybrook.edu
 *    Stony Brook ID: 112291666
 **/

public class FullDirectoryException extends Exception{

    public FullDirectoryException(){
	//default message
	super("Present Directory is full.");
    }

    public FullDirectoryException(String message){
	//passed message
	super(message);
    }    
}
