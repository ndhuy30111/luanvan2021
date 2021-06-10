import constants from './constants'

export default {
  async getAll({ commit }) {
    const listproduct = await this.$repositories.productUser.all()
    const payload = {
      listproduct: listproduct.data,
    }
    commit(constants.MUTATIONS_PRODUCT_GETALL, payload)
  },
}
