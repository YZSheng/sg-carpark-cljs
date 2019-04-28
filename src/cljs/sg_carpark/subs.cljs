(ns sg-carpark.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::name
 (fn [db]
   (:name db)))

(re-frame/reg-sub
  ::carpark-data
  (fn [db]
    (:carpark-data db)))

(re-frame/reg-sub
  ::error
  (fn [db]
    (:error db)))