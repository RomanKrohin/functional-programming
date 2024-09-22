(ns task8-23.task23-test
  (:require [clojure.test :refer [deftest is run-tests]]
            [task8-23.task23 :refer [sum-of-non-abundant-sums]]))

(deftest sum-of-non-abundant-sums-test
  (is (= (sum-of-non-abundant-sums 28124) 4179871)))
