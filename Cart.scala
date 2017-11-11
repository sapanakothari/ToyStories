class Cart{
	case class CartItem(item:Item,qty:Int,totalPrice:Double,discount:Double)
	var items:List[CartItem] = List()
	private var cartDiscount:Double=1

	def price = items.map(_.totalPrice).sum

	def applyOffer(){
		val offers = CartOffer.get(this)
		for(offer<-offers){
			val offerDiscount = (100-offer.discount)/100
			if(offerDiscount !=cartDiscount){
				cartDiscount = offerDiscount 
				refresh	
			} 
		}
	}

	def refresh(){
		var cartItems:List[CartItem] = for(cartItem <- items) yield addItem(cartItem.item.name,cartItem.qty)
		items = cartItems							
	}


	def add(name:String,qty:Int):Boolean ={
		if(!Item.get(name).isDefined)
			return false
		items=addItem(name,qty)::items
		applyOffer
		true
	}

	def addItem(name:String,qty:Int):CartItem={
		val item = Item.get(name).get
		val actualPrice = item.price(qty)*cartDiscount
		val discount = item.fullPrice(qty) - actualPrice
		CartItem(item,qty,actualPrice,discount)
	}

	def checkout={
		println(items)
		println(price)
	}

	def discount = 100-(cartDiscount*100)
}

case class CartOffer(val criteria:(Cart)=>Boolean, val discount:Double)

object CartOffer{
	def fiveKPlus(cart:Cart)=cart.price>=500 
	val offers:Set[CartOffer] = Set()
	//val offers:Set[CartOffer] = Set(CartOffer(fiveKPlus,20))	
	def get(cart:Cart) = offers.filter(_.criteria(cart))
}

