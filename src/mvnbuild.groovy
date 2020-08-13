#!/usr/bin/groovy
def buildcmd(mvncmd,mvnHome)
{
    
    
                if (isUnix()) {
                    sh '"${mvnHome}/bin/mvn" -Dmaven.test.failure.ignore ${mvncmd}'
                } else {
                    bat(/"%${mvnHome}%\bin\mvn" -Dmaven.test.failure.ignore ${mvncmd}/)
                }
    
}