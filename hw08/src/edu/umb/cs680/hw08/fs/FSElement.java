package edu.umb.cs680.hw08.fs;
import java.time.LocalDateTime;
import java.util.LinkedList;

public abstract class FSElement {
    Directory parent;
    String name;
    int size;
    LocalDateTime creationTime;
    public abstract void accept(FSVisitor v);
    FSElement(Directory parent,String name,int size,LocalDateTime creationTime){
        this.parent=parent;
        this.name=name;
        this.size=size;
        this.creationTime=creationTime;
        if(this.parent!=null){
            parent.appendChild(this);
        }
    }
    Directory getParent(){
        return this.parent;
    }
    public String getName(){
        return this.name;
    }
    LocalDateTime getCreationTime(){
        return this.creationTime;
    }
    void setParent(Directory directory){
        this.parent=parent;
    }
    int getSize(){
        return this.size;
    }
    void setSize(){
        this.size=size;
    }

    public abstract boolean isDirectory();
    public abstract boolean isFile();

    public static void main(String[] args) {
        Directory newdir= new Directory(null,"one",20,LocalDateTime.now());
        System.out.println(newdir.getSize());
        Directory subd=new Directory(newdir,"second",10,LocalDateTime.now());
        System.out.println(subd.getParent().name);
        File newf=new File(subd,"file",20,LocalDateTime.now());
        System.out.println(newf.getParent().name);
    }
}