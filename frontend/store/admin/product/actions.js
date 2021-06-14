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
  async updateProduct({ commit }, item) {
    try {
      this.$toast.global.loading()
      const product = {
        name: item.name,
        price: item.price,
        infoSmall: item.infoSmall,
        info: item.info,
      }
      const res = await this.$repositories.productAdmin.update(item.id, product)
      const { status } = res
      if (parseInt(status) === 200) {
        this.$toast.global.success()
        commit(this.$constant.admin.MUTATION_ADMIN_PRODUCT_UPDATE, item)
      } else {
        // Handle error here
        this.$toast.global.error()
      }
    } catch (e) {
      this.$toast.global.error()
    }
  },
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
