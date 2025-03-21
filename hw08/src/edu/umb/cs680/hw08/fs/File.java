package edu.umb.cs680.hw08.fs;
import java.time.LocalDateTime;

public class File extends FSElement{
    @Override
    public void accept(FSVisitor v) {
        v.visit(this);
    }

    File(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
    }

    public boolean isFile(){
        return true;
    }
    @Override
    public boolean isDirectory() {
        return false;
    }
}
