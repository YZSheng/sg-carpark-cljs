(ns sg-carpark.views
  (:require
   [re-frame.core :as re-frame]
   [sg-carpark.subs :as subs]))


(def table-data [{:name "John" :age 32} {:name "Mark" :age 41}])

(defn result-table []
  [:table
   [:thead
    [:tr
     (map (fn [val] [:th val]) (keys (first table-data)))]]
   [:tbody
    (map (fn [row]
           [:tr
            (map (fn [val] [:td val])
                 row)])
         table-data)]])


(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1 "Hello from " @name]
     [result-table]]))
