package store.model.items

class LoyaltyDeactivate(ex:Modifier) extends StateL(ex){
  override def updatePrice(originalPrice: Double): Double = {
    originalPrice
  }

  override def computeTax(currentPrice: Double): Double = {
    0.0
  }
}
