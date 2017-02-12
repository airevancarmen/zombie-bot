(ns facebook-example.activities.mad-sports
  (:gen-class)
  (:require [clojure.string :as s]
            [environ.core :refer [env]]))

(def activities (vector "one"
                      "two"
                      "three"
                      "four"
                      "five"))

(defn randomActivity [] (rand-nth activities))
