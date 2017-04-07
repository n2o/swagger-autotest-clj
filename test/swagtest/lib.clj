(ns swagtest.test.lib
  (:require [clojure.pprint :as pprint]
            [clojure.test :refer [is]]))

(defn- summarize-results' [spec-check]
  (map #(-> % :clojure.test.check/ret pprint/pprint) spec-check))

(defn check' [spec-check]
  (is (nil? (-> spec-check first :failure)) (summarize-results' spec-check)))
