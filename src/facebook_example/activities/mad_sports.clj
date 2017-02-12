(ns facebook-example.activities.mad-sports
  (:gen-class)
  (:require [clojure.string :as s]
            [environ.core :refer [env]]))

(def activities (vector
                  (format "Your flat ain´t be too small. What about running a marathon in here %c" (int 128095))
                  (format "Let´s get high and climb the rooftop of your house %c" (int 127968))
                  (format "Play chess with yourself %c or your cat %c" (int 9812) (int 128008))))

(defn randomActivity [] (rand-nth activities))
