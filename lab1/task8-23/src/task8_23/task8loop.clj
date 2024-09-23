(ns task8-23.task8loop
  (:gen-class))

(defn max-product-loop [n]
  (let [digits (map #(Character/digit % 10) n)]
    (loop [parts (partition 4 1 digits)
           max-prod 0]
      (if (empty? parts)
        max-prod
        (recur (rest parts) (max (apply * (first parts)) max-prod))))))
