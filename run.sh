#!/bin/sh
rm -rf bin/ && mkdir bin;
find . -name "*.java" > srcs.txt;
javac -sourcepath src @srcs.txt -d ./bin;
java -classpath bin/ com.mmacheli.avaj.Application input.txt;
