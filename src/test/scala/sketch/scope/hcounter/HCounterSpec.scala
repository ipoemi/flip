package sketch.scope.hcounter

import org.scalacheck.{Arbitrary, Gen}
import org.specs2.mutable._
import org.specs2.ScalaCheck
import sketch.scope.counter.CounterGen

/**
  * Licensed by Probe Technology, Inc.
  */
class HCounterSpec extends Specification with ScalaCheck {

  "HCounter" should {

    "ops" in {

      "update" in {
        implicit val hcounterGen = HCounterGen.hcounterA

        prop { (hcounter: HCounter) =>
          todo
        }.setArbitrary(hcounterGen)
      }

      "get" in {
        implicit val hcounterGen = HCounterGen.hcounterA

        prop { (hcounter: HCounter) =>
          todo
        }.setArbitrary(hcounterGen)
      }

    }

  }

}

object HCounterGen {

  def hcounterGen: Gen[HCounter] = for {
    cdimSize <- CounterGen.sizeGen
  } yield HCounter.empty(cdimSize)

  def hcounterA: Arbitrary[HCounter] = Arbitrary(hcounterGen)

}