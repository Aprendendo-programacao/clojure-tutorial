(ns clojure-tutorial.function)
(require '[clojure.repl :refer [source]])

; Exercises from https://clojure.org/guides/learn/functions#_closures

(defn greet []
  (println "Hello"))

(greet)

(defn greeting
  ([] "Hello, World!")
  ([x] (str "Hello, " x "!"))
  ([x y] (str x ", " y "!")))

(assert (= "Hello, World!" (greeting)))
(assert (= "Hello, Clojure!" (greeting "Clojure")))
(assert (= "Good morning, Clojure!" (greeting "Good morning" "Clojure")))

(defn do-nothing [x] x)

(do-nothing 10)

(source identity)
(identity 10)

(defn always-thing [& _] 100)
(always-thing 1 2 3 4 5)

(defn make-thingy [x]
  (fn [& _] x))

(let [n (rand-int Integer/MAX_VALUE)
      f (make-thingy n)]
  (assert (= n (f)))
  (assert (= n (f 123)))
  (assert (= n (apply f 123 (range)))))

(defn triplicate [f]
  (f) (f) (f))

(triplicate always-thing)

(defn opposite [f]
  (fn [& args] (not (apply f args))))

((opposite (fn [] true)))
((opposite (fn [& _] false)) 1 2 3 4 5)

(Math/cos Math/PI)

(defn teorema-fundamental-da-trigonometria [x]
  (+
   (Math/pow (Math/sin x) 2)
   (Math/pow (Math/cos x) 2)
   ))

(teorema-fundamental-da-trigonometria 30)
(teorema-fundamental-da-trigonometria 45)
(teorema-fundamental-da-trigonometria 60)

(defn http-get [url]
  (slurp url))

(assert (.contains (http-get "https://www.w3.org") "html"))

(http-get "https://www.w3.org")