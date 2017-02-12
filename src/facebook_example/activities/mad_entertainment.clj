(ns facebook-example.activities.mad-entertainment
  (:gen-class)
  (:require [clojure.string :as s]
            [environ.core :refer [env]]))

(def activities (vector
                 (format "You need a HUGE wall - build a pillow fort %c" (int 128719))
                 (format "It´s getting hot in here! Play \"the floor is lava\" %c" (int 127755))
                 (format "Become the next Beyoncé and learn the \"single ladies\" choreo %c" (int 128141))))

(defn randomActivity [] (rand-nth activities))
