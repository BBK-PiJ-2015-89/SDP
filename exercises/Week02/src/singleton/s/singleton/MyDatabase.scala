package s.singleton

object MyDatabase extends Database {
  private var db = Map[String, String]()

  override def get(key: String): String = db(key)

  override def set(key: String, value: String): String = {
    db = db + (key -> value)
    value
  }
}
