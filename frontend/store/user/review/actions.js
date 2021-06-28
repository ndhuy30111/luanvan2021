// import constants from './constants'

export default {
  async postCommit({ commit }, payload) {
    try {
      const res = await this.$repositories.reviewRepostory.post(payload)
      const { status } = res
      if (status === 201) {
        this.$toast.global.success()
      }
    } catch (error) {
      alert(error)
    }
  },
}
