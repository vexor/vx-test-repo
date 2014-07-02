(ns clj-demo.core
  (:use [clj-demo.logger :as log])
  (:gen-class))

(defn -main []
  (log/open-stdout)
  (log/warn "Hello!")

  (log/level! 1)

  (log/tagged ["foo" "bar"]

    (log/info "Hello")

    (log/tagged ["baz"]

      (log/debug "Debug")

      (log/warn "World")))
  nil)
