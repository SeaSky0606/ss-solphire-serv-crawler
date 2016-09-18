#!/bin/sh
print_usage ()
{
  echo "Usage: sh run.sh COMMAND"
  echo "where COMMAND is one of the follows:"
  echo "weixin [-quartz] [-once] [-type (all|page)]"
  echo "itaogao [-quartz] [-once] [-site (tmtpost|jingji21)] [-type (tag|pagesize)]"
  exit 1
}

if [ $# = 0 ] || [ $1 = "help" ]; then
  print_usage
fi

JARNAME=`ls|grep 'dependencies.jar'`

COMMAND=$1
shift
params=$@

if [ "$JAVA_HOME" = "" ]; then
  echo "Error: JAVA_HOME is not set."
  exit 1
fi 

JAVA=$JAVA_HOME/bin/java
HEAP_OPTS="-Xmx1000m"

CLASSPATH=.:conf
CLASSPATH=${CLASSPATH}:`ls |grep jar`

for f in lib/*.jar; do
  CLASSPATH=${CLASSPATH}:$f;
done
if [ "$COMMAND" = "hello1" ];then
  CLASS=cli.Hello1
elif [ "$COMMAND" = "hello2" ];then
  CLASS=cli.Hello2
else
  CLASS=$COMMAND
fi

"$JAVA" -Djava.awt.headless=true $HEAP_OPTS -classpath "$CLASSPATH" $CLASS $params

