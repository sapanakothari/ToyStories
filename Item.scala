case class Item(name:String, unitPrice:Double){
	def fullPrice(qty:Int)=unitPrice*qty

	def price(qty:Int):Double={
		Offer.get(name) match{
			case Some(offer) if qty>=offer.minQty=>
				(qty/offer.minQty)*offer.price(unitPrice) + price(qty%offer.minQty)
			case _ => fullPrice(qty)
		}
	}
}

object Item{
	val inventory = Set(Item("Dove",30),Item("Axe",100))
	def get(name:String) = inventory.collectFirst{case i@Item(`name`,_)=>i}
}
