(ns task8-23.task8map
  (:gen-class))

(defn max-product-map [n]
  (apply max (map #(apply * %) (partition 4 1 (map #(Character/digit % 10) n)))))
