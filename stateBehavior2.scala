package store.model.checkout
import store.model.items._

class stateBehavior2(theCheckoutClass:SelfCheckout,storedKey:String)extends State(theCheckoutClass){

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
    theCheckoutClass.storeUserCode = ""
    theCheckoutClass.userCode = ""
    theCheckoutClass.userCode += number
    theCheckoutClass.storeUserCode +=number
    theCheckoutClass.state = new stateBehavior3(theCheckoutClass)

  }

  override def clearPressed(): Unit = {
    theCheckoutClass.userCode = ""
    theCheckoutClass.storeUserCode = ""
    theCheckoutClass.state = new stateBehavior3(theCheckoutClass)
  }

  override def enterPressed(): Unit = {
    var err = new Item("error",0.0)
    this.theCheckoutClass.listItemsToCart= theCheckoutClass.listItemsToCart :+ theCheckoutClass.mapItemsToStore.getOrElse(storedKey,err)
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
