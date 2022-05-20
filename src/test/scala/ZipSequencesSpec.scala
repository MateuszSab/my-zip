import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import org.scalatest.prop.TableDrivenPropertyChecks.whenever
import org.scalatestplus.scalacheck.Checkers
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks.forAll

class ZipSequencesSpec extends AnyFlatSpec with should.Matchers with Checkers {

  import ZipSequences._

  it should "check if lengths of two sequences are equal" in {
    check((a: List[Int], b: List[Int]) => zipper(a, b).size == (a ::: b).size)
  }

  it should "return first two elements in list as 1st element of List[a] and first element of List[b]" in {
    forAll { (a: List[Int], b: List[Int]) =>
      whenever(a != List.empty && b != List.empty) {
        zipper(a, b).take(2) shouldBe List(a.head, b.head)
      }
    }
  }
}
