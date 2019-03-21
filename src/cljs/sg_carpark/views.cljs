(ns sg-carpark.views
  (:require
   [re-frame.core :as re-frame]
   [sg-carpark.subs :as subs]))


(def table-data [{:name "John" :age 32} {:name "Mark" :age 41} {:name "Julie" :age 20}])

(defn result-table []
  [:table
   [:thead
    [:tr
     [:td "Name"]
     [:td "Age"]]]
   [:tbody (for [data table-data]
             [:tr
              [:td (:name data)]
              [:td (:age data)]])]])

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1 "Hello from " @name]
     [result-table]]))
