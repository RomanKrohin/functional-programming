(ns task8-23.task23inf
  (:gen-class))

(defn natural-numbers []
  (iterate inc 1))

(defn abundant? [n]
  (> (reduce + (filter #(zero? (mod n %)) (range 1 (inc (quot n 2))))) n))

(defn find-abundant-numbers [n]
  (take n (filter abundant? (natural-numbers))))

(defn can-be-sum-of-two-abundant? [n abundant-set]
  (some #(contains? abundant-set (- n %)) abundant-set))

(defn sum-of-non-abundant-sums-inf []
  (let [limit 28123
        abundant-numbers (find-abundant-numbers limit)
        abundant-set (set abundant-numbers)]
    (reduce + (filter #(not (can-be-sum-of-two-abundant? % abundant-set))
                      (range 1 (inc limit))))))
