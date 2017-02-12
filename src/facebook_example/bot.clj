(ns facebook-example.bot
  (:gen-class)
  (:require [clojure.string :as s]
            [environ.core :refer [env]]
            [facebook-example.facebook :as fb]))

(defn on-message [payload]
  (println "on-message payload:")
  (println payload)
  (let [sender-id (get-in payload [:sender :id])
        recipient-id (get-in payload [:recipient :id])
        time-of-message (get-in payload [:timestamp])
        message-text (get-in payload [:message :text])]

    (cond
      (s/includes? (s/lower-case message-text) "help") (fb/send-message sender-id (fb/text-message "Hi there, happy to help :)"))
      (s/includes? (s/lower-case message-text) "image") (fb/send-message sender-id (fb/image-message "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/M101_hires_STScI-PRC2006-10a.jpg/1280px-M101_hires_STScI-PRC2006-10a.jpg"))
      (s/includes? (s/lower-case message-text) "owl") (fb/send-message sender-id (fb/text-message (format "Welcome to your personal bi%clar advisor, doomed being!" (int 129417))))
      :else (fb/send-message sender-id (fb/text-message message-text)))))

(defn on-postback [payload]
  (println "on-postback payload:")
  (println payload)
  (let [sender-id (get-in payload [:sender :id])
        recipient-id (get-in payload [:recipient :id])
        time-of-message (get-in payload [:timestamp])
        postback (get-in payload [:postback :payload])
        referral (get-in payload [:postback :referral :ref])]

    (cond
      (= postback "GET_STARTED") (fb/send-message sender-id (fb/button-message (format "Welcome to your personal bip%clar advisor, doomed being! You are in an apocalyptic situation %c and want to know how to proceed with life? I provide help with all the lost ones out there." (int 129417) (int 9760))
                                                                               [{:type "postback" :title "Lets save my life" :payload "LETS_SAVE_MY_LIFE"}]))

      (= postback "LETS_SAVE_MY_LIFE") [
                                        (fb/send-message sender-id (fb/text-message "Days like these are spent best with some activities."))
                                        (fb/send-message sender-id (fb/quick-reply-message "How would you like to spend these days?" [{:content_type "text" :title (format "%c Fun Activities" (int 127881)) :payload "TREE_MAD"} {:content_type "text" :title (format "%c Relax Practices" (int 128524)) :payload "TREE_MILD"}]))]

      :else (fb/send-message sender-id (fb/text-message "Sorry, I don't know how to handle that postback")))))

(defn on-quickreply [payload]
  (println "on-quickreply payload:")
  (println payload)
  (let [sender-id (get-in payload [:sender :id])
        recipient-id (get-in payload [:recipient :id])
        time-of-message (get-in payload [:timestamp])
        message (get-in payload [:message])
        quick-reply (get-in payload [:message :quick_reply])
        quick-reply-payload (get-in payload [:message :quick_reply :payload])]

    (cond
      (= quick-reply-payload "TREE_MAD") (fb/send-message sender-id (fb/button-message (format "Super great %c let's guide you through some MAD activities." (int 128165))
                                                                            [{:type "postback" :title (format "%c Sports" (int 127947)) :payload "TREE_MAD_SPORTS"}
                                                                             {:type "postback" :title (format "%c Creativity" (int 127912)) :payload "TREE_MAD_CREATIVITY"}
                                                                             {:type "postback" :title (format "%c Entertainment" (int 127922)) :payload "TREE_MAD_ENTERTAINMENT"}]))

      (= quick-reply-payload "TREE_MILD") (fb/send-message sender-id (fb/button-message (format "Calming down with some MILD practices %c sounds like a great idea." (int 127752))
                                                                           [{:type "postback" :title (format "%c Quote" (int 128173)) :payload "TREE_MILD_QUOTE"}
                                                                            {:type "postback" :title (format "%c Meditation" (int 128591)) :payload "TREE_MILD_MEDITATION"}
                                                                            {:type "postback" :title (format "%c Relaxation" (int 128134)) :payload "TREE_MILD_RELAXATION"}]))

      :else (fb/send-message sender-id (fb/text-message "Sorry, I don't know how to handle that quick reply.")))))


(defn on-attachments [payload]
  (println "on-attachment payload:")
  (println payload)
  (let [sender-id (get-in payload [:sender :id])
        recipient-id (get-in payload [:recipient :id])
        time-of-message (get-in payload [:timestamp])
        attachments (get-in payload [:message :attachments])]
    (fb/send-message sender-id (fb/text-message "Thanks for your attachments :)"))))
