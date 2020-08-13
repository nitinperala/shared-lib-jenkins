#!/usr/bin/groovy
def call(Map pipelineParams)
{
        node {
        def mvnHome
        stage('Preparation') { // for display purposes
            // Get some code from a GitHub repository
        //git 'https://github.com/nitinperala/RunnableJar.git'
            def chckOut = new cipull()
            chckOut.checkOutFrom(pipelineParams.repo)
            
            // Get the Maven tool.
            // ** NOTE: This 'M3' Maven tool must be configured
            // **       in the global configuration.
            mvnHome = tool 'Maven'
        }
         stage('Build') {
        // Run the maven build
        new mvnbuild.buildcmd(pipelineParams.mvnbuild,mvnHome)
        
    }
    }
}