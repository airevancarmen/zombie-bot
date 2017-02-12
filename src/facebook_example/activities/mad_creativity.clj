(ns facebook-example.activities.mad-creativity
  (:gen-class)
  (:require [clojure.string :as s]
            [environ.core :refer [env]]))

(def activities (vector "one c"
                      "two c"
                      "three c"
                      "four c"
                      "five c"))

(defn randomActivity [] (rand-nth activities))
