(ns swagger-autotest.specs
  (:require [clojure.spec :as s]
            [clojure.spec.test :as stest]))

(def url-pattern #"(?i)^(?:(?:https?)://)(?:\S+(?::\S*)?@)?(?:(?!(?:10|127)(?:\.\d{1,3}){3})(?!(?:169\.254|192\.168)(?:\.\d{1,3}){2})(?!172\.(?:1[6-9]|2\d|3[0-1])(?:\.\d{1,3}){2})(?:[1-9]\d?|1\d\d|2[01]\d|22[0-3])(?:\.(?:1?\d{1,2}|2[0-4]\d|25[0-5])){2}(?:\.(?:[1-9]\d?|1\d\d|2[0-4]\d|25[0-4]))|(?:(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)(?:\.(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)*(?:\.(?:[a-z\u00a1-\uffff]{2,}))\.?)(?::\d{2,5})?(?:[/?#]\S*)?$")
(s/def ::url (s/and string? #(re-matches url-pattern %)))

(s/fdef swagger-autotest.core/construct-base-url
        :args (s/cat :config string?))
;; (stest/instrument 'swagger-autotest.core/construct-base-url)

#_(s/fdef discuss.utils.common/trim-and-normalize
        :args (s/cat :str string?)
        :ret string?
        :fn #(<= (-> % :ret count) (-> % :args :str count)))


;; (s/exercise-fn `discuss.utils.common/trim-and-normalize)
;; (stest/abbrev-result (first (stest/check `discuss.utils.common/trim-and-normalize)))
