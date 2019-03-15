(ns sg-carpark.events
  (:require
   [re-frame.core :as re-frame]
   [sg-carpark.db :as db]
   ))

(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))
