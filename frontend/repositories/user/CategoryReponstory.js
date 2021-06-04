export default ($axios) => ({
  all() {
    return $axios.get(`/category`)
  },
})
