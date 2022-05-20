import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import org.scalatestplus.scalacheck.Checkers

class ZipSequencesSpec extends AnyFlatSpec with should.Matchers with Checkers {

  import ZipSequences._

  "zipper" should "check if lengths of two sequences are equal" in {
    check((a: List[Int], b: List[Int]) => zipper(a, b).size == (a ::: b).size)
  }

  "zipper" should "intertwine two sequences" in {
    val s1 = Seq(1, 2, 3)
    val s2 = Seq('a', 'a', 'a')
    val expected = Seq(1, 'a', 2, 'a', 3, 'a')

    zipper(s1, s2) shouldBe expected
  }

  "zipper" should "intertwine two sequences of different size, first is shorter" in {
    val s1 = Seq(1, 2)
    val s2 = Seq('a', 'a', 'a')
    val expected = Seq(1, 'a', 2, 'a', 'a')

    zipper(s1, s2) shouldBe expected
  }
  "zipper" should "intertwine two sequences of different size" in {
    val s1 = Seq(1, 2, 3)
    val s2 = Seq('a', 'a')
    val expected = Seq(1, 'a', 2, 'a', 3)

    zipper(s1, s2) shouldBe expected
  }

}
