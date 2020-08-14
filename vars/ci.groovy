#!/usr/bin/groovy
def call(body)
{
    def pipelineParams= [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()
        node {
            parameters {
        string(defaultValue: "TEST", description: 'What environment?', name: 'userFlag')
        choice(choices: ['US-EAST-1', 'US-WEST-2'], description: 'What AWS region?', name: 'region')
    }
            def mvnHome
            env.name = "nithin"
            pipelineParams['branch'] = 'master'
            stage('Preparation') { // for display purposes
                // Get some code from a GitHub repository
            //git 'https://github.com/nitinperala/RunnableJar.git'
                def chckOut = new cipull()
                chckOut.checkOutFrom(pipelineParams.repo)
                print "Name is ${env.name}"
                // Get the Maven tool.
                // ** NOTE: This 'M3' Maven tool must be configured
                // **       in the global configuration.
                mvnHome = tool 'Maven'
            }
            stage('Build') {
                // Run the maven build
                new mvnbuild().buildcmd(pipelineParams.mvnbuild,mvnHome)
            
        }
        stage('Results') {
            
            archiveArtifacts 'target/*.jar'
        }
    }
}