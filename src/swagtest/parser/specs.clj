(ns swagtest.parser.specs
  (:require [clojure.spec.alpha :as s]
            [clojure.spec.gen.alpha :as gen]
            [clojure.spec.test.alpha :as stest]
            [miner.strgen :as sg]))

(def url-pattern #"https?://[A-Za-z]+\.[A-Za-z]+(:[0-9]+)?(/.+)*")
(s/def ::url (s/spec (s/and string? #(re-matches url-pattern %))
                     :gen #(sg/string-generator url-pattern)))

(s/fdef swagtest.parser.yaml/construct-base-url
        :ret ::url)

(s/def ::method #{:get :post :put :delete})

(s/def ::$ref (s/and string? #(.startsWith % "#/definitions/")))
(s/def ::schema (s/keys :req-un [::$ref]))

(s/def ::description string?)

(s/def ::desc-schema (s/keys :req-un [::description ::schema]))

(s/def ::response (s/cat :http-code keyword? :desc-schema ::desc-schema))
(s/def ::responses (s/coll-of ::response))
(s/def ::entry (s/keys :req-un [::url ::method ::responses]))

(def entry {:url "http://foo.bar"
            :method :get
            :responses [[:200 {:description "foo"
                               :schema {:$ref "#/definitions/hello"}}]]})

(s/fdef swagtest.parser.yaml/convert-entry
        :ret ::entry)
;; (stest/instrument 'swagtest.parser.yaml/convert-entry)
;; (s/exercise-fn `swagtest.parser.yaml/convert-entry)
;; (stest/abbrev-result (first (stest/check `swagtest.parser.yaml/convert-entry)))



;; (stest/instrument 'swagtest.parser.yaml/construct-base-url)
;; (s/exercise-fn `swagtest.parser.yaml/construct-base-url 100)
;; (stest/abbrev-result (first (stest/check `swagtest.parser.yaml/construct-base-url)))
