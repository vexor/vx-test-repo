(ns clj-demo.logger
  (require [clojure.string :as s :only [upper-case join]]))


(def writer (atom nil))
(def default-level (atom 0))
(def levels [:debug :info :warn])

(def ^:dynamic *tags* [])


(defn open-stdout []
  (swap! writer
         (fn [_]
           (fn [c]
             (println c)
             c))))


(defn write [line]
  (when line
    (let [f @writer]
      (f line))))


(defn level! [new-level]
  (swap! default-level (fn [_] new-level)))


(defn level [rec]
  (let [lv  (nth rec 0)
        idx (.indexOf levels lv)]
    (when (>= idx @default-level)
      rec)))


(defn formatter [rec]
  (when rec
    (let [level (nth rec 0)
          line  (nth rec 1)
          tm    (java.util.Date.)
          i     (s/upper-case (subs (str level) 1 2))]
      (format "%s %s: %s" tm i line))))


(defmacro tagged [tag & body]
  `(let [new-tag# (into [] (concat *tags* ~tag))]
     (binding [*tags* new-tag#]
       ~@body)))


(defn tformatter [rec]
  (when rec
    (let [level (nth rec 0)
          line  (nth rec 1)
          line  (format "%s %s"
                        (s/join " " (map #(format "[%s]" %) *tags*))
                        line)]
      (formatter [level line]))))


(defn pack [level line]
  [level line])


(def log (comp write tformatter level pack))

(def info  (partial log :info))
(def warn  (partial log :warn))
(def debug (partial log :debug))


