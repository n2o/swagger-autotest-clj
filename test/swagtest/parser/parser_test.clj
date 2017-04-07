(ns swagtest.parser.parser-test
  (:require [clojure.test :refer :all]
            [clojure.spec :as s]
            [clojure.spec.test :as stest]
            [swagtest.parser.yaml :as yparser]
            [swagtest.test.lib]))

(def test-config
  (yparser/load-config "swagger.yml"))

;; -----------------------------------------------------------------------------
;; Tests

(deftest test-construct-base-url
  (testing "Get base-route from configuration"
    (let [url (yparser/construct-base-url test-config)]
      (is (= "http://localhost:4284/api" url))
      (tlib/check' (stest/check `swagtest.parser.yaml/construct-base-url)))))
