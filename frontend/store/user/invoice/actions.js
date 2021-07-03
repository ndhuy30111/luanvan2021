import constants from './constants'

export default {
  async createIvoice({ commit }, invoice) {
    try {
      const res = await this.$repositories.invoiceUser.create(invoice)
      const { status, data } = res
      if (status === 201) {
        commit(constants.MUTATIONS_INVOICE_CREATE, data.billCode)
      }
    } catch (e) {
      return false
    }
  },
  async savePayment({ commit }, payload) {
    const data = {
      billCode: payload,
    }
    try {
      const res = await this.$repositories.invoiceUser.savePayment(data)
      const { status } = res
      if (status === 200) {
        this.$toast.global.success()
        this.$router.push({ name: 'index' })
      }
    } catch (e) {
      return false
    }
  },
}
