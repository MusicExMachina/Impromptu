package model.rhythmTree.tests;

import model.rhythmTree.RhythmTree;
import org.junit.Test;


public class RhythmTreeTest {

    @Test
    public void createTreeFromListTest(){
        int[] rtarr = new int[6];
        rtarr[0] = 2;
        rtarr[1] = 1;
        rtarr[2] = 3;
        rtarr[3] = 1;
        rtarr[4] = 1;
        rtarr[5] = 1;
        RhythmTree rt = new RhythmTree(rtarr);
    }


}