export default {
  async init({ commit }) {
    const color = await this.$repositories.colorAdmin.all()
    commit('setColor', color.data)
  },
  async addProduct({ commit }, item) {
    const res = await this.$repositories.productAdmin.create(item)
    const { status, data } = res
    if (status === 201) {
      commit('addProduct', data)
    } else {
      // Handle error here
    }
  },
  async editProduct({ commit }, item) {},
  async deleteProduct({ commit }, item) {},
}
