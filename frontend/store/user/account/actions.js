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
  async loginFacebook({ commit }, hash) {
    try {
      const stats = await hash.indexOf('=')
      const end = await hash.indexOf('&')
      const token = await hash.slice(stats + 1, end)
      const url = `https://graph.facebook.com/v6.0/me?fields=about,name,picture{url},email`
      this.$axios.setToken(token, 'Bearer')
      const user = await this.$axios.$post(url, null)
      this.$axios.setToken(null)
      this.$auth.loginWith('local2', {
        data: {
          email: user.email,
          name: user.password,
          id: user.id,
        },
      })
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
