export default {
  async init({ commit }) {
    const category = await this.$repositories.categoryAdmin.all()
    const select = await this.$repositories.categoryAdmin.show('categorynull')
    const payload = {
      category: category.data,
      select: select.data,
    }
    commit('init', payload)
  },
  async addContent({ commit }, item) {
    const newCategory = {
      name: item.name,
      sort: item.sort,
      category: item.category,
    }
    const res = await this.$repositories.categoryAdmin.create(newCategory)
    const { status, data } = res
    if (status === 201) {
      commit('addContent', data)
    } else {
      // Handle error here
    }
  },
  async editContent({ commit }, item) {
    const category = {
      name: item.name,
      sort: item.sort,
      category: item.category,
    }
    const res = await this.$repositories.categoryAdmin.update(item.id, category)
    const { status, data } = res
    if (status === 200) {
      commit('editContent', data)
    } else {
      // Handle error here
    }
  },
  async deleteContent({ commit }, item) {
    const res = await this.$repositories.categoryAdmin.delete(item.id)
    const { status } = res
    if (status === 204) {
      commit('deleteContent', item)
    } else {
      alert('Không thay đổi, vui lòng kiểm tra lại')
    }
  },
}
