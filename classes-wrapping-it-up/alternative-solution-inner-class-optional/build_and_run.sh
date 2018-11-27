#!/bin/bash

# clean-up first
find . -name '*.class' | xargs rm 2> /dev/null

javac org/juneday/main/TestTime.java && java -ea org.juneday.main.TestTime
