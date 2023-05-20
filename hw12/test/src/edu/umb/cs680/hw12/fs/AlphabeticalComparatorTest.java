package edu.umb.cs680.hw12.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class AlphabeticalComparatorTest {
    static FileSystem fs;
    @BeforeAll
    public static void setUpFs(){
        fs= TextFixtureInitialiser.createFS() ;
    }

    @Test
    public void test_getchildren() {
        Directory d1 = fs.getRootDirs().get(0);
        String exp[]={"lib","src","test","x"};
        LinkedList<FSElement>c=d1.getChildren(new AlphabeticalComparator());
        assertEquals(exp[3],c.get(3).getName());
    }
    @Test
    public void test_getSubd() {
        Directory d1 = fs.getRootDirs().get(0);
        String exp[]={"lib","src","test"};
        LinkedList<Directory>c=d1.getSubDirectories(new AlphabeticalComparator());
        assertEquals(exp[2],c.get(2).getName());
    }
    @Test
    public void test_getFiles() {
        Directory d1 = fs.getRootDirs().get(0);
        String exp[]={"a","b"};
        LinkedList<Directory>c=d1.getSubDirectories(new AlphabeticalComparator());
        LinkedList<File> f=c.get(1).getFiles(new AlphabeticalComparator());
        assertEquals(exp[1],f.get(1).getName());
    }


}