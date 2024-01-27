(ns music-rec.core-test
  (:require [clojure.test :refer :all]
            [music-rec.core :refer :all]))

(deftest test-load-csv
  ;; Read sample data as map for expectations
  (let [result-tracks (load-csv "fma_metadata/tracks.csv")
        headers (keys (first result-tracks))
        sample (take 3 result-tracks)]

    (is (= headers
           (keys (first sample))))

    (testing "Sample has expected number of rows"
      (is (= 3 (count sample))))

    (testing "Row 1 matches full dataset"
      (is (= (first result-tracks)
             (first sample)))))

  (let [result-echonest (load-csv "fma_metadata/echonest.csv")
        headers (keys (first result-echonest))
        sample (take 3 result-echonest)]

    (is (= headers
           (keys (first sample))))

    (testing "Sample has expected number of rows"
      (is (= 3 (count sample))))

    (testing "Row 1 matches full dataset"
      (is (= (first result-echonest)
             (first sample))))))

