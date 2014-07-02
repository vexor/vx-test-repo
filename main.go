package main

import (
  "log"
  "github.com/streadway/amqp"
)

func main () {
  var c = amqp.Config{}
  log.Printf("%v", c)
  log.Printf("done")
}
