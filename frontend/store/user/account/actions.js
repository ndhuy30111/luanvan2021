// import constants from './constants'

export default {
  async register({ commit }, user) {
    try {
      const res = await this.$repositories.account.register(user)
      const { status } = res
      if (status === 201) {
        this.$router.push('login')
      }
    } catch (error) {
      alert(error)
    }
  },
}
