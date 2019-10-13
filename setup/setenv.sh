first step
run this in a terminal

export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home

export PATH=$PATH:/Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/bin

export CLASSPATH=/Users/lila/Desktop/tomcat/lib/servlet-api.jar

export ANT_HOME=/Users/lila/Desktop/tomcat

export TOMCAT_HOME=/Users/lila/Desktop/tomcat

export CATALINA_HOME=/Users/lila/Desktop/tomcat

second step
start tomcat

build.sh and do your work

remember touch web.xml to get it to show

# conf/server.xml - modified since your machine is weird
#    <Connector port="8082" protocol="HTTP/1.1"
#                connectionTimeout="20000"
#                redirectPort="8443" />