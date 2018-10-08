#!/bin/bash

SESSION_LOG=session.log

echo -n "Removing existing 'database' members.data: "
rm -f members.data $SESSION_LOG
if [ $? -ne 0 ] ; then echo FAIL; exit 1 ; fi
echo "OK"


JAVA_FILES=$(find net -name "*.java")
echo -n "Compiling java files: "
#echo "  ${JAVA_FILES}"
javac  -Xlint:unchecked ${JAVA_FILES}  >> $SESSION_LOG
if [ $? -ne 0 ] ; then echo FAIL; exit 1 ; fi
echo "OK"

run_with_user_input() {
    echo -e "$*" | java net.supermegacorp.orgmanager.main.MemberSystemMain
    if [ $? -ne 0 ] ; then
        echo "Failed running program with the following user input:"
        echo "$*"
        exit 1 ;
    fi
}

echo -n "Automated user session adding 3 members: " 
run_with_user_input "$(cat test/user_input.txt)\n3\n" >> $SESSION_LOG
echo "OK"

echo -n "Automated user session checking 3 members exist: "
MEMBER_COUNT=$(run_with_user_input "2\n3\n" | grep -c "Member:")
if [ $MEMBER_COUNT -ne 3 ]
then
    echo "FAIL"
    exit 2
fi
echo "OK"

CNT=20000
echo -n "Automated user session adding $CNT more members: " 
for i in $(seq 1 $CNT)
do
    echo -e "1\nTest$i Testson\ntest$i@mega.com"
    if [ $i -eq $CNT ]; then echo -e "3\n" ; fi
done | java net.supermegacorp.orgmanager.main.MemberSystemMain  >> $SESSION_LOG
echo "OK"


EXP=$(($CNT + 3 ))
echo -n "Automated user session checking $EXP members exist: "
MEMBER_COUNT=$(run_with_user_input "2\n3\n" | grep -c "Member:")
if [ $MEMBER_COUNT -ne $EXP ]
then
    echo "FAIL"
    exit 2
fi
echo "OK"

