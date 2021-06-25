export default {
  async init({ commit }) {
    const payload = await this.$repositories.invoiceAdmin.all()
    commit(this.$constant.admin.MUTATION_ADMIN_INVOICE_INIT, payload)
  },
}
