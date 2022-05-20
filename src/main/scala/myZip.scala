object myZip {
  def myzip(s1: Seq[Any], s2: Seq[Any]): Seq[Any] = {
    if (s1.length == s2.length) s1.zip(s2).flatMap(_.productIterator)
    else if (s1.isEmpty) s2
    else if (s2.isEmpty) s1
    else if (s1.isEmpty & s2.isEmpty) List.empty
    else {
      val longer = if (s1.length > s2.length) s1 else s2
      val shorter = if (s1.length > s2.length) s2 else s1
      val equal = longer.dropRight(longer.length - shorter.length)
      val remainder = longer.takeRight(longer.length - shorter.length)
      if (s1 == longer) equal.zip(shorter).flatMap(_.productIterator) ++ remainder
      else shorter.zip(equal).flatMap(_.productIterator) ++ remainder
    }
  }
}
