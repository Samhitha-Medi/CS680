package edu.umb.cs680.hw08.fs.util;

import edu.umb.cs680.hw08.fs.Directory;
import edu.umb.cs680.hw08.fs.File;
import edu.umb.cs680.hw08.fs.FileSystem;
import edu.umb.cs680.hw08.fs.TextFixtureInitialiser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class FileCrawlingVisitorTest {
    static FileSystem fs;
    @BeforeAll
    public static void setUpFs(){
        fs= TextFixtureInitialiser.createFS() ;
    }

    @Test
    public void test_FileCrawlingVisitor(){
        Directory d1=fs.getRootDirs().get(0);
        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        d1.accept( visitor );
        LinkedList<File>file=visitor.getFiles();
        System.out.println(file);
        assertEquals("x",file.get(4).getName());
        assertEquals("a",file.get(0).getName());
    }

}