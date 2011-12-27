# Jenkins Build List

A very simple Clojure/Noir application which hits the Jenkins API and
lists recent builds for a particular job.

This is very much a learning exercise in writing some Clojure. Any
hints and tips much appreciated.

## Configuration

If you want to run this yourself then you'll need a properties file
called jenkins.properties in the root of the project.

```
username = "username"
password = "password"
jenkins = "http://jenkins.example.com/job/JobName"
```

## Usage

I'm assuming you've got Clojure and the Leiningen build tool installed.

```bash
lein deps
lein test
lein run
```
