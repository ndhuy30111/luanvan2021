// import constants from './constants'

export default {
  async register({ commit }, user) {
    try {
      const res = await this.$repositories.account.register(user)
      const { status } = res
      if (status === 201) {
        alert('Đăng ký thành công')
        this.$router.push('login')
      }
    } catch (error) {
      alert('Trung ten đang nhap')
    }
  },
}
