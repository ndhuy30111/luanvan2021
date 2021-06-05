export default {
  ACTIONS_CART_ADDTOCART(state, cartItem) {
    const index = state.cart.find((item) => {
      return (
        item.id === cartItem.id &&
        cartItem.color === item.color &&
        item.size === cartItem.size
      )
    })
    if (index != null) {
      index.quantity += cartItem.quantity
      return
    }
    state.cart.push(cartItem)
    localStorage.setItem('cart', JSON.stringify(state.cart))
  },
}
