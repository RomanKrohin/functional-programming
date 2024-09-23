(ns task8-23.task8tailrec
  (:gen-class))

(defn product-tail [digits acc]
  (if (empty? digits)
    acc
    (recur (rest digits) (* acc (first digits)))))

(defn max-product-tail [n]
  (let [digits (map #(Character/digit % 10) n)]
    (loop [parts (partition 4 1 digits)
           max-prod 0]
      (if (empty? parts)
        max-prod
        (let [prod (product-tail (first parts) 1)]
          (recur (rest parts) (max prod max-prod)))))))
