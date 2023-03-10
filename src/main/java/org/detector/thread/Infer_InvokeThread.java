package org.detector.thread;

import org.detector.util.OSUtil;
import org.detector.util.Invoker;
import org.detector.util.Utility;

import java.io.File;
import java.util.List;

import static org.detector.util.Utility.DEBUG;
import static org.detector.util.Utility.classFolder;
import static org.detector.util.Utility.inferJarStr;
import static org.detector.util.Utility.reportFolder;

public class Infer_InvokeThread implements Runnable {

    private int iterDepth;
    private String seedFolderPath;
    private String seedFolderName;

    public Infer_InvokeThread(int iterDepth, String seedFolderPath, String seedFolderName) {
        this.iterDepth = iterDepth;
        this.seedFolderPath = seedFolderPath;
        this.seedFolderName = seedFolderName;
    }

    @Override
    public void run() {
        List<String> filePaths = Utility.getFilenamesFromFolder(seedFolderPath + File.separator + seedFolderName, true);
        if(DEBUG) {
            System.out.println("InvokeT Path:" + seedFolderPath + " Name:" + seedFolderName + " Size:" + filePaths.size());
        }
        for(int i = 0; i < filePaths.size(); i++) {
            String srcJavaPath = filePaths.get(i);
            String filename = Utility.Path2Last(srcJavaPath);
            String reportFolderPath = reportFolder + File.separator + "iter" + iterDepth + "_" + filename;
            String cmd = "\"" + Utility.INFER_PATH + " run -o " + reportFolderPath + " -- " + Utility.JAVAC_PATH +
                    " -d " + classFolder.getAbsolutePath() + File.separator + filename +
                    " -cp " + inferJarStr + " " + srcJavaPath + "\"";
            String[] invokeCmds = new String[3];
            if(OSUtil.isWindows()) {
                invokeCmds[0] = "cmd.exe";
                invokeCmds[1] = "/c";
            } else {
                invokeCmds[0] = "/bin/bash";
                invokeCmds[1] = "-c";
            }
            invokeCmds[2] = "python3 cmd.py " + cmd;
            File file = new File(reportFolderPath);
            file.mkdir();
            Invoker.invokeCommandsByZT(invokeCmds);
        }
    }

}
