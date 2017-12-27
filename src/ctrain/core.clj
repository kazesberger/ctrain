(ns ctrain.core
  (:require [clojure.string :as s])
  (:gen-class))

(declare -main)

(def problems
  (read-string (slurp "problems")))

(defn replacer [n]
  (let [ans (read-line)] 
(loop [tests (:tests (problems (- n 1))) replaced []]
  (if (empty? tests)
      replaced
      (recur (rest tests) (conj replaced (s/replace (first tests) "__" ans)))))))

(defn evaluator [answers]
  (loop [totest answers results []]
    (if (empty? totest)
      results
      (recur (rest totest) (conj results (eval (read-string (first totest))))))))

(defn final [results]
  (loop [coll results]
    (if (empty? coll)
      (do
      (spit "prob" (inc (read-string (slurp "prob"))))
      (println "")
      (str "GOOD JOB")
      (-main)))
   (if (= false (first coll))
       (-main))      
(recur (rest coll))))

(defn problem [n]
  (println (str "#" n " " (:title (nth problems (- n 1)))))
  (println "")
   (println (str (:description (nth problems (- n 1)))))
   (println "")
   (run! println (:tests (nth problems (- n 1))))
(replacer n))

(defn -main []
  (println "")
  (final (evaluator (replacer (problem (read-string (slurp "prob")))
  (-main)))))
