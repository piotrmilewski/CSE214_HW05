public class DirectoryNode{

    String name;
    DirectoryNode left;
    DirectoryNode middle;
    DirectoryNode right;
    boolean isFile;

    public DirectoryNode(){
	name = "";
	left = null;
	middle = null;
	right = null;
	isFile = true;
    }

    public DirectoryNode( boolean newIsFile){
	name = "";
	left = null;
	middle = null;
	right = null;
	isFile = newIsFile;
    }

    public DirectoryNode( String newName, boolean newIsFile){
	name = newName;
	left = null;
	middle = null;
	right = null;
	isFile = newIsFile;
    }

    public String getName(){
	return name;
    }

    public void setName(String newName){
	name = newName;
    }

    public DirectoryNode getLeft(){
	return left;
    }
    
    public DirectoryNode getMiddle(){
	return middle;
    }
    
    public DirectoryNode getRight(){
	return right;
    }

    public void addChild(DirectoryNode newChild) throws FullDirectoryException, NotADirectoryException{
	//if current node is a file
	if (isFile)
	    throw NotADirectoryException;
	//attempt to add child to the current node, from left to right
	if (left == null)
	    left = newChild;
	else if (middle == null)
	    middle = newChild;
	else if (right == null)
	    right = newChild;
	//if all child references of this directory are occupied
	else
	    throw FullDirectoryException;
    }

}
