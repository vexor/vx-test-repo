(ns  clj-demo.logger-spec
  (:require [speclj.core :refer :all]
            [clj-demo.logger :refer :all]))

(describe "logger"

  (it "should open stdout"
    (open-stdout)
    (should-not (nil? @writer)))

  (it "should write"
    (open-stdout)
    (should= "Hello" (write "Hello")))

  (it "should format string"
    (should-contain #"I: Hello" (formatter [:info "Hello"])))

  (it "should format tagged string"
    (should-contain #"I: \[foo\] \[bar\] \[baz\] Hello"
      (tagged ["foo" "bar"]
        (tagged ["baz"]
          (tformatter [:info "Hello"]))))))

(run-specs)
