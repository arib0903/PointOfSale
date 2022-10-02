package store.model.checkout

import store.model.items._

class SelfCheckout {

  var userCode = ""
  var storeUserCode = ""
  var mapItemsToStore: Map[String,Item] = Map()
  var listItemsToCart: List[Item] = List()
  var sub = 0.0

  var state: State = new stateBehavior1(this)


  def addItemToStore(barcode: String, item: Item): Unit = {
    // This method adds an item to your store's checkout system. It does not add an item to the customer's cart
    this.state.addItemToStore(barcode,item)
    // TODO
  }

  def numberPressed(number: Int): Unit = {
    // TODO
    this.state.numberPressed(number)
  }


  def clearPressed(): Unit = {
    // TODO
    this.state.clearPressed()
  }


  def enterPressed():Unit = {
    this.state.enterPressed()

    // TODO
  }

  def checkoutPressed(): Unit = {
    this.state.checkoutPressed()
    // TODO
  }

  def cashPressed(): Unit = {
    this.state.cashPressed()
  }

  def creditPressed(): Unit = {
    this.state.creditPressed()
  }

  def loyaltyCardPressed(): Unit = {
    // TODO
    this.state.loyaltyCardPressed()
  }

  def displayString(): String = {
    this.state.displayString()
    // TODO
  }

  def itemsInCart(): List[Item] = {
    this.state.itemsInCart()
  }

  def subtotal(): Double = {
    this.state.subtotal()
  }

  def tax(): Double = {
    this.state.tax()
  }

  def total(): Double = {
    this.state.total()
  }

  def prepareStore(): Unit = {
    // Similar to openMap in the Pale Blue Dot assignment, this method is not required and is
    // meant to help you run manual tests.
    //
    // This method is called by the GUI during setup. Use this method to prepare your
    // items and call addItemToStore to add their barcodes. Also add any sales/tax/etc to your

    //
    // This method will not be called during testing and you should not call it in your tests.
    // Each test must setup its own items to ensure compatibility in AutoLab. However, you can
    // write a similar method in your Test Suite classes.

    // Example usage:
    val Cheese = new Item("cheese", 5.0)
    val Lsale: LoyaltySale = new LoyaltySale(50.0)
    val s: Sale = new Sale(20.0)
    this.addItemToStore("472", Cheese)
    Cheese.addModifier(Lsale)


    val Banana = new Item("banana", 2.0)
    val Lsale2: LoyaltySale = new LoyaltySale(10.0)

    this.addItemToStore("125", Banana)
    Banana.addModifier(Lsale2)


    val rubiksCube = new Item("rubiksCube", 24.0)
    val Lsale3: LoyaltySale = new LoyaltySale(99.0)

    this.addItemToStore("782427", rubiksCube)
    rubiksCube.addModifier(Lsale3)




  }
}
