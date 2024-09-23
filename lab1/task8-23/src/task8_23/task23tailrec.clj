(ns task8-23.task23tailrec
  (:gen-class))

(defn sum-divisors-helper [n i sum]
  (if (> i (quot n 2))
    sum
    (recur n (inc i) (if (zero? (mod n i)) (+ sum i) sum))))

(defn sum-divisors [n]
  (sum-divisors-helper n 1 0))

(defn abundant-tail-rec? [n]
  (> (sum-divisors n) n))

(defn find-abundant-numbers-tail-rec [limit i abundants]
  (if (> i limit)
    abundants
    (recur limit (inc i) (if (abundant-tail-rec? i) (conj abundants i) abundants))))

(defn can-be-sum-of-two-abundant-tail-rec? [n abundant-set abundant-nums]
  (if (empty? abundant-nums)
    false
    (let [abundant-num (first abundant-nums)]
      (if (contains? abundant-set (- n abundant-num))
        true
        (recur n abundant-set (rest abundant-nums))))))

(defn sum-of-non-abundant-sums-tail-rec []
  (let [limit 28123
        abundant-numbers (find-abundant-numbers-tail-rec limit 1 [])
        abundant-set (set abundant-numbers)]
    (loop [i 1 total-sum 0]
      (if (> i limit)
        total-sum
        (recur (inc i) (if (can-be-sum-of-two-abundant-tail-rec? i abundant-set (seq abundant-set))
                         total-sum
                         (+ total-sum i)))))))