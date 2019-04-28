(ns sg-carpark.events
  (:require
   [re-frame.core :as re-frame]
   [ajax.core :as ajax]
   [sg-carpark.db :as db]))

(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(re-frame/reg-event-fx
  :load-carpark-data
  (fn [_ _]
    {:http-xhrio {:method :get
                  :uri "https://api.data.gov.sg/v1/transport/carpark-availability"
                  :response-format (ajax/json-response-format {:keywords? true})
                  :on-success      [:carpark-data-loading-succeeded]
                  :on-failure      [:carpark-data-loading-failed]}}))

(re-frame/reg-event-db
  :carpark-data-loading-succeeded
  (fn [db [_ result]]
    (assoc db :carpark-data result :error nil)))

(re-frame/reg-event-db
  :carpark-data-loading-failed
  (fn [db [_ error]]
    (assoc db :error error :carpark-data nil)))