// The first trait starts with extends and then with for each other
class Superhero(val name: String) extends Flyable with Bulletproof {
  override def fly = "%s flys through the air".format(this.name)

  override def hitByBullet = "The bullet bounces off of %s".format(this.name)
}
