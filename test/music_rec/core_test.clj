(ns music-rec.core-test
  (:require [clojure.test :refer :all]
            [music-rec.core :refer :all]))

(deftest test-load-data 
    (is (= {:artists ["Artist 1"]} (load-data "test/resources/sample.csv"))))
