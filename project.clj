(defproject clj-scsynth "1.0.0-SNAPSHOT"
  :description "Supercollider scsynth bindings"
  :dependencies [[org.clojure/clojure "1.1.0"]
                 [org.clojure/clojure-contrib "1.1.0"]]
  :native-dependencies [[scsynth "3.3.1"]]
  :dev-dependencies [[native-deps "1.0.0"]
                     [lein-clojars "0.5.0-SNAPSHOT"]
                     [leiningen/lein-swank "1.1.0"]])
