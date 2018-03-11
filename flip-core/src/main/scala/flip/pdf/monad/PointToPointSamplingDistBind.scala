package flip.pdf.monad

import flip.conf.{SamplingDistConf, SmoothDistConf}
import flip.measure.Measure
import flip.pdf.arithmetic.Sum
import flip.pdf.{DeltaDist, Dist, SamplingDist, UniformDist}

object PointToPointSamplingDistBind extends SamplingDistBind[SamplingDist, Dist, SamplingDist, SamplingDistConf] {

  def bind[A, B](dist: SamplingDist[A],
                 f: A => Dist[B],
                 measureB: Measure[B],
                 conf: SamplingDistConf): SamplingDist[B] = ???

}
