/**
 * The <code>DirectoryTree</code> class implement a ternary tree of <code>DirectoryNode</code>s. It provides
 * an implementation for the operations defined for the system.
 *
 *
 * @author Piotr Milewski
 *    email: piotr.milewski@stonybrook.edu
 *    Stony Brook ID: 112291666
 **/

import java.io.*;

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
	if (pass != null && name.equals(pass.getName())){
	    found = true;
	    if (pass.isFile()){
		try{
		    throw new NotADirectoryException("Cannot change directory into a file.");
		}
		catch (NotADirectoryException nade){
		    System.out.println(nade);
		}
	    }
	    else{
		cursor = pass;
	    }
	}
	return found;
    }

    public void changeDirectory(String name) throws NotADirectoryException{
	boolean found = false;
	if (cursor.isFile()){ //if cursor is not a directory
	    try{
		throw new NotADirectoryException();
	    }
	    catch (NotADirectoryException nade){
		System.out.println(nade);
	    }
	}
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
	    try{
		throw new NotADirectoryException("No such directory named '" + name + "'.");
	    }
	    catch (NotADirectoryException nade){
		System.out.println(nade);
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
	if (!(name.indexOf(' ') == -1) || !(name.indexOf('/') == -1)){
	    try{
		throw new IllegalArgumentException(name + "is invalid, please don't use spaces or forward slashes");
	    }
	    catch (IllegalArgumentException iae){
		System.out.println(iae);
	    }
	}
	
	DirectoryNode newChild = new DirectoryNode( name, cursor, false);
	cursor.addChild(newChild);
    }

    public void makeFile(String name) throws IllegalArgumentException, FullDirectoryException, NotADirectoryException{
	if (!(name.indexOf(' ') == -1) || !(name.indexOf('/') == -1)){
	    try{
		throw new IllegalArgumentException(name + "is invalid, please don't use spaces or forward slashes");
	    }
	    catch (IllegalArgumentException iae){
		System.out.println(iae);
	    }
	}
	DirectoryNode newChild = new DirectoryNode( name, cursor, true);
	cursor.addChild(newChild);
    }
}
