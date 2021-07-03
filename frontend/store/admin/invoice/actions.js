export default {
  async init({ commit }) {
    const payload = await this.$repositories.invoiceAdmin.all()
    commit(this.$constant.admin.MUTATION_ADMIN_INVOICE_INIT, payload)
  },
  async notData({ commit }) {
    const payload = await this.$repositories.invoiceAdmin.allNot()
    return payload.data
  },
  async accuracyData({ commit }) {
    const payload = await this.$repositories.invoiceAdmin.allAccuracy()
    return payload.data
  },

  async transportData({ commit }) {
    const payload = await this.$repositories.invoiceAdmin.allTransport()
    return payload.data
  },
  async completeData({ commit }) {
    const payload = await this.$repositories.invoiceAdmin.allComplete()
    return payload.data
  },
  async cancelData({ commit }) {
    const payload = await this.$repositories.invoiceAdmin.allCancel()
    return payload.data
  },
  async submit({ commit }, payload) {
    this.$toast.global.loading()
    try {
      const res = await this.$repositories.invoiceAdmin.status(payload.id)
      const { status } = res
      if (status === 200) {
        this.$toast.global.success()
        return true
      }
    } catch (e) {
      return false
    }
  },
  async del({ commit }, payload) {
    this.$toast.global.loading()
    try {
      const res = await this.$repositories.invoiceAdmin.del(payload.id)
      const { status } = res
      if (status === 200) {
        this.$toast.global.success()
        return true
      }
    } catch (e) {
      return false
    }
  },
  async paid({ commit }, payload) {
    this.$toast.global.loading()
    try {
      const res = await this.$repositories.invoiceAdmin.paid(payload.id)
      const { status } = res
      if (status === 200) {
        this.$toast.global.success()
        return true
      }
    } catch (e) {
      return false
    }
  },
}
