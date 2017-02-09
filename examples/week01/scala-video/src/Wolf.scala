class Wolf(name: String) extends Mammal(name) {
  // You don't use override when defining abstract fields
  var moveSpeed = 35.0;

  override def move = "The wolf %s runs %.2f mph".format(this.name, this.moveSpeed)

}
