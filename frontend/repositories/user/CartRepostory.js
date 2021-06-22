const resource = '/cart'
export default ($axios) => ({
  showcart() {
    return $axios.get(`${resource}`)
  },
  addcart(payload) {
    return $axios.post(`${resource}`, payload)
  },
})
