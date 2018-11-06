public class DirectoryNode{

    String name;
    DirectoryNode left;
    DirectoryNode middle;
    DirectoryNode right;
    DirectoryNode parent;
    boolean isFile;

    public DirectoryNode(){
	name = "";
	left = null;
	middle = null;
	right = null;
	parent = null;
	isFile = true;
    }

    public DirectoryNode( boolean newIsFile){
	name = "";
	left = null;
	middle = null;
	right = null;
	parent = null;
	isFile = newIsFile;
    }

    public DirectoryNode( String newName, DirectoryNode newParent, boolean newIsFile){
	name = newName;
	left = null;
	middle = null;
	right = null;
	parent = newParent;
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

    public DirectoryNode getParent(){
	return parent;
    }

    public boolean isFile(){
	return isFile;
    }

    public void addChild(DirectoryNode newChild) throws FullDirectoryException, NotADirectoryException{
	//if current node is a file
	if (isFile){
	    try{
		throw new NotADirectoryException();
	    }
	    catch (NotADirectoryException nade){
		System.out.println(nade);
	    }
	}
	//attempt to add child to the current node, from left to right
	if (left == null)
	    left = newChild;
	else if (middle == null)
	    middle = newChild;
	else if (right == null)
	    right = newChild;
	//if all child references of this directory are occupied
	else{
	    try{
		throw new FullDirectoryException();
	    }
	    catch (FullDirectoryException fde){
		System.out.println(fde);
	    }
	}
    }
}
