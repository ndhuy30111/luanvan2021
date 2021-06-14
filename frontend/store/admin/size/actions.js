export default {
  async addSize({ commit }, item) {
    this.$toast.global.loading()
    const res = await this.$repositories.sizeAdmin.create(item)
    const { status, data } = res
    if (status === 201) {
      this.$toast.global.success()
      // commit(this.$constant.admin.MUTATION_ADMIN_SIZE_ADD, data)
      console.log(data)
    } else {
      // Handle error here
      this.$toast.global.error()
    }
  },
  async updateAmount({ commit }, item) {
    this.$toast.global.loading()
    const res = await this.$repositories.couponAdmin.create(item)
    const { status, data } = res
    if (status === 200) {
      this.$toast.global.success()
      console.log(data)
    } else {
      // Handle error here
      this.$toast.global.error()
    }
  },
}
