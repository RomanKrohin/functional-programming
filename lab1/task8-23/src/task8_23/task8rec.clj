(ns task8-23.task8rec
  (:gen-class))

(defn product-rec [digits]
  (if (empty? digits)
    1
    (* (first digits) (product-rec (rest digits)))))

(defn max-product-rec [n]
  (apply max (map product-rec (partition 4 1 (map #(Character/digit % 10) n)))))
