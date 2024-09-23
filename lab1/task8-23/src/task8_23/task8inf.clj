(ns task8-23.task8inf
  (:gen-class))

(defn product [digits]
  (reduce * digits))

(defn infinite-sequence [n]
  (->> n
       (map #(Character/digit % 10))
       cycle))

(defn max-product-inf [n]
  (->> (infinite-sequence n)
       (partition 4 1)
       (map product)
       (take (* (count n) 2))
       (apply max)))    
