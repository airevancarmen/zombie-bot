(ns facebook-example.activities.mild-quotes
  (:gen-class)
  (:require [clojure.string :as s]
            [environ.core :refer [env]]))

(def activities (vector
                  (format "Your flat ain´t be too small. What about running a marathon in here %c" (int 128095))
                  (format "Let´s get high and climb the rooftop of your house %c" (int 127968))
                  (format "Play chess with yourself %c or your cat %c" (int 9812) (int 128008))))

(def urls (vector
           "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRiVZKuAqLERdYuvr0_UApu78J4zxglos5yfglkOREbJoH_jKvq"
           "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSRWdfDEDLERkQjW9FUy-gv66MCD6fQxn_m3giSI6rzxNWZJovO"
           "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJEI6MQEIx_kH0uL0yHhWq6HGS_1aahlOZxPFn8D5t1reeb0CF6g "
           "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSnX-Jif_qdc4NQ8Muw99yrhSAP6tJdWTFPaUuttzGZrUVbVc8J"
           "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQf7WBiCeC6-ctxinTDHZGoAnE4toAIpmQCmJB_0bKUwKfFeICK_g"))

(defn randomActivity [] (rand-nth activities))

(defn randomImage [] (rand-nth urls))
