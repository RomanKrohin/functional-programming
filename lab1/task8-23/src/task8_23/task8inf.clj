(ns task8-23.task8inf
  (:gen-class))

(defn digits-sequence [num-string]
  (map #(Character/digit % 10) (remove #(= % \space) num-string)))

(defn product [coll]
  (reduce * coll))

(defn max-product-inf [n]
  (let [digits (digits-sequence n)]
    (->> (partition 4 1 digits)
         (map product)
         (reduce max))))
