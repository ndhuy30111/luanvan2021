export default {
  async init({ commit }) {
    const invoiceAmout = await this.$repositories.reportAdmin.getReportInvoice()
    commit(this.$constant.admin.MUTATION_ADMIN_REPORT_INIT, invoiceAmout.data)
  },
}
