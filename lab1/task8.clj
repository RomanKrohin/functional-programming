(defn product [digits]
  (reduce * digits))

(defn max-product [n]
  (apply max (map product (partition 5 1 (map #(Character/digit % 10) n)))))

(defn -main []
  (println "Введите строку:")
  (let [number (read-line)]
    (println "Максимальное произведение пяти последовательных цифр:" (max-product number))))

(-main)
