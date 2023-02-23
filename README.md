### Statfier
Statfier is an heuristic-based automatic testing tool for static analyzers. Basically, it is implemented by program transformation and metamorphic testing techniques. Until now, Satafier has found 79 bugs in known static analyzers (PMD, SpotBugs, SonarQube, CheckStyle, Infer).

This is the source code repo of Statfier. The source code files are located in the folder src, script folder contains some auxiliary programs, e.g., crawl seed files from web, seed folder contains the downloaded seed files. 

### Usage guideline

#### Project Description

1. Src folder includes source code and test cases for our project.
2. Seeds folder includes the initial input programs for our project.
3. Scripts folder incldues some tools used in our development process.
4. The pom.xml defines the third-party dependency libraries used in our project.

#### Install MVN Dependency

We use Maven 3.8.5 to build our project. Users should first install the dependency libraries using the following command:

> mvn -f pom.xml dependency:copy-dependencies

#### Install Static Analyzer

Download different static analyzers by the following links:

PMD: https://github.com/pmd/pmd/releases/tag/pmd_releases/6.51.0

SpotBugs: https://github.com/spotbugs/spotbugs/releases

CheckStyle: https://github.com/checkstyle/checkstyle/releases/

Infer: https://github.com/facebook/infer/releases/tag/v1.1.0

SonarQube: https://www.sonarqube.org/downloads/

#### Config property & Execution

Create a config file called "config.properties" in the root folder of Statifier. Define the following properties in this file:

```bash
PROJECT_PATH=/path/to/folder/of/Statfier
EVALUATION_PATH=/path/to/evaluation/folder
SEED_PATH=/path/to/input_programs
TOOL_PATH=/path/to/downloaded
JAVAC_PATH=/path/to/javac
# Level of transformation
SEARCH_DEPTH=1
# Index of random seed
SEED_INDEX=2
# Use random transform location
RANDOM_LOCATION=false
# Use report-guided transform location
GUIDED_LOCATION=true
# Select all variants
NO_SELECTION=true
# Randomly select variants
RANDOM_SELECTION=false
# Use heuristic to select variants
DIV_SELECTION=false
# Use these five tools to select static analyzer, true means selected, false means ignorance.
PMD_MUTATION=true
SPOTBUGS_MUTATION=false
CHECKSTYLE_MUTATION=false
INFER_MUTATION=false
SONARQUBE_MUTATION=false
```
First use initEnv defined in Utility.java, then use the methods defined in Schedule.java: executePMDMutation, executeSpotBugsMutation, executeCheckStyleMutation, executeInferMutation, executeSonarQubeMutation to select static analyzer and test it, for instance:

```java
Utility.initEnv();
Schedule schedule = Schedule.getInstance();
if(Utility.PMD_MUTATION) {
    schedule.executePMDMutation(Utility.sourceSeedPath);
}
```

We have provided a shell script for running the project, you can directly use this file `./run.sh` to run Statfier.

#### Procedure to setup a new static analyzer

Our methodology can be applied to other static analyzers which have analysis reports. To setup a new static analyzer, users should implements two main components: (1) Report parser; (2) Analyzer invocation. Report parser is used to calculate the number of warnings and analyzer invocation is used to generate reports by static analyzers.

The main procedure can be summarized below:

```java
String reportPath = invokeAnalyzer(inputProgramPath);
List<AnalyzerReport> reports = parseReport(reportPath);
for(AnalyzerReport report : reports) {
  TypeWrapper wrapper = new TypeWrapper(report.getSourceFilePath());
  List<String> variantPaths = wrapper.transform();
  String newReportPath = invokAnalyzer(variantPaths);
  List<AnalyzerReport> reports = parseReport(newReportPath);
  diffAnalysis(report, reports);
}
```



