(ns task8-23.task8module
  (:gen-class))

(defn product [digits]
  (reduce * digits))

(defn generate-sequences [n]
  (partition 4 1 (map #(Character/digit % 10) n)))

(defn filter-sequences [sequences]
  (filter #(not-any? zero? %) sequences))

(defn max-product-modular [n]
  (->> n
       generate-sequences
       filter-sequences
       (map product)
       (apply max)))
