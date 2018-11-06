public class DirectoryTree{

    DirectoryNode root;
    DirectoryNode cursor;

    public DirectoryTree(){
	root = new DirectoryNode( "root", null, false);
	cursor = root;
    }
    
    public void resetCursor(){
	cursor = root;
    }

    public boolean cDHelper(DirectoryNode pass, String name) throws NotADirectoryException{
	boolean found = false;
	if (name.equals(pass.getName())){
	    if (pass.isFile()){
		throw new NotADirectoryException();
	    }
	    found = true;
	    cursor = pass;
	}
	return found;
    }

    public void changeDirectory(String name) throws NotADirectoryException{
	boolean found = false;
	if (cursor.isFile()) //if cursor is not a directory
	    throw new NotADirectoryException();
	while (!found){
	    if (found == false){
		found = cDHelper(cursor.getLeft(), name);
	    }
	    if (found == false){
		found = cDHelper(cursor.getMiddle(), name);
	    }
	    if (found == false){
		found = cDHelper(cursor.getRight(), name);
	    }
	    if (found == false){
		throw new NotADirectoryException();
	    }
	}
    }
    
    public String presentWorkingDirectory(){
	String path = "";
	DirectoryNode innerCursor = cursor;
	if (cursor == root){
	    path += "root";
	    return path;
	}
	while (innerCursor != root){
	    path = "/" + innerCursor.getName() + path;
	    innerCursor = innerCursor.getParent();
	}
	path = "root" + path;
	return path;
    }

    public String listDirectory(){
	String dirs = "";
	if (cursor.getLeft() != null)
	    dirs += cursor.getLeft().getName() + " ";
	if (cursor.getMiddle() != null)
	    dirs += cursor.getMiddle().getName() + " ";
	if (cursor.getRight() != null)
	    dirs += cursor.getRight().getName() + " ";
	return dirs;
    }

    public String printDirectoryTree(DirectoryNode curr, int numOfTabs){
	String output = "";	
	if (curr == null)
	    return "";
	
	for (int i = 0; i < numOfTabs; i++)
	    output += "\t";
	
	if (curr.isFile)
	    output += "- " + curr.getName() + "\n";
	else
	    output += "|- " + curr.getName() + "\n";
	
	if (curr.getLeft() != null)
	    output += printDirectoryTree(curr.getLeft(), numOfTabs+1);
	if (curr.getMiddle() != null)
	    output += printDirectoryTree(curr.getMiddle(), numOfTabs+1);
	if (curr.getRight() != null)
	    output += printDirectoryTree(curr.getRight(), numOfTabs+1);
	
	return output;
    }
    
    public void printDirectoryTree(){
	System.out.print(printDirectoryTree(cursor, 0));
    }
    
    public void makeDirectory(String name) throws IllegalArgumentException, FullDirectoryException, NotADirectoryException{
	if (!(name.indexOf(' ') == -1) || !(name.indexOf('/') == -1))
	    throw new IllegalArgumentException("'name' is invalid, please don't use spaces or forward slashes");
	DirectoryNode newChild = new DirectoryNode( name, cursor, false);
	cursor.addChild(newChild);
    }

    public void makeFile(String name) throws IllegalArgumentException, FullDirectoryException, NotADirectoryException{
	if (!(name.indexOf(' ') == -1) || !(name.indexOf('/') == -1))
	    throw new IllegalArgumentException("'name' is invalid, please don't use spaces or forward slashes");
	DirectoryNode newChild = new DirectoryNode( name, cursor, true);
	cursor.addChild(newChild);
    }
}
