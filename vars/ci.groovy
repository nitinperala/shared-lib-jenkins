package com.nithin.jenkinspipeline

def call(Map pipelineParams)
{
        node {
        def mvnHome
        stage('Preparation') { // for display purposes
            // Get some code from a GitHub repository
        //git 'https://github.com/nitinperala/RunnableJar.git'
            def chckOut = new cipull()
            chckOut.checkOutFrom('RunnableJar.git')
            
            // Get the Maven tool.
            // ** NOTE: This 'M3' Maven tool must be configured
            // **       in the global configuration.
            mvnHome = tool 'Maven'
        }
    }
}