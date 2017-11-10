case class Offer(val name:String,val minQty:Int, val price:(Double)=>Double)

object Offer{
def price(formula:(Double)=>Double)(unitPrice:Double) = formula(unitPrice)
val twoPlusOne = price(x=>x*2)_
val buyOneHalfOnNext=price(x=>x*1.5)_

val offers:Set[Offer] = Set()
//val offers = Set(Offer("Dove",3,twoPlusOne))	
//val offers = Set(Offer("Dove",2,buyOneHalfOnNext))	

def get(name:String) = offers.collectFirst{case o@Offer(`name`,_,_)=>o}
}