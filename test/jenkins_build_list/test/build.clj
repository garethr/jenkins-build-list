(ns jenkins-build-list.test.build
  (:use [noir.core]
        [noir.util.test]
        [clojure.test]
        [jenkins-build-list.views.build]))

(deftest url-contains-depth
  (is (= ((clojure.string/split search-url #"\?") 1) "depth=1")))

(deftest test-auth-details-provided
  (is (= 2 (count auth-details))))

(deftest request-builds
  (-> (send-request "/")
      (has-content-type "text/html; charset=utf-8")
      (has-status 200)))
