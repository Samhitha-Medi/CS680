package edu.umb.cs680.hw14.fs.util;

import edu.umb.cs680.hw14.fs.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileSearchVisitorTest {
    static FileSystem fs;
    @BeforeAll
    public static void setUpFs(){
        fs= TextFixtureInitialiser.createFS() ;
    }

    @Test
    public void test_CountingVisitor() {
        Directory d1 = fs.getRootDirs().get(0);
        FileSearchVisitor visitor = new FileSearchVisitor("example.txt");
        d1.accept( visitor );
        int d=visitor.getFoundFiles().size();
        assertEquals(0,d);
        FileSearchVisitor v = new FileSearchVisitor("x");
        d1.accept( v );
        int a=v.getFoundFiles().size();
        assertEquals(1,a);
    }


}