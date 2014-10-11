require 'test_helper'

class DemoTest < ActiveSupport::TestCase
  test "the truth" do
    demo = Demo.create name: "test"
    assert demo.valid?
    assert demo.persisted?
  end
end
