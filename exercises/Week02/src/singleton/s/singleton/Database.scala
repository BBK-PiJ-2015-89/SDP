package s.singleton

trait Database {
  def get(key: String): String
  def set(key: String, value: String): String
}
