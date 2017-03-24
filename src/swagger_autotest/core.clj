(ns swagger-autotest.core
  (:refer-clojure :exclude [load])
  (:require [clojure.spec :as s]
            [yaml.core :as yaml]
            [clojure.walk :refer [keywordize-keys]]
            [clj-http.client :as client])
  (:gen-class))

(defn load-config [path]
  (keywordize-keys (yaml/from-file path)))

(defn construct-base-url [config]
  (str (first (:schemes config)) "://"
       (:host config)
       (:basePath config)))

(def config
  (load-config "swagger.yml"))

(def base
  (construct-base-url config))
;; (base y)

(second (first (:paths config)))

(s/def ::protocol #{:get :post :put :delete})




(defn prepare-query [entry]
  (let [route (str (first entry))
        uri (str base (subs route 1 (count route)))
        definitions (second entry)]
    [uri definitions]))
(prepare-query (first (:paths config)))





(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
