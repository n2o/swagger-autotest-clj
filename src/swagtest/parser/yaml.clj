(ns swagtest.parser.yaml
  (:require [yaml.core :as yaml]
            [clojure.walk :refer [keywordize-keys]]))

(defn load-config [path]
  (keywordize-keys (yaml/from-file path)))

(def config
  (load-config "swagger.yml"))

(defn construct-base-url
  "Extract path to API from config file."
  [config]
  (when-not (nil? (:host config))
    (str (first (:schemes config))
         "://"
         (:host config)
         (:basePath config))))

(defn prepare-query [config]
  (let [entry (first (:paths config))
        base (construct-base-url config)
        route (str (first entry))
        uri (str base (subs route 1 (count route)))
        definitions (second entry)]
    [uri definitions]))
(prepare-query config)

;; (base y)
;; (second (first (:paths config)))
