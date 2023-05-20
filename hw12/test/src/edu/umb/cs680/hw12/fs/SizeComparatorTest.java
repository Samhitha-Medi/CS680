package edu.umb.cs680.hw12.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class SizeComparatorTest {
    static FileSystem fs;
    @BeforeAll
    public static void setUpFs(){
        fs= TextFixtureInitialiser.createFS() ;
    }

    @Test
    public void test_getchildren() {
        Directory d1 = fs.getRootDirs().get(0);
        int exp[]={0,0,0,0,10};
        LinkedList<FSElement> c=d1.getChildren(new SizeComparator());
       // System.out.println(c.get(4).getName());
        assertEquals(exp[4],c.get(4).getSize());
    }
    @Test
    public void test_getFiles() {
        Directory d1 = fs.getRootDirs().get(0);
        int exp[]={20,30};
        LinkedList<Directory>c=d1.getSubDirectories(new SizeComparator());
        LinkedList<File> f=c.get(1).getFiles(new SizeComparator());
        assertEquals(exp[0],f.get(0).getSize());
    }



}