export default {
  MUTATIONS_CART_ADDTOCART(state, cartItem) {
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
