export default {
  MUTATIONS_CART_ADDTOCART(state, cartItem) {
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

  MUTATIONS_REMOVE_PRODUCTCART(state, indexRemove) {
    state.cart = state.cart.filter((item, index) => {
      return index !== indexRemove
    })
    localStorage.setItem('cart', JSON.stringify(state.cart))
  },

  MUTATIONS_LOAD_CART(state) {
    const cart = localStorage.getItem('cart')
    if (cart != null) {
      state.cart = JSON.parse(cart)
    }
  },
}
