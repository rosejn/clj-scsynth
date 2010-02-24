(defproject clj-scsynth "1.0.0-SNAPSHOT"
  :description "Supercollider scsynth bindings"
  :dependencies [[org.clojure/clojure "1.1.0"]
                 [org.clojure/clojure-contrib "1.1.0"]
                 [byte-spec "0.1"]
                 [clj-native "0.6.0-SNAPSHOT"]] 
  :native-dependencies [[scsynth "3.3.1"]]
  :dev-dependencies [[native-deps "1.0.0"]
                     [lein-clojars "0.5.0-SNAPSHOT"]
                     [autodoc "0.7.0"]
                     [jline "0.9.94"]
                     [org.clojars.ato/nailgun "0.7.1"]
                     [lein-nailgun "0.1.0"]
                     [swank-clojure "1.1.0-SNAPSHOT"]
                     [leiningen/lein-swank "1.1.0"]])