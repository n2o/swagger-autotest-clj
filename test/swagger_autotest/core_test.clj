(ns swagger-autotest.core-test
  (:require [clojure.test :refer :all]
            [clojure.spec :as s]
            [swagger-autotest.core :refer :all]))

(def test-config
  (load-config "swagger.yml"))


;; -----------------------------------------------------------------------------
;; Tests

(deftest test-base-url
  (testing "Get base-route from configuration"
    (let [url (construct-base-url test-config)]
      (is (= "http://localhost:4284/api" url)))))

(deftest test-prepare-query
  (testing "Given an entry form the configuration, extract and reformat all information"
    ))
