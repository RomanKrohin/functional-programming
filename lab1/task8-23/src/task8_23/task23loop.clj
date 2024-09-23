(ns task8-23.task23loop
  (:gen-class))

(defn divisors [n]
  (loop [i 1
         divisors []]
    (if (> i (quot n 2))
      divisors
      (if (zero? (mod n i))
        (recur (inc i) (conj divisors i))
        (recur (inc i) divisors)))))

(defn abundant? [n]
  (> (reduce + (divisors n)) n))

(defn find-abundant-numbers [limit]
  (loop [n 1
         abundant-numbers []]
    (if (>= n limit)
      abundant-numbers
      (if (abundant? n)
        (recur (inc n) (conj abundant-numbers n))
        (recur (inc n) abundant-numbers)))))

(defn can-be-sum-of-two-abundant? [n abundant-set]
  (some #(contains? abundant-set (- n %)) abundant-set))

(defn sum-of-non-abundant-sums-loop []
  (let [limit 28123
        abundant-numbers (find-abundant-numbers limit)
        abundant-set (set abundant-numbers)]
    (reduce + (filter #(not (can-be-sum-of-two-abundant? % abundant-set))
                      (range 1 (inc limit))))))