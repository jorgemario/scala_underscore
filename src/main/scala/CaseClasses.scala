case class Person2(firstName: String, lastName: String) {
  def name = firstName + " " + lastName
}

case class Cat(name: String, colour: String, food: String)

case class Counter(count: Int = 0) {
  def inc = copy(count = count + 1)
  def dec = copy(count = count - 1)
  //def adjust(adder: Adder): Counter = copy(count = adder(count))
}


