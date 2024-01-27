(ns music-rec.core
  (:require 
    [clojure.data.csv :as csv]
    [clojure.java.io :as io]))

(def tracks-csv "fma_metadata/tracks.csv")
(def echonest-csv "fma_metadata/echonest.csv")


(defn parse-file [file-path]
  (let [rows (with-open [ reader (io/reader file-path)]
      (doall
        (csv/read-csv reader)))]
    (map #(zipmap
            (:headers (first rows))
            %)
         (rest rows))))

(defn load-csv [file-path]
    (parse-file file-path))
