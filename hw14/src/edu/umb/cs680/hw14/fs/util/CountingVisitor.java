package edu.umb.cs680.hw14.fs.util;

import edu.umb.cs680.hw14.fs.*;

public class CountingVisitor implements FSVisitor {
        int dirNum=0,fileNum=0,linkNum=0;
        @Override
        public void visit(Link link) {
            linkNum++;

        }

        @Override
        public void visit(Directory dir) {
            dirNum++;

        }

        @Override
        public void visit(File file) {
            fileNum++;
        }
        public int getDirNum(){
            return dirNum;
        }
        public int getFileNum(){
            return fileNum;
        }
        public int getLinkNum(){
            return linkNum;
        }
    }


