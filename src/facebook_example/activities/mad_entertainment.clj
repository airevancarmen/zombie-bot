(ns facebook-example.activities.mad-entertainment
  (:gen-class)
  (:require [clojure.string :as s]
            [environ.core :refer [env]]))

(def activities (vector "one e"
                      "two e"
                      "three e"
                      "four e"
                      "five e"))

(defn randomActivity [] (rand-nth activities))
