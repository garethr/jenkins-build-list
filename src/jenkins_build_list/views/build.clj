(ns jenkins-build-list.views.build
  (:require [jenkins-build-list.views.common :as common])
  (:require [clj-http.client :as client])
  (:require [clojure.java.io])
  (:import java.util.Date)
  (:use [noir.core]
        [cheshire.core]
        [hiccup.core :only [html]]))

(def properties-file "jenkins.properties")

(def search-url
  (let [props (common/load-props properties-file)]
    (str (:jenkins props) "/api/json?depth=1")))

(def auth-details
  (let [props (common/load-props properties-file)]
    [(:username props) (:password props)]))

(defpartial parameter [{:keys [name value]}]
    [:span {:class (str (clojure.string/lower-case name) " " value)} value])

(defpartial build [{:keys [timestamp actions]}]
    (let [params (:parameters (first actions))]
      (let [pretty (java.text.SimpleDateFormat. "kk:mm, EEEE, dd MMM")]
        [:li
          [:div (map parameter params)]
          [:h2 (.format pretty (new Date timestamp))]])))

(defpage "/" []
    (let [api-response (client/get (str search-url) {:basic-auth auth-details})]
      (let [json-response (decode(:body api-response) true)]
        (common/layout
          [:h1 "Jenkins Builds"]
          [:ol
            (map build (:builds json-response))]))))
