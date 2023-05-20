package edu.umb.cs680.hw14.fs.util;

import edu.umb.cs680.hw14.fs.*;
import edu.umb.cs680.hw14.fs.TextFixtureInitialiser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingVisitorTest {
    static FileSystem fs;
    @BeforeAll
    public static void setUpFs(){
        fs= TextFixtureInitialiser.createFS() ;
    }

    @Test
    public void test_CountingVisitor(){
        Directory d1=fs.getRootDirs().get(0);
        CountingVisitor visitor = new CountingVisitor();
        d1.accept( visitor );
        int d=visitor.getDirNum();
        int f= visitor.getFileNum();
        int l=visitor.getLinkNum();
        assertEquals(5,d);
        assertEquals(5,f);
        assertEquals(1,l);
    }


}