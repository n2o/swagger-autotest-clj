(ns swagger-autotest.core
  (:require [clj-http.client :as client])
  (:gen-class))

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
