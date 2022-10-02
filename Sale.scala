package store.model.items
import store.model.items._

class Sale(var percentageOfSale:Double) extends Modifier {
//  override var state2:StateL = new LoyaltyDeactivate(this)
//  override var realPercentage = 0.0
//  override def returnRealP():Double ={
//  0.0
//}
//  override def updateSuper(): Unit = {
//    super.updateSuper()
//  }

  override def computeTax(currentPrice: Double): Double = {
    0.0
  }

  override def updatePrice(originalPrice: Double): Double = {
    var s = originalPrice * (this.percentageOfSale/100)
    originalPrice - s
  }

}
