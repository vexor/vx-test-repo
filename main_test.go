package main

import (
  "github.com/streadway/amqp"
  "testing"
  "log"
)

func TestMain (t *testing.T) {
  var c = amqp.Config{}
  log.Printf("%v", c)
}
