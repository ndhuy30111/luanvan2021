export default ($axios) => ({
  login(payload) {
    return $axios.get(`/login`, payload)
  },
  register(payload) {
    return $axios.post('/register', payload)
  },
  update(payload) {
    return $axios.put('/user', payload)
  },
})
