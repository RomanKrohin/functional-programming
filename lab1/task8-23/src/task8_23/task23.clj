(ns task8-23.task23
  (:gen-class))

(defn proper-divisors [n]
  (filter #(zero? (rem n %)) (range 1 (quot n 2))))

(defn abundant? [n]
  (> (reduce + (proper-divisors n)) n))

(defn find-abundant-numbers [limit]
  (filter abundant? (range 12 limit)))

(defn can-be-written-as-sum-of-two-abundant-numbers? [n abundant-numbers]
  (some (fn [a]
          (some #(= n (+ a %)) abundant-numbers))
        abundant-numbers))

(defn sum-of-non-abundant-sums [limit]
  (let [abundant-numbers (find-abundant-numbers limit)]
    (reduce + (filter #(not (can-be-written-as-sum-of-two-abundant-numbers? % abundant-numbers)) (range 1 limit)))))