(ns task8-23.task23map
  (:gen-class))

(defn divisors [n]
  (filter #(zero? (mod n %)) (range 1 (inc (quot n 2)))))

(defn abundant? [n]
  (> (reduce + (divisors n)) n))

(defn can-be-sum-of-two-abundant? [n abundant-set]
  (some #(contains? abundant-set (- n %)) abundant-set))

(defn abundant-map? [n]
  (> (reduce + (filter #(zero? (mod n %)) (map identity (range 1 (inc (quot n 2)))))) n))

(defn find-abundant-numbers-map [limit]
  (filter abundant-map? (map identity (range 1 limit))))

(defn sum-of-non-abundant-sums-map []
  (let [limit 28123
        abundant-numbers (find-abundant-numbers-map limit)
        abundant-set (set abundant-numbers)]
    (reduce + (filter #(not (can-be-sum-of-two-abundant? % abundant-set)) (map identity (range 1 (inc limit)))))))
