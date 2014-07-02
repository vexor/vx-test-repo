package main

import (
  "github.com/streadway/amqp"
  "github.com/stretchr/testify/assert"
  "testing"
)

func TestMain (t *testing.T) {
  var c = amqp.Config{}
  assert.NotNil(t, c)
  assert.Equal(t, 1, 1)
}
