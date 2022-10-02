package store.model.checkout
import store.model.items.{Item, LoyaltyActivate, LoyaltyDeactivate}

class CustomerCheckout(theCheckoutClass:SelfCheckout) extends State(theCheckoutClass){

  def UpdateStateOff(): Unit ={
    for ((key, values) <- theCheckoutClass.mapItemsToStore) {
      for (modifier <- values.lis) {
        modifier.state2 = new LoyaltyDeactivate(modifier)
      }
    }
  }

  def UpdateState(): Unit ={
    for ((key, values) <- theCheckoutClass.mapItemsToStore) {
      for (modifier <- values.lis) {
        modifier.state2 = new LoyaltyActivate(modifier)
      }
    }
  }
  override def addItemToStore(barcode: String, item: Item): Unit = {
    theCheckoutClass.mapItemsToStore += (barcode -> item)

  }

  override def numberPressed(number: Int): Unit = ???

  override def clearPressed(): Unit = ???

  override def enterPressed(): Unit = ???

  override def checkoutPressed(): Unit = ???

  override def cashPressed(): Unit = {
    theCheckoutClass.userCode = ""
    theCheckoutClass.storeUserCode = ""
    theCheckoutClass.listItemsToCart = List()
    UpdateStateOff()
    theCheckoutClass.state = new stateBehavior1(theCheckoutClass)

  }
  override def creditPressed(): Unit = {
    theCheckoutClass.userCode =""
    theCheckoutClass.storeUserCode =""
    theCheckoutClass.listItemsToCart = List()
    UpdateStateOff()
    theCheckoutClass.state = new stateBehavior1(theCheckoutClass)
  }

  override def loyaltyCardPressed(): Unit ={
    UpdateState()
  }

  override def displayString(): String = {

//    "cash or credit"
//    println(theCheckoutClass.userCode)
//    theCheckoutClass.userCode = "cash or credit"
    theCheckoutClass.userCode
  }


  override def itemsInCart(): List[Item] = {
    this.theCheckoutClass.listItemsToCart

  }

  override def subtotal(): Double = {
    var sub:Double = 0.0

    for(i<-theCheckoutClass.listItemsToCart){
      sub +=  i.price()
    }
    sub
  }

  override def tax(): Double = {
    var totalTax:Double = 0.0

    for(i<-theCheckoutClass.listItemsToCart){
      totalTax +=  i.tax()
    }
    totalTax
  }

  override def total(): Double = {
    subtotal() + tax()
  }


}
