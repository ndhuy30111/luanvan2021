const resource = '/invoice'
export default ($axios) => ({
  create(payload) {
    return $axios.post(`${resource}`, payload)
  },
  savePayment(payload) {
    return $axios.post('invoice/payment', payload)
  },
})
