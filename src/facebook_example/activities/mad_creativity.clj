(ns facebook-example.activities.mad-creativity
  (:gen-class)
  (:require [clojure.string :as s]
            [environ.core :refer [env]]))

(def activities (vector
                  (format "Music is everything. Hold a concert %c for your cats %c"  (int 127928) (int 128008))
                  (format "Create a vision board for your post-apocalyptic future! %c" (int 129412))
                  (format "Become an author and write a book %c" (int 128218))))

(defn randomActivity [] (rand-nth activities))
