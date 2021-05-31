export default {
  async init({ commit }) {
    const category = await this.$axios.$get('/admin/category')
    commit('setContent', category)
  },
  async add({ commit }, item) {
    const newCategory = {
      name: item.name,
      sort: item.sort,
      category: item.category,
    }
    await this.$axios
      .$post('/admin/category/', newCategory)
      .then((data) => {
        commit('addContent', data)
      })
      .catch((error) => {
        console.log(error)
      })
  },
  async edit({ commit }, item) {
    const category = {
      name: item.name,
      sort: item.sort,
      category: item.category,
    }
    await this.$axios
      .$put('/admin/category/' + item.id, category)
      .then((data) => {
        commit('editContent', data)
      })
      .catch((error) => {
        console.log(error)
      })
  },
  async delete({ commit }, item) {
    await this.$axios
      .$delete('/admin/category/' + item.id)
      .then(() => {
        commit('deleteContent', item)
      })
      .catch((eror) => {
        alert('Không thay đổi, vui lòng kiểm tra lại')
      })
  },
}