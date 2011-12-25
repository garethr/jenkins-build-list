(ns jenkins-build-list.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page-helpers :only [include-css html5]]))

(defn load-props [file-name]
  (with-open [^java.io.Reader reader (clojure.java.io/reader file-name)]
    (let [props (java.util.Properties.)]
      (.load props reader)
        (into {} (for [[k v] props] [(keyword k) (read-string v)])))))

(defpartial layout [& content]
  (html5
    [:head
      [:title "Jenkins Builds"]
        (include-css "/css/reset.css")
        (include-css "/css/core.css")]
    [:body
      [:div#wrapper
        content]]))
