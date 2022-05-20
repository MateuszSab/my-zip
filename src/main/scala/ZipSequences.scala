object ZipSequences {

  def zipper(s1: Seq[Any], s2: Seq[Any]): Seq[Any] = {

    if (s1.isEmpty && s2.isEmpty) {
      Seq()
    }

    if (s1.length > s2.length) {
      val droppedElements = s1.dropRight(s1.length - s2.length)
      droppedElements.zip(s2).flatMap(_.productIterator) ++ s1.takeRight(s1.length - s2.length)
    }
    else if (s2.length > s1.length) {
      val droppedElements = s2.dropRight(s2.length - s1.length)
      s1.zip(droppedElements).flatMap(_.productIterator) ++ s2.takeRight(s2.length - s1.length)
    }
    else s1.zip(s2).flatMap(_.productIterator)
  }

}
