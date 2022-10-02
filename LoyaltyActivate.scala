package store.model.items

class LoyaltyActivate(ex:Modifier) extends StateL(ex){


  override def updatePrice(originalPrice: Double): Double = {
    var s = originalPrice * (ex.realPercentage/100)
    originalPrice - s
  }

  override def computeTax(currentPrice: Double): Double = {
    0.0
  }
}
