const resource = '/review'
export default ($axios) => ({
  post(payload) {
    return $axios.post(`${resource}`, payload)
  },
})
