public class DirectoryTree{

    DirectoryNode root;
    DirectoryNode cursor;

    public DirectoryTree(){
	root = new DirectoryNode( "root", false);
	cursor = root;
    }
    
    public void resetCursor(){
	cursor = root;
    }

    public void changeDirectory(String name) throws NotADirectoryException{
	
    }

    public String presentWorkingDirectory(){
	return "";
    }

    public String listDirectory(){
	return "";
    }

    public void printDirectoryTree(){

    }

    public void makeDirectory(String name) throws IllegalArgumentException, FullDirectoryException{

    }

    public void makeFile(String name) throws IllegalArgumentException, FullDirectoryException{

    }

    
    
}
