(ns facebook-example.activities.mild-quotes
  (:gen-class)
  (:require [clojure.string :as s]
            [environ.core :refer [env]]))

(def activities (vector
                  (format "Your flat ain´t be too small. What about running a marathon in here %c" (int 128095))
                  (format "Let´s get high and climb the rooftop of your house %c" (int 127968))
                  (format "Play chess with yourself %c or your cat %c" (int 9812) (int 128008))))

(def urls (vector
           "https://raw.githubusercontent.com/botic/zombie-bot/master/resources/quotes/quote1.jpg"
           "https://raw.githubusercontent.com/botic/zombie-bot/master/resources/quotes/quote2.jpg"
           "https://raw.githubusercontent.com/botic/zombie-bot/master/resources/quotes/quote3.jpg"
           "https://raw.githubusercontent.com/botic/zombie-bot/master/resources/quotes/quote4.jpg"))

(defn randomActivity [] (rand-nth activities))

(defn randomImage [] (rand-nth urls))
