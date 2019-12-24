(ns rename.core
  (:require
    [clojure.data.csv :as csv]
    [clojure.java.io :as io]))

(def raw-data
  (with-open [reader (io/reader "data.csv")]
    (doall (csv/read-csv reader))))

(def transform
  (for [[a b] (rest raw-data)]
    [(second (re-find #"\"([^\"]+)" a)) b]))

(defn replace-all [f]
  (spit f
        (reduce
          (fn [s [s1 s2]]
            (.replace s s1 s2))
          (slurp f)
          transform)))

(def to-replace
  (concat
    (filter #(.endsWith (.getName %) ".scala") (file-seq (io/file "../src")))
    ["../README.md" "../../DadBasic.wiki/DadBasic.md"]))

(dorun
  (map replace-all to-replace))
