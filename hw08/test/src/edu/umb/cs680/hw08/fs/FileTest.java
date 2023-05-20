package edu.umb.cs680.hw08.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {
    static FileSystem fs;
    @BeforeAll
    public static void setUpFs(){
        fs=TextFixtureInitialiser.createFS() ;
    }

    private String[] fileToStringArray(File f){
        String fileInfo[]={f.getParent().getName(),f.getName(), String.valueOf(f.getSize()), String.valueOf(f.getCreationTime())};
        return fileInfo;
    }

    @Test
    public void verifyFileEquality(){
        String[]  ex1={"prjRoot","x","30",String.valueOf(TextFixtureInitialiser.lt)};
        Directory d1=TextFixtureInitialiser.fs.getRootDirs().get(0);
        LinkedList<FSElement> childrens=d1.getChildren();
        assertArrayEquals(ex1,fileToStringArray((File) childrens.get(3)));
    }

    @Test
    public void test_isFile(){
        Directory d1=fs.getRootDirs().get(0);
        LinkedList<Directory> sd=d1.getSubDirectories();
        LinkedList<File> f=sd.get(0).getFiles();
        assertTrue(f.get(0).isFile());
        assertTrue(f.get(1).isFile());
    }

}