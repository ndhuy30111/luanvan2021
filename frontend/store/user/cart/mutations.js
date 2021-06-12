export default {
  MUTATIONS_CART_ADDTOCART(state, cartItem) {
    const cart = state.cart.find(
      (content) =>
        content.id === parseInt(cartItem.id) &&
        content.color === cartItem.color &&
        content.size === cartItem.size
    )
    this.$toast.global.cart()
    if (!cart) {
      state.cart.push(cartItem)
    } else {
      cart.quantity += cartItem.quantity
    }
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
  MUTATIONS_PLUS_ITEMCART(state, i) {
    state.cart.forEach((item, index) => {
      if (index === i) {
        item.quantity++
        localStorage.setItem('cart', JSON.stringify(state.cart))
      }
    })
  },
  MUTATIONS_MINUS_ITEMCART(state, i) {
    state.cart.forEach((item, index) => {
      if (index === i) {
        if (item.quantity > 1) {
          item.quantity--
          localStorage.setItem('cart', JSON.stringify(state.cart))
        }
      }
    })
  },
}
