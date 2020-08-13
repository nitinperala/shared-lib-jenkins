package com.nithin.jenkinspipeline

def checkOutFrom(repo) {
  git url: "git@github.com:nitinperala/${repo}"
}

return this