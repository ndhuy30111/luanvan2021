export default {
  setProduct(state, product) {
    state.product = product
  },
  addProduct(state, product) {
    state.product.push(product)
  },
  editProduct(state, product) {
    const contentIndex = state.color.findIndex(
      (content) => parseInt(content.id) === parseInt(product.id)
    )
    state.product[contentIndex] = product
  },
  deleteColor(state, product) {
    const contentIndex = state.color.findIndex(
      (content) => content.id === product.id
    )
    state.product.splice(contentIndex, 1)
  },
}
