#!/bin/sh

# invoke the normal test script
. ./test.sh


echo -n "Automated user session removing member \"Test20000\": "
MEMBER_COUNT=$(run_with_user_input "4\nTest20000\n3\n" | grep -c "Removing")
if [ $MEMBER_COUNT -ne 1 ]
then
    echo "FAIL"
    exit 4
fi
echo "OK"

EXP=$(($EXP - 1 ))
echo -n "Automated user session checking $EXP members exist: "
MEMBER_COUNT=$(run_with_user_input "2\n3\n" | grep -c "Member:")
if [ $MEMBER_COUNT -ne $EXP ]
then
    echo "FAIL"
    exit 2
fi
echo "OK"

echo -n "Automated user session removing members \"Test1234*\": "
MEMBER_COUNT=$(run_with_user_input "4\nTest1234\n3\n" | grep -c "Removing")
if [ $MEMBER_COUNT -ne 1 ]
then
    echo "FAIL"
    exit 4
fi
echo "OK"

EXP=$(($EXP - 11 ))
echo -n "Automated user session checking $EXP members exist: "
MEMBER_COUNT=$(run_with_user_input "2\n3\n" | grep -c "Member:")
if [ $MEMBER_COUNT -ne $EXP ]
then
    echo "FAIL"
    run_with_user_input "2\n3\n" | grep -c "Member:" 
    exit 2
fi
echo "OK"



