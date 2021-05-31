export default ($axios) => ({
  login(payload) {
    return $axios.get(`/login`, payload)
  },
  register(payload) {
    return $axios.post('/register', payload)
  },
})
