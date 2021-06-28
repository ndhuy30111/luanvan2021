export default {
  async init({ commit }) {
    const comment = await this.$repositories.reviewAdmin.all()
    commit(this.$constant.admin.MUTATION_ADMIN_REVIEW_INIT, comment)
  },
}
