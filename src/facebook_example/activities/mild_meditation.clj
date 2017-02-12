(ns facebook-example.activities.mild-meditation
  (:gen-class)
  (:require [clojure.string :as s]
            [environ.core :refer [env]]))

(def activities (vector
                 (format "A short visualization is an easy way to get back to center. Simply make yourself comfortable and then try to picture a peaceful scene: a future vacation, your favorite beach. %c %c" (int 127774) (int 127958))
                 (format "Tune In to Your Body %c Mentally scan your body to get a sense of how stress affects it each day. Lie on your back, or sit with your feet on the floor. Start at your toes and work your way up to your scalp, noticing how your body feels." (int 128581))
                 (format "%c 1.Find a comfortable posture. Notice directly the sensation of your body in contact with the chair or ground.\n%c 2.Allow whatever arises in your mind to come and go, to move freely.\n%c 3. Keep breathing in your natural rhythm." (int 9995) (int 128075) (int 128067))))

(defn randomActivity [] (rand-nth activities))
