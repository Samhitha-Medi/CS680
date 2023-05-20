package edu.umb.cs680.hw08.fs;

import java.time.LocalDateTime;

public class Link extends FSElement{
    private FSElement target;
    Link(Directory parent, String name, int size, LocalDateTime creationTime,FSElement target) {
        super(parent, name, 0, creationTime);
        this.target=target;
    }

    public FSElement getTargetvalue(){
        return target;
    }

    @Override
    public void accept(FSVisitor v) {
        v.visit(this);

    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public boolean isFile() {
        return false;
    }
}
