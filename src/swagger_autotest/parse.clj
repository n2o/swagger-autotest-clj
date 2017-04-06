(ns swagger-autotest.parse
  (:require [yaml.core :as yaml]
            [clojure.walk :refer [keywordize-keys]]))

(defn load-config [path]
  (keywordize-keys (yaml/from-file path)))

(defn construct-base-url [config]
  (when-not (nil? (:host config))
    (str (first (:schemes config)) "://"
         (:host config)
         (:basePath config))))

(def config
  (load-config "swagger.yml"))

(def base
  (construct-base-url config))
;; (base y)
;; (second (first (:paths config)))
