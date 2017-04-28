(defproject swagtest "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha16"]
                 [org.clojure/test.check "0.9.0"]
                 [io.forward/yaml "1.0.6"]
                 [clj-http "3.4.1"]
                 [com.velisco/strgen "0.1.4"]]
  :plugins [[lein-ancient "0.6.10"]
            [lein-kibit "0.1.3"]
            [lein-set-version "0.4.1"]]
  :main ^:skip-aot swagtest.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
