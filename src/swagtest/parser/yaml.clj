(ns swagtest.parser.yaml
  (:require [yaml.core :as yaml]
            [clojure.walk :refer [keywordize-keys]]))

(defn load-config [path]
  (keywordize-keys (yaml/from-file path)))

(def config (load-config "swagger.yml"))
(def paths (:paths config))

(defn construct-base-url
  "Extract path to API from config file."
  [config]
  (when-not (nil? (:host config))
    (str (first (:schemes config))
         "://"
         (:host config)
         (:basePath config))))
;; (construct-base-url config)

(def base-url
  (construct-base-url config))

(defn- responses-to-tuple
  "Convert the responses from the swagger definition from a map to a tuple."
  [definitions]
  (let [responses (-> definitions vals first :responses)]
    (vec (for [[k v] responses] [k v]))))

(defn- convert-entry
  "Wraps a path definition from the swagger definition to a more usable data
  structure."
  [entry base-url]
  (let [route (str (first entry))
        uri (str base-url (subs route 1 (count route)))
        responses (responses-to-tuple (second entry))
        method (-> (second entry) keys first)]
    {:uri uri, :method method, :responses responses :entry entry}))
;; (convert-entry (first paths) base-url)

(defn summarize-route
  "Extract all necessary information and return a prepared map."
  [definition]
  )
