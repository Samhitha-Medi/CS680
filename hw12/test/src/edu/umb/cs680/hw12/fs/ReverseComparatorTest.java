package edu.umb.cs680.hw12.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ReverseComparatorTest {
    static FileSystem fs;
    @BeforeAll
    public static void setUpFs(){
        fs= TextFixtureInitialiser.createFS() ;
    }

    @Test
    public void test_getchildren() {
        Directory d1 = fs.getRootDirs().get(0);
        String exp[]={"y","x","test","src","lib"};
        LinkedList<FSElement> c=d1.getChildren(new ReverseComparator());
        assertEquals(exp[3],c.get(3).getName());
    }
    @Test
    public void test_getSubd() {
        Directory d1 = fs.getRootDirs().get(0);
        String exp[]={"test","src","lib"};
        LinkedList<Directory>c=d1.getSubDirectories(new ReverseComparator());
        assertEquals(exp[2],c.get(2).getName());
    }
    @Test
    public void test_getFiles() {
        Directory d1 = fs.getRootDirs().get(0);
        String exp[]={"b","a"};
        LinkedList<Directory>c=d1.getSubDirectories(new ReverseComparator());
        LinkedList<File> f=c.get(1).getFiles(new ReverseComparator());
        assertEquals(exp[1],f.get(1).getName());
    }



}