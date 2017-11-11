# ToyStories


To test load Offer.scala, Item.scala and Cart.scala

For story1 - 
 1.Ensure in Offer.scala below is uncommented, and other offers declaration are commented.
      val offers:Set[Offer] = Set()
 2. Ensure in Cart.scala below is commented
      val offers:Set[CartOffer] = Set(CartOffer(fiveKPlus,20))
  
  
 For story2 - 
  1.Ensure in Offer.scala below is uncommented, and other offers declaration are commented.
      val offers = Set(Offer("Dove",3,twoPlusOne))
  2. Ensure in Cart.scala below is commented
      val offers:Set[CartOffer] = Set(CartOffer(fiveKPlus,20))
      
      
  For story3 - 
  1.Ensure in Offer.scala below is uncommented, and other offers declaration are commented.
      val offers = Set(Offer("Dove",2,buyOneHalfOnNext))
  2. Ensure in Cart.scala below is commented
      val offers:Set[CartOffer] = Set(CartOffer(fiveKPlus,20))
      
      
  For story4 -
 1.Ensure in Offer.scala below is uncommented, and other offers declaration are commented.
      val offers:Set[Offer] = Set()
 2. Ensure in Cart.scala below is uncommented
      val offers:Set[CartOffer] = Set(CartOffer(fiveKPlus,20))
      
      
      
      
      To test -
      val cart = new Cart()
      cart.add("Dove",4)
      cart.add("Axe",2)
      cart.items // to see contents of cart
      cart.discount //to see cart level discount
      cart.checkout
      
