trait Bulletproof {
  def hitByBullet: String

  // You can define concrete methods in traits
  def ricochet(startSpeed: Double): String = {
    "The bullet ricochets at a speed of %.1f ft/sec".format(startSpeed * .75)
  }
}
