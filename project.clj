(defproject jenkins-build-list "0.1.0"
            :description "List recent builds from a Jenkins project"
            :dependencies [[org.clojure/clojure "1.3.0"]
                           [noir "1.2.1"]
                           [clj-http "0.2.6"]
                           [clj-time "0.3.3"]
                           [cheshire "2.0.4"]
                          ]
            :main jenkins-build-list.server)

