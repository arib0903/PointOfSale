package store.model.items
import store.model.checkout._

class LoyaltySale(Percentage:Double) extends Modifier {
//  override def returnRealP():Double ={
//    realPercentage = Percentage
//    realPercentage
//  }
  realPercentage = Percentage
//  override def updateSuper(): Unit = {
//    super.updateSuper()
//  }
//   override var state2 = new LoyaltyDeactivate(this)

//  var superState = this.state2
  override def updatePrice(originalPrice: Double): Double = {
    this.state2.updatePrice(originalPrice)
  }

  override def computeTax(currentPrice: Double): Double = {
    this.state2.computeTax(currentPrice)
  }


}
