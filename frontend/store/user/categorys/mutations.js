export default {
  MUTATIONS_CATEGORYS_GETALL(state, payload) {
    state.categorys = payload.categorys
    state.select = payload.select
  },

  removeProductCart(state, indexremove) {
    state.cart = state.cart.filter((item, index) => {
      return index !== indexremove
    })
  },
}
