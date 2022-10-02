package store.model.items
import store.model.checkout.SelfCheckout
import store.model.items._

abstract class Modifier() {

  var state2: StateL = new LoyaltyDeactivate(this)
  var realPercentage = 0.0

//  def returnRealP():Double ={
//    realPercentage
//  }
//  def updateSuper(): Unit = {
//    state2 = new LoyaltyActivate(this)
//  }
//  def updateSuperOff(): Unit = {
//    state2 = new LoyaltyDeactivate(this)
//  }

//  def returnState(): StateL ={
//    state2
//  }

  def updatePrice(originalPrice:Double): Double

  def computeTax(currentPrice:Double): Double

}
