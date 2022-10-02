package store.model.items
import store.model.items._

class SalesTax(var salesTaxPercent:Double) extends Modifier {
//  override var state2:StateL = new LoyaltyDeactivate(this)
//  override var realPercentage = 0.0

//  override def updateSuper(): Unit = {
//    super.updateSuper()
//  }

  override def updatePrice(originalPrice: Double): Double = {
    originalPrice

  }

  override def computeTax(currentPrice: Double): Double = {
    currentPrice * (salesTaxPercent/100)
  }
}
