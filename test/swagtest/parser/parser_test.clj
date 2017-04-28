(ns swagtest.parser.parser-test
  (:require [clojure.pprint :as pprint]
            [clojure.test :refer [is deftest testing]]
            [clojure.spec.alpha :as s]
            [clojure.spec.test.alpha :as stest]
            [swagtest.parser.yaml :as yparser]))

(def test-config
  (yparser/load-config "swagger.yml"))

(defn- summarize-results' [spec-check]
  (map #(-> % :clojure.spec.test.check/ret pprint/pprint) spec-check))

(defn check' [spec-check]
  (is (nil? (-> spec-check first :failure)) (summarize-results' spec-check)))

;; -----------------------------------------------------------------------------
;; Tests

(deftest test-construct-base-url
  (testing "Get base-route from configuration"
    (let [url (yparser/construct-base-url test-config)]
      (is (= "http://localhost:4284/api" url))
      (is (nil? (yparser/construct-base-url "I am groot.")))
      #_(check' (stest/check `swagtest.parser.yaml/construct-base-url)))))
