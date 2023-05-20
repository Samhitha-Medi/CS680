package edu.umb.cs680.hw14.fs;


import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Directory extends FSElement {
    private LinkedList<FSElement> children=new LinkedList<>();


    @Override
    public void accept(FSVisitor v) {
        v.visit(this);
        for(FSElement e:children){
            e.accept(v);
        }

    }

    Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, 0, creationTime);
    }
    public LinkedList<FSElement> getChildren(){
        return children;

    }
    public LinkedList<FSElement>getChildren(Comparator<FSElement> comparator){
        LinkedList<FSElement> c=getChildren();
        Collections.sort(c,comparator);
        return children;
    }
    void appendChild(FSElement child){
        this.children.add(child);
        //child.setParent(this);
        Collections.sort(children,Comparator.comparing
                ((FSElement o)-> o.getName()));

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
    public LinkedList<Directory>getSubDirectories(Comparator<FSElement>comparator){
        LinkedList<Directory> sd=new LinkedList<>();
        sd=getSubDirectories();
        Collections.sort(sd,comparator);
        return sd;
    }

    LinkedList<File> getFiles(){
        LinkedList<File>f=new LinkedList<File>();
        for(FSElement a:getChildren())
            if(a instanceof File)
                f.add((File)a);
        return f;

    }
    public LinkedList<File> getFiles(Comparator<FSElement>comparator){
        LinkedList<File>f=new LinkedList<>();
        f=getFiles();
        Collections.sort(f,comparator);
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

