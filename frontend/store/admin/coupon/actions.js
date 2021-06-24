export default {
  async init({ commit }) {
    const coupon = await this.$repositories.couponAdmin.all()
    commit(this.$constant.admin.MUTATION_ADMIN_COUPON_INIT, coupon.data)
  },
}
