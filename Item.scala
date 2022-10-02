package store.model.items

import store.model.items._

class Item(var theDescription: String, var basePrice: Double) {
  var lis: List[Modifier] = List()

  // TODO: Complete this class according to the features listed in the HW document

  def description(): String = {
    theDescription
  }

  def price(): Double = {
    var y = basePrice
    for(stuff <- lis){
//      print(i.updatePrice(basePrice))
      y =  stuff.updatePrice(y)
    }
    y
//    basePrice
  }

  def setBasePrice(x:Double): Unit = {
    this.basePrice = x
  }

  def addModifier(modifier: Modifier):Unit = {

    lis =  lis :+ modifier
  }

  def tax(): Double ={
    var x = 0.0
    var discountedPrice = price()
    for(stuff <- lis){
       x +=  stuff.computeTax(discountedPrice)
    }
    x
  }

}
