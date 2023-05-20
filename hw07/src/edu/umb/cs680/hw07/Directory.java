package edu.umb.cs680.hw07;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {
    private LinkedList<FSElement> children=new LinkedList<>();


    Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, 0, creationTime);
    }
    LinkedList<FSElement> getChildren(){
        return children;

    }
    void appendChild(FSElement child){
        this.children.add(child);
        //child.setParent(this);

    }
    int countChildren(){
        int fcount=0,dcount=0;
        for(FSElement a:getChildren())
        {
            if(a.isFile())
            {
                fcount++;
            } else if (a.isDirectory()) {
                dcount++;
            }
        }
        int c=fcount+dcount;
        return c;
    }
    LinkedList<Directory> getSubDirectories(){
        LinkedList<Directory>subd=new LinkedList<Directory>();
        for(FSElement a:getChildren())
            if(a instanceof Directory)
                subd.add((Directory)a);
        return subd;

    }

    LinkedList<File> getFiles(){
        LinkedList<File>f=new LinkedList<File>();
        for(FSElement a:getChildren())
            if(a instanceof File)
                f.add((File)a);
        return f;

    }
    int getTotalSize(){
        int count=0;
        for(FSElement a:getChildren()){
            if(a instanceof File){
                count+=a.getSize();
            }
            else {
                count+=((Directory)a).getTotalSize();
            }
        }
        return count;
    }
    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public boolean isFile() {
        return false;
    }

}
