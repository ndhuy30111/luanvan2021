export default {
  async init({ commit }) {
    const color = await this.$repositories.colorAdmin.all()
    commit(this.$constant.admin.MUTATION_ADMIN_COLOR_INIT, color.data)
  },
  async addColor({ commit }, item) {
    this.$toast.global.loading()
    const res = await this.$repositories.colorAdmin.create(item)
    const { status, data } = res
    if (status === 201) {
      this.$toast.global.success()
      commit(this.$constant.admin.MUTATION_ADMIN_COLOR_ADD, data)
    } else {
      // Handle error here
      this.$toast.global.error()
    }
  },
  async updateColor({ commit }, item) {
    this.$toast.global.loading()
    const res = await this.$repositories.colorAdmin.update(item.id, item)
    const { status, data } = res
    if (status === 200) {
      this.$toast.global.success()
      commit(this.$constant.admin.MUTATION_ADMIN_COLOR_UPDATE, data)
    } else {
      // Handle error here
      this.$toast.global.error()
    }
  },
  async deleteColor({ commit }, item) {
    this.$toast.global.loading()
    const res = await this.$repositories.colorAdmin.delete(item.id)
    const { status } = res
    if (status === 204) {
      this.$toast.global.success()
      commit(this.$constant.admin.MUTATION_ADMIN_COLOR_DELETE, item)
    } else {
      // Handle error here
      this.$toast.global.error()
    }
  },
}
