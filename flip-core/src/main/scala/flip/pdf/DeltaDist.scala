package flip.pdf

import flip.measure.Measure
import flip.rand._
import flip.range._

/**
  * Dirac Delta Function.
  */
case class DeltaDist[A](measure: Measure[A], pole: A, rng: IRng = IRng(0)) extends NumericDist[A]

trait DeltaDistOps extends NumericDistOps[DeltaDist] {

  def pdf[A](dist: DeltaDist[A], a: A): Option[Double] = {
    val pole = dist.measure.to(dist.pole)

    if(a != pole) Some(0) else Some(Double.PositiveInfinity)
  }

  def cdf[A](dist: DeltaDist[A], a: A): Double = {
    val p = dist.measure.to(a)
    val pole = dist.measure.to(dist.pole)

    if(p >= pole) 1 else 0
  }

  def icdf[A](dist: DeltaDist[A], p: Double): A = dist.pole

}

object DeltaDist extends DeltaDistOps {

  def modifyRng[A](dist: DeltaDist[A], f: IRng => IRng): DeltaDist[A] = DeltaDist(dist.measure, dist.pole, f(dist.rng))

}