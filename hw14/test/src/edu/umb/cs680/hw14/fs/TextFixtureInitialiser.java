package edu.umb.cs680.hw14.fs;

import java.time.LocalDateTime;

public class TextFixtureInitialiser {

    static Directory a,b,c,d,e;
    static File f,g,h,i,j;
    static FileSystem fs;
    static Link k;
    static LocalDateTime lt=LocalDateTime.now();

    public static FileSystem createFS(){
        fs=FileSystem.getFileSystem();
        a=new Directory(null,"prjRoot",0, lt);
        fs.appendRoot(a);
        b=new Directory(a,"src",0,lt);
        //a.appendChild(b);
        c=new Directory(a,"lib",0,lt);
        //a.appendChild(c);
        d=new Directory(a,"test",0,lt);
        //a.appendChild(d);
        f=new File(a,"x",10,lt);
        // a.appendChild(f);
        g=new File(b,"a",30,lt);
        //b.appendChild(g);
        h=new File(b,"b",20,lt);
        //b.appendChild(h);
        i=new File(c,"c",10,lt);
        //c.appendChild(i);
        e=new Directory(d,"src",0,lt);
        //d.appendChild(e);
        j=new File(e,"d",20,lt);
        //e.appendChild(j);
        k=new Link(a,"y",0,lt,e);

        return fs;
    }


}

