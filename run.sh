#!/bin/bash
echo "Building process start..."
 
JAR_PATH=/path/to/maven/target/dependency
BIN_PATH=bin
SRC_PATH=/path/to/src
 
# java file list
SRC_FILE_LIST_PATH=src/sources.list
 
# generate java list
rm -f $SRC_PATH/sources.list
find $SRC_PATH/ -name *.java > $SRC_FILE_LIST_PATH
 
# delete old bin file
rm -rf $BIN_PATH/
mkdir $BIN_PATH/
 
# generate dependency list
for file in  ${JAR_PATH}/*.jar;
do
jarfile=${jarfile}:${file}
done
echo "jarfile = "$jarfile

# Compile
javac -encoding UTF-8  -d $BIN_PATH/ -cp $jarfile @$SRC_FILE_LIST_PATH
 
# Exectuion
java -cp $BIN_PATH$jarfile org.detector.AutomaticTester &
