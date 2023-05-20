package edu.umb.cs680.hw14.fs;


import java.util.LinkedList;
import java.util.Objects;

public class FileSystem {
    private static FileSystem instance=null;
    private FileSystem(){}
    private LinkedList<Directory> rd;


    public static FileSystem getFileSystem() {
        try{
            return Objects.requireNonNull(instance);
        }
        catch(NullPointerException ex){
            instance = new FileSystem();
            return instance;
        }
    }

    public LinkedList<Directory> getRootDirs(){
        return this.rd;
    }
    public void appendRoot(Directory root){
        rd=new LinkedList<>();
        this.rd.add(root);
    }

}

