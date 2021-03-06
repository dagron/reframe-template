(ns ui.user.core
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [reagent.core :as reagent]
            [re-frame.core :as rf]
            [ui.routes :refer [href]]
            [ui.pages :as pages]
            [clojure.string :as str]))

(rf/reg-event-fx
 :signout
 (fn [coef _]
   {:frames.cookeis/remove {:key :auth :value false}
    :db (dissoc (:db coef) :auth)
    :dispatch [:ui.core/initialize]}))

(defn profile [params]
  [:div.index.container
   [:h3 "User Profile"]
   [:button.btn.btn-danger {:on-click #(rf/dispatch [:signout])} "Sign Out"]])


(pages/reg-page :user/profile profile)
