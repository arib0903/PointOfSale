package store.model.checkout
import store.model.items.{Item, LoyaltyActivate}

class stateBehavior3(theCheckoutClass:SelfCheckout) extends State(theCheckoutClass){

  def UpdateState(): Unit ={
    for((key,values) <-theCheckoutClass.mapItemsToStore){
      for(modifier <- values.lis){
        modifier.state2 = new LoyaltyActivate(modifier)
      }
    }
  }

  override def addItemToStore(barcode: String, item: Item): Unit = {
    theCheckoutClass.mapItemsToStore += (barcode -> item)

  }

  override def numberPressed(number: Int): Unit = {

    theCheckoutClass.userCode += number
    theCheckoutClass.storeUserCode += number

  }

  override def clearPressed(): Unit = {

    theCheckoutClass.storeUserCode = ""
    theCheckoutClass.userCode = ""
  }

  //Take the ex.mapItemsToStore.getOrElse(y,err) and store as a constructor then use the values of that and store it back into the list

  override def enterPressed(): Unit = {
    var err = new Item("error",0.0)
    var storedKey =  theCheckoutClass.storeUserCode
    theCheckoutClass.state = new stateBehavior2(theCheckoutClass,storedKey)
    this.theCheckoutClass.listItemsToCart= theCheckoutClass.listItemsToCart :+ theCheckoutClass.mapItemsToStore.getOrElse(storedKey,err)
    clearPressed()
  }


  override def checkoutPressed(): Unit = {
    theCheckoutClass.userCode = "cash or credit"
    theCheckoutClass.storeUserCode =""

    theCheckoutClass.state = new CustomerCheckout(theCheckoutClass)
  }

  override def cashPressed(): Unit = {}

  override def creditPressed(): Unit = {}

  override def loyaltyCardPressed(): Unit = {
    UpdateState()
  }

  override def displayString(): String = {
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
