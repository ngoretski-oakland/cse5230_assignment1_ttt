#!/bin/bash
echo "Building Common"
cd Assignment1TTTCommon
gradle build

echo "Building Java project"
cd ../Assignment1TTTJava
gradle fatJar

echo "Done"
