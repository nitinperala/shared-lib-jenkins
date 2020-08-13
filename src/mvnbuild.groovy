 #!/usr/bin/groovy
def call(mvncmd,mvnHome)
{
    
    withEnv(["MVN_HOME=${mvnHome}"]) {
                if (isUnix()) {
                    sh '"${mvnHome}/bin/mvn" -Dmaven.test.failure.ignore ${mvncmd}'
                } else {
                    bat(/"%${mvnHome}%\bin\mvn" -Dmaven.test.failure.ignore ${mvncmd}/)
                }
    }
}