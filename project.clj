(defproject swagger-autotest "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha15"]
                 [org.clojure/test.check "0.9.0"]
                 [io.forward/yaml "1.0.6"]
                 [clj-http "3.4.1"]]
  :plugins [[lein-ancient "0.6.10"]
            [com.jakemccrary/lein-test-refresh "0.19.0"]]
  :main ^:skip-aot swagger-autotest.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
