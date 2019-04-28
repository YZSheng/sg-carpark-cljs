(ns sg-carpark.core
  (:require
   [reagent.core :as reagent]
   [re-frame.core :as re-frame]
   [sg-carpark.events :as events]
   [sg-carpark.views :as views]
   [sg-carpark.config :as config]
   [day8.re-frame.http-fx]))



(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))
