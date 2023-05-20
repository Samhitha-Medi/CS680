package edu.umb.cs680.hw08.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {
    static FileSystem fs;
    @BeforeAll
    public static void setUpFs(){
        fs=TextFixtureInitialiser.createFS() ;
    }

    @Test
    public void test_link(){
        Directory d1=fs.getRootDirs().get(0);
        LinkedList<FSElement> child=d1.getChildren();
        Link a= (Link) child.get(4);
        //assertEquals("src",a.getTargetvalue().getName());
        String b=a.getTargetvalue().getName();
        assertEquals("src",b);
        assertEquals("y",a.getName());
    }

}