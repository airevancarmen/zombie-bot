(ns facebook-example.activities.mild-relaxation
  (:gen-class)
  (:require [clojure.string :as s]
            [environ.core :refer [env]]))

(def activities (vector
                 (format "Count down slowly from %c to %c. With each number, take one complete breath, inhaling and exhaling. If you feel lightheaded, count down more slowly to space your breaths further apart. When you reach zero, you should feel more relaxed. If not, go through the exercise again." (int 9321) (int 9450))
                 (format "Place your hand just beneath your navel so you can feel the gentle rise and fall of your belly as you breathe. %c Breathe in. Pause for a count of three. Breathe out. Pause for a count of three. Continue to breathe deeply for one minute, pausing for a count of three after each inhalation and exhalation." (int 128067))
                 (format "Decompress: Place a warm heat wrap around your neck and shoulders for 10 minutes. %c Close your eyes and relax your face, neck, upper chest, and back muscles. Remove the wrap, and use a tennis ball or foam roller to massage away tension." (int 128134))))

(defn randomActivity [] (rand-nth activities))
