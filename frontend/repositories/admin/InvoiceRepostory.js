const resource = '/admin/invoice'
export default ($axios) => ({
  all() {
    return $axios.get(`${resource}`)
  },

  show(id) {
    return $axios.get(`${resource}/${id}`)
  },

  create(payload) {
    return $axios.post(`${resource}`, payload)
  },

  update(id, payload) {
    return $axios.put(`${resource}/${id}`, payload)
  },
})
