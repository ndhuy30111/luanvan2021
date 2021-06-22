export default {
  MUTATIONS_CART_ADDTOCART(state, cartItem) {
    state.cart.push(cartItem)
  },
  MUTATIONS_SHOW_CART(state, payload) {
    state.cart = payload
  },
  MUTATIONS_REMOVE_CART(state) {
    state.cart = []
  },
  MUTATIONS_REMOVE_PRODUCTCART(state, indexRemove) {
    state.cart = state.cart.filter((item, index) => {
      return index !== indexRemove
    })
  },

  MUTATIONS_PLUS_ITEMCART(state, i) {
    state.cart.forEach((item, index) => {
      if (index === i) {
        item.quantity++
        // localStorage.setItem('cart', JSON.stringify(state.cart))
      }
    })
  },
  MUTATIONS_MINUS_ITEMCART(state, i) {
    state.cart.forEach((item, index) => {
      if (index === i) {
        if (item.quantity > 1) {
          item.quantity--
          // localStorage.setItem('cart', JSON.stringify(state.cart))
        }
      }
    })
  },
}
