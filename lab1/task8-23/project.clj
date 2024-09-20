(defproject my-app "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.3"]]
  :plugins [[lein-cljfmt "0.6.8"]
            [com.github.clj-kondo/lein-clj-kondo "0.2.5"]]
  :aliases {"lint" ["clj-kondo" "--lint" "src" "test"]
            "format" ["cljfmt" "fix"]})
