(ns swagger-autotest.core
  (:require [clj-http.client :as client]
            [swagger-autotest.parse :as parse])
  (:gen-class))

(def config
  (load-config "swagger.yml"))

(defn prepare-query [config]
  (let [entry (first (:paths config))
        base (parse/construct-base-url config)
        route (str (first entry))
        uri (str base (subs route 1 (count route)))
        definitions (second entry)]
    [uri definitions]))
(prepare-query config)



(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
