export default {
  async init({ commit }) {
    const product = await this.$repositories.productAdmin.all()
    commit(this.$constant.admin.MUTATION_ADMIN_PRODUCT_INIT, product.data)
  },
  async addProduct({ commit }, item) {
    this.$toast.global.loading()
    const res = await this.$repositories.productAdmin.create(item)
    const { status, data } = res
    if (status === 201) {
      this.$toast.global.success()
      commit(this.$constant.admin.MUTATION_ADMIN_PRODUCT_ADD, data)
    } else {
      // Handle error here
      this.$toast.global.error()
    }
  },
  async editProduct({ commit }, item) {},
  async deleteProduct({ commit }, item) {
    try {
      this.$toast.global.loading()
      const res = await this.$repositories.productAdmin.delete(item.id)
      const { status } = res
      if (parseInt(status) === 204) {
        this.$toast.global.success()
        commit(this.$constant.admin.MUTATION_ADMIN_PRODUCT_DELETE, item)
      } else {
        // Handle error here
        this.$toast.global.error()
      }
    } catch (e) {
      this.$toast.global.error()
    }
  },
}
