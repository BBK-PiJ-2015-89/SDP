package first

object StringUtils {
    implicit class StringImprovements(val s: String) {
        def increment: String = s.map(c => (c + 1).toChar)
        def hideAll: String = s.replaceAll(".", "*")
    }
}
