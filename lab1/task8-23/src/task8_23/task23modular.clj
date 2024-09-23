(ns task8-23.task23modular
  (:gen-class))

(defn divisors [n]
  (filter #(zero? (mod n %)) (range 1 (inc (quot n 2)))))

(defn abundant? [n]
  (> (reduce + (divisors n)) n))

(defn can-be-sum-of-two-abundant? [n abundant-set]
  (some #(contains? abundant-set (- n %)) abundant-set))

(defn generate-sequence [limit]
  (range 1 limit))

(defn filter-abundant [sequence]
  (filter abundant? sequence))

(defn sum-sequence [sequence]
  (reduce + sequence))

(defn sum-of-non-abundant-sums-modular []
  (let [limit 28123
        abundant-numbers (filter-abundant (generate-sequence limit))
        abundant-set (set abundant-numbers)]
    (sum-sequence (filter #(not (can-be-sum-of-two-abundant? % abundant-set)) (generate-sequence (inc limit))))))
