export default {
  MUTATION_ADMIN_PRODUCT_INIT(state, product) {
    state.product = product
  },
  MUTATION_ADMIN_PRODUCT_ADD(state, product) {
    state.product.push(product)
  },
  editProduct(state, product) {
    const contentIndex = state.product.findIndex(
      (content) => parseInt(content.id) === parseInt(product.id)
    )
    state.product[contentIndex] = product
  },
  MUTATION_ADMIN_PRODUCT_DELETE(state, product) {
    const contentIndex = state.product.findIndex(
      (content) => content.id === parseInt(product.id)
    )
    state.product.splice(contentIndex, 1)
  },
}
