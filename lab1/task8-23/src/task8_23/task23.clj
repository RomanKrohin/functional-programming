(ns task8-23.task23
  (:gen-class))

(defn divisors [n]
  (filter #(zero? (mod n %)) (range 1 (inc (quot n 2)))))

(defn abundant? [n]
  (> (reduce + (divisors n)) n))

(defn find-abundant-numbers [limit]
  (filter abundant? (range 1 limit)))

(defn can-be-sum-of-two-abundant? [n abundant-set]
  (some #(contains? abundant-set (- n %)) abundant-set))

(defn sum-of-non-abundant-sums []
  (let [limit 28123
        abundant-numbers (find-abundant-numbers limit)
        abundant-set (set abundant-numbers)]
    (reduce + (filter #(not (can-be-sum-of-two-abundant? % abundant-set))
                      (range 1 (inc limit))))))