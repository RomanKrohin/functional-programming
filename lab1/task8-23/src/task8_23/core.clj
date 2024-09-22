(ns task8-23.core
  (:gen-class))

(defn product [digits]
  (reduce * digits))

(defn max-product [n]
  (apply max (map product (partition 4 1 (map #(Character/digit % 10) n)))))

(defn -main
  "Основная функция программы, которая запрашивает у пользователя строку чисел и выводит максимальное произведение пяти последовательных цифр."
  []
  (println "Введите строку:")
  (let [number (read-line)]
    (println "Максимальное произведение пяти последовательных цифр:" (max-product number))))
