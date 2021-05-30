export default {
  async register(state, form) {
    await this.$axios
      .$post('/register', form)
      .then((data) => {
        this.$router.push('login')
      })
      .catch((error) => {
        if (error.response.data.message === 'trung userName')
          alert('đăng ký thất bạn vui lòng bạn kiểm tra lại username vì trùng')
      })
  },
}
