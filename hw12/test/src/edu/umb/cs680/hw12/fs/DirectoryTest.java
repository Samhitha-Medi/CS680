package edu.umb.cs680.hw12.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {
    static FileSystem fs;
    @BeforeAll
    public static void setUpFs(){
        fs=TextFixtureInitialiser.createFS() ;
    }

    private String[] dirToStringArray(Directory d){
        String dirInfo[]={d.getName(), String.valueOf(d.getSize()), String.valueOf(d.getCreationTime())};
        return dirInfo;
    }

    @Test
    public void verifydirectoryEquality(){
        String[]  ex1={"prjRoot","0",String.valueOf(TextFixtureInitialiser.lt)};
        Directory ac1=TextFixtureInitialiser.fs.getRootDirs().getFirst();
        assertArrayEquals(ex1,dirToStringArray(ac1));
    }

    @Test
    public void test_getChildren(){
        Directory d1=TextFixtureInitialiser.fs.getRootDirs().get(0);
        LinkedList<FSElement> cd=d1.getChildren();
        String ex[]={"src","lib","test","x"};
        assertEquals(ex[2],cd.get(2).getName());
    }

    @Test
    public void test_countChildren(){
        Directory b1=TextFixtureInitialiser.fs.getRootDirs().get(0);
        int exp=4;
        assertEquals(exp,b1.countChildren());
    }


    @Test
    public void test_isDirectory(){
        Directory d1=fs.getRootDirs().get(0);
        assertTrue(d1.isDirectory());
    }

    @Test
    public void test_getSubd(){
        Directory d1=fs.getRootDirs().get(0);
        LinkedList<Directory> sd=d1.getSubDirectories();
        assertEquals("lib",sd.get(0).getName());
    }

    @Test
    public void test_getFile(){
        Directory d1=fs.getRootDirs().get(0);
        LinkedList<Directory> sd=d1.getSubDirectories();
        LinkedList<File> f=sd.get(0).getFiles();
        assertEquals("c",f.get(0).getName());

    }

}