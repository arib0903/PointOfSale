package store.model.checkout
import store.model.items._


abstract class State(ex:SelfCheckout){

  def addItemToStore(barcode: String, item: Item): Unit

  def numberPressed(number: Int)

  def clearPressed()

  def enterPressed()

  def checkoutPressed()

  def cashPressed()

  def creditPressed()

  def loyaltyCardPressed()

  def displayString(): String

  def itemsInCart(): List[Item]

  def subtotal(): Double

  def tax(): Double

  def total(): Double


}
