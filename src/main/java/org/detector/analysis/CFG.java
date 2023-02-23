package org.detector.analysis;

import java.util.ArrayList;

public class CFG {

    ArrayList<BasicBlock> blocks;
    BasicBlock entry;

    public CFG() {
        this.blocks = new ArrayList<>();
    }

}
