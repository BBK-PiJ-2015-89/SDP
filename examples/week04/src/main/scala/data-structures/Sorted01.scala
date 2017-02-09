object Sorted {

  def isSorted[A](as: Array[A], ord: (A,A) => Boolean): Boolean = {
    def loop(a: Array[A], res: Boolean): Boolean =
      if (a.isEmpty) res && true
      else if (a.length == 1) res && true
      else loop(a.tail, ord(a(0), a(1)))

    loop(as, true)
  }

}