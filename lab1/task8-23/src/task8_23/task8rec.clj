(ns task8-23.task8rec
  (:gen-class))

(defn product-rec [digits]
  (if (empty? digits)
    1
    (* (first digits) (product-rec (rest digits)))))

(defn max-product-rec [n]
  (let [digits (map #(Character/digit % 10) n)]
    (loop [parts (partition 4 1 digits)
           max-prod 0]
      (if (empty? parts)
        max-prod
        (let [prod (product-rec (first parts))]
          (recur (rest parts) (max prod max-prod)))))))
