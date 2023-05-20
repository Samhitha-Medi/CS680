package edu.umb.cs680.hw12.fs.util;

import edu.umb.cs680.hw12.fs.*;

import java.util.LinkedList;

public class FileCrawlingVisitor implements FSVisitor {
    LinkedList<File>files=new LinkedList<>();
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
        this.files.add(file);

    }
    public LinkedList<File> getFiles(){
        return files;
    }
}
