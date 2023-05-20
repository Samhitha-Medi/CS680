package edu.umb.cs680.hw08.fs.util;

import edu.umb.cs680.hw08.fs.Directory;
import edu.umb.cs680.hw08.fs.FSVisitor;
import edu.umb.cs680.hw08.fs.File;
import edu.umb.cs680.hw08.fs.Link;

import java.util.LinkedList;

public class FileSearchVisitor implements FSVisitor {
    String fileName;
    LinkedList<File> foundFiles=new LinkedList<>();

    public FileSearchVisitor(String s) {
        this.fileName=s;
    }

    @Override
    public void visit(Link link) {
        return;

    }

    @Override
    public void visit(Directory dir) {
        return;

    }

    @Override
    public void visit(File file) {
        if(file.getName().equals(fileName)){
            foundFiles.add(file);
        }
    }

    public LinkedList getFoundFiles(){
        return foundFiles;
    }
}
