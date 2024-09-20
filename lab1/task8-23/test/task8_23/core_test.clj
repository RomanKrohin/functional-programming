(ns task8-23.core-test
  (:require [clojure.test :refer [deftest is run-tests]]
            [task8-23.core :refer [max-product product]]))

(deftest test-max-product
  (is (= (max-product "123456789") 15120)))

(deftest test-product
  (is (= (product [1 2 3 4 5]) 120)))

(run-tests)
