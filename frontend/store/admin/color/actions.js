export default {
  async init({ commit }) {
    const color = await this.$repositories.colorAdmin.all()
    commit('setColor', color.data)
  },
  async addColor({ commit }, item) {
    const res = await this.$repositories.colorAdmin.create(item)
    const { status, data } = res
    if (status === 201) {
      commit('addColor', data)
    } else {
      // Handle error here
    }
  },
  async editContent({ commit }, item) {},
  async deleteContent({ commit }, item) {},
}
