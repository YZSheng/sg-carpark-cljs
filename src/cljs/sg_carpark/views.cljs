(ns sg-carpark.views
  (:require
    [re-frame.core :as re-frame]
    [sg-carpark.subs :as subs]))

(defn result-table [{[{extracted-data :carpark_data}] :items} error]
    [:div
     [:table
      [:thead
       [:tr
        [:td "Carpark Number"]
        [:td "Update Datetime"]]]
      [:tbody (for [data (take 10 extracted-data)]
                [:tr {:key (str data)}
                 [:td (:carpark_number data)]
                 [:td (:update_datetime data)]])]]
     (if (some? error)
       [:div (:debug-message error)])])

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])
        carpark-data (re-frame/subscribe [::subs/carpark-data])
        error (re-frame/subscribe [::subs/error])]
    [:div
     [:h1 "Hello from " @name]
     [:input
      {:type "button"
       :value "Click me!"
       :on-click #(re-frame/dispatch [:load-carpark-data])}]
     [result-table @carpark-data @error]]))
