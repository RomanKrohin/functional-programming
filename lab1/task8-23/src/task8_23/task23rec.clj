(ns task8-23.task23rec
  (:gen-class))

(defn sum-divisors-helper [n i sum]
  (if (> i (quot n 2))
    sum
    (recur n (inc i) (if (zero? (mod n i)) (+ sum i) sum))))

(defn sum-divisors [n]
  (sum-divisors-helper n 1 0))

(defn abundant-rec? [n]
  (> (sum-divisors n) n))

(defn find-abundant-numbers-rec [limit i abundants]
  (if (> i limit)
    abundants
    (recur limit (inc i) (if (abundant-rec? i) (conj abundants i) abundants))))

(defn can-be-sum-of-two-abundant-rec? [n abundant-set]
  (some #(contains? abundant-set (- n %)) abundant-set))

(defn sum-of-non-abundant-sums-rec []
  (let [limit 28123
        abundant-numbers (find-abundant-numbers-rec limit 1 [])
        abundant-set (set abundant-numbers)]
    (loop [i 1 total-sum 0]
      (if (> i limit)
        total-sum
        (recur (inc i) (if (can-be-sum-of-two-abundant-rec? i abundant-set)
                         total-sum
                         (+ total-sum i)))))))