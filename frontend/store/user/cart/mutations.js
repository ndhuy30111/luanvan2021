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
  MUTATIONS_REMOVE_PRODUCTCART(state, payload) {
    const contentIndex = state.cart.findIndex(
      (items) => parseInt(items.idCart) === parseInt(payload.idCart)
    )
    state.cart = state.cart.filter((item, index) => {
      return index !== contentIndex
    })
  },
  MUTATIONS_PLUS_ITEMCART(state, payload) {
    const contentIndex = state.cart.findIndex(
      (items) => parseInt(items.idCart) === parseInt(payload.idCart)
    )
    state.cart.forEach((item, index) => {
      if (index === contentIndex) {
        item.quantity++
      }
    })
  },
  MUTATIONS_MINUS_ITEMCART(state, payload) {
    const contentIndex = state.cart.findIndex(
      (items) => parseInt(items.idCart) === parseInt(payload.idCart)
    )
    state.cart.forEach((item, index) => {
      if (index === contentIndex) {
        if (item.quantity > 1) {
          item.quantity--
        }
      }
    })
  },
}
