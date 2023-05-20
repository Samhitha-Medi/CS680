package edu.umb.cs680.hw08.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest {
    static FileSystem fs;
    @BeforeAll
    public static void setUpFs(){
        fs=TextFixtureInitialiser.createFS() ;
    }

    @Test

    public void test_getRootDir(){
        Directory d1=fs.getRootDirs().get(0);
        assertEquals("prjRoot",d1.getName());
    }


    @Test
    public void test_instances(){
        FileSystem a1=FileSystem.getFileSystem();
        FileSystem b1=FileSystem.getFileSystem();
        assertSame(a1,b1);
        assertNotNull(a1);
    }



}