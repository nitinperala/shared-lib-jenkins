#!/usr/bin/groovy

def checkOutFrom(repo) {
  
  git credentialsId: 'GitHub', url: "https://github.com/nitinperala/${repo}"
}

return this