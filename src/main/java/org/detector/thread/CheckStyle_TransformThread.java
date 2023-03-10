package org.detector.thread;

import org.detector.analysis.TypeWrapper;
import org.detector.report.CheckStyle_Report;
import org.detector.util.OSUtil;
import org.detector.util.Invoker;
import org.detector.util.Utility;

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import static org.detector.util.Utility.CHECKSTYLE_PATH;
import static org.detector.util.Utility.CheckStyleConfigPath;
import static org.detector.util.Utility.DEBUG;
import static org.detector.util.Utility.Path2Last;
import static org.detector.util.Utility.reportFolder;
import static org.detector.transform.Transform.singleLevelExplorer;

public class CheckStyle_TransformThread implements Runnable {

    private int currentDepth;
    private String seedFolderName;
    private ArrayDeque<TypeWrapper> wrappers;
    private String configPath;

    public CheckStyle_TransformThread(TypeWrapper initWrapper, String seedFolderName, String configPath) {
        this.currentDepth = 0;
        this.seedFolderName = seedFolderName;
        this.wrappers = new ArrayDeque<>() {
            {
                add(initWrapper);
            }
        };
        this.configPath = configPath;
    }

    @Override
    public void run() {
        for (int depth = 1; depth <= Utility.SEARCH_DEPTH; depth++) {
            if (DEBUG) {
                System.out.println("TransformThread Depth: " + depth + " Folder: " + this.seedFolderName);
            }
            singleLevelExplorer(this.wrappers, this.currentDepth++);
            String mutantFolderPath = Utility.mutantFolder + File.separator + "iter" + depth + File.separator + seedFolderName;
            List<String> mutantFilePaths = Utility.getFilenamesFromFolder(mutantFolderPath, true);
            File configFile = new File(configPath);
            if (configFile.exists()) {
                configPath = CheckStyleConfigPath + File.separator + seedFolderName + 0 + ".xml";
            }
            for (int i = 0; i < mutantFilePaths.size(); i++) {
                String mutantFilePath = mutantFilePaths.get(i);
                String mutantFileName = Path2Last(mutantFilePath);
                String reportFilePath = reportFolder + File.separator + "iter" + depth + "_" + mutantFileName + ".txt";
                String[] invokeCommands = new String[3];
                if (OSUtil.isWindows()) {
                    invokeCommands[0] = "cmd.exe";
                    invokeCommands[1] = "/c";
                } else {
                    invokeCommands[0] = "/bin/bash";
                    invokeCommands[1] = "-c";
                }
                invokeCommands[2] = "java -jar " + CHECKSTYLE_PATH + " -f" + " plain" + " -o " + reportFilePath + " -c "
                        + configPath + " " + mutantFilePath;
                if (DEBUG) {
                    System.out.println(invokeCommands[2]);
                }
                Invoker.invokeCommandsByZT(invokeCommands);
                Utility.readCheckStyleResultFile(reportFilePath);
            }
            List<TypeWrapper> validWrappers = new ArrayList<>();
            while (!wrappers.isEmpty()) {
                TypeWrapper head = wrappers.pollFirst();
                if (!head.isBuggy()) { // if this mutant is buggy, then we should switch to next mutant
                    validWrappers.add(head);
                }
            }
            wrappers.addAll(validWrappers);
        }
    }

}
