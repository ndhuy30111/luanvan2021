export default {
  async addDetailsproduct({ commit }, item) {
    this.$toast.global.loading()
    const res = await this.$repositories.detailsproductAdmin.create(item)
    const { status, data } = res
    if (status === 201) {
      this.$toast.global.success()
      console.log(data)
    } else {
      // Handle error here
      this.$toast.global.error()
    }
  },
}
