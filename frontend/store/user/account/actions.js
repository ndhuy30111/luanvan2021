// import constants from './constants'

export default {
  async register({ commit }, user) {
    try {
      const res = await this.$repositories.account.register(user)
      const { status } = res
      if (status === 201) {
        this.$router.push({ name: 'login' })
      }
    } catch (error) {
      alert(error)
    }
  },
  async update({ commit }, user) {
    try {
      const res = await this.$repositories.account.update(user)
      const { status } = res
      if (status === 200) {
        this.$toast.global.success()
      }
    } catch (error) {
      alert(error)
    }
  },
}
