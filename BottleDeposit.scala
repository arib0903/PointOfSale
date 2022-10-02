package store.model.items

class BottleDeposit(depositToBeCharged:Double) extends Modifier {
//  override var realPercentage = depositToBeCharged
//  override var state2 = new LoyaltyDeactivate(this)
//override def returnRealP():Double ={
//  0.0
//}
//  override def updateSuper(): Unit = {
//    super.updateSuper()
//  }
  override def updatePrice(originalPrice: Double): Double = {
    originalPrice
  }

  override def computeTax(currentPrice: Double): Double = {
    this.depositToBeCharged
  }
}
