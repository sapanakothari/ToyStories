case class CartItem(item:Item,qty:Int,totalPrice:Double,discount:Double)

class Cart(){
	var items:List[CartItem] = List()

	def add(name:String,qty:Int):Boolean ={
		val item = Item.get(name).get
		val actualPrice = item.price(qty)
		val discount = item.fullPrice(qty) - actualPrice
		items = CartItem(item,qty,actualPrice,discount)::items
		true
	}

	def price = items.map(_.totalPrice).sum
}
