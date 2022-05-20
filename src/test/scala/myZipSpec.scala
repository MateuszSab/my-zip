import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers._
import org.scalatest.prop.TableDrivenPropertyChecks.whenever
import org.scalatestplus.scalacheck.Checkers
import org.scalatestplus.scalacheck.Checkers._
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks.forAll

class myZipSpec extends AnyFlatSpec with should.Matchers {

  import myZip._

  "myzip" should "create a seq of size equals to sum of two seq" in {
    check((a: List[Int], b: List[String]) => myzip(a, b).size == (a ::: b).size)
  }

  "myzip" should "return empty list if both input lists are empty" in {
    forAll { (a: Seq[Int], b: Seq[String]) =>
      whenever(a.nonEmpty && b.nonEmpty) {
        myzip(a, b).take(2) shouldBe Seq(a.head, b.head)
      }
    }
  }

  "myzip" should "intertwine two sequences" in {
    val s1 = Seq(1, 2, 3)
    val s2 = Seq('a', 'a', 'a')
    val expected = Seq(1, 'a', 2, 'a', 3, 'a')

    myzip(s1, s2) shouldBe expected
  }

  "myzip" should "intertwine two sequences of different size, first is shorter" in {
    val s1 = Seq(1, 2)
    val s2 = Seq("a", "a", "a")
    val expected = Seq(1, "a", 2, "a", "a")

    myzip(s1, s2) shouldBe expected
  }
  "myzip" should "intertwine two sequences of different size" in {
    val s1 = Seq(1, 2, 3)
    val s2 = Seq('a', 'a')
    val expected = Seq(1, 'a', 2, 'a', 3)

    myzip(s1, s2) shouldBe expected
  }

}
