export default {
  getFindProduct: (state) => (payload) => {
    return state.product.find((item) => item.id === parseInt(payload.id))
  },
}
