package edu.umb.cs680.hw14.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {
    static FileSystem fs;
    @BeforeAll
    public static void setUpFs(){
        fs= TextFixtureInitialiser.createFS() ;
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
    public void test_countChildren(){
        Directory b1=TextFixtureInitialiser.fs.getRootDirs().get(0);
        int p=b1.countChildren();
        int exp=4;
        assertEquals(exp,p);
    }


    @Test
    public void test_isDirectory(){
        Directory d1=fs.getRootDirs().get(0);
        assertTrue(d1.isDirectory());
    }


    @Test
    public void test_getchildrenAlphaComparator() {
        Directory d1 = fs.getRootDirs().get(0);
        String exp[]={"lib","src","test","x"};
        LinkedList<FSElement> c=d1.getChildren(Comparator.comparing
                ((FSElement o)-> o.getName()));
        assertEquals(exp[3],c.get(3).getName());
    }
    @Test
    public void test_getSubAlphaComparator() {
        Directory d1 = fs.getRootDirs().get(0);
        String exp[]={"lib","src","test"};
        LinkedList<Directory>c=d1.getSubDirectories(Comparator.comparing
                ((FSElement o)-> o.getName()));
        assertEquals(exp[2],c.get(2).getName());
    }
    @Test
    public void test_getFilesAlphaComparator() {
        Directory d1 = fs.getRootDirs().get(0);
        String exp[]={"a","b"};
        LinkedList<Directory>c=d1.getSubDirectories(Comparator.comparing
                ((FSElement o)-> o.getName()));
        LinkedList<File> f=c.get(1).getFiles(Comparator.comparing
                ((FSElement o)-> o.getName()));
        assertEquals(exp[1],f.get(1).getName());
    }
    @Test
    public void test_getchildrenReverseComparator() {
        Directory d1 = fs.getRootDirs().get(0);
        String exp[]={"y","x","test","src","lib"};
        LinkedList<FSElement> c=d1.getChildren(Comparator.comparing((FSElement::getName),Comparator.reverseOrder() ));
        assertEquals(exp[3],c.get(3).getName());
    }
    @Test
    public void test_getSubdReverseComparator() {
        Directory d1 = fs.getRootDirs().get(0);
        String exp[]={"test","src","lib"};
        LinkedList<Directory>c=d1.getSubDirectories(Comparator.comparing((FSElement::getName),Comparator.reverseOrder() ));
        assertEquals(exp[2],c.get(2).getName());
    }
    @Test
    public void test_getFilesReverseComparator() {
        Directory d1 = fs.getRootDirs().get(0);
        String exp[]={"b","a"};
        LinkedList<Directory>c=d1.getSubDirectories(Comparator.comparing((FSElement::getName),Comparator.reverseOrder() ));
        LinkedList<File> f=c.get(1).getFiles(Comparator.comparing((FSElement::getName),Comparator.reverseOrder() ));
        assertEquals(exp[1],f.get(1).getName());
    }
    @Test
    public void test_getchildrenSizeCcomparator() {
        Directory d1 = fs.getRootDirs().get(0);
        int exp[]={0,0,0,0,10};
        LinkedList<FSElement> c=d1.getChildren(Comparator.comparing(( FSElement e)-> e.getSize(), Comparator.naturalOrder()));
        // System.out.println(c.get(4).getName());
        assertEquals(exp[4],c.get(4).getSize());
    }
    @Test
    public void test_getFilesSizeComparator() {
        Directory d1 = fs.getRootDirs().get(0);
        int exp[]={20,30};
       LinkedList<Directory>c=d1.getSubDirectories(Comparator.comparing(( FSElement e)-> e.getSize(), Comparator.naturalOrder()));
       LinkedList<File> f=c.get(1).getFiles(Comparator.comparing(( FSElement e)-> e.getSize(), Comparator.naturalOrder()));
        assertEquals(exp[0],f.get(0).getSize());
    }



}