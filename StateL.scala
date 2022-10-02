package store.model.items

abstract class StateL(ex:Modifier) {

  def updatePrice(originalPrice:Double): Double

  def computeTax(currentPrice:Double): Double

}
