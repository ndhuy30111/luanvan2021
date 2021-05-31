import constants from './constants'

export default {
  async register({ commit }, user) {
    const res = await this.$repositories.account.register(user)
    const { status, data } = res
    console.log(data)
    if (status === 201) {
      console.log(data)
      this.$router.push('login')
      commit(constants.ACTIONS_USER_REGISTER)
    }
  },
}
