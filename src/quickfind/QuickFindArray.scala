package quickfind

import scala.language.postfixOps

class QuickFindArray(private val dim: Int) extends QuickFindBase[Int] {
  val associations: Array[Int] = (0 to dim) toArray

  override def groups = reverse(associations.zipWithIndex map (_.swap) toMap)

  override protected def get(value: Int) = (associations lift value) getOrElse value
  override protected def put(value: Int, parent: Int) = {
    associations(value) = parent
    parent
  }
}