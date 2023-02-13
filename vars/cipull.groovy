package com.nithin.jenkinspipeline

def checkOutFrom(repo) {
  
  git credentialsId: 'GitHubID', url: "https://github.com/nitinperala/${repo}"
}

return this
