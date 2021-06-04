import constants from './constants'

export default {
  async getAll({ commit }) {
    const categorys = await this.$repositories.categoryUser.all()
    const payload = {
      categorys: categorys.data,
    }
    commit(constants.ACTIONS_CATEGORYS_GETALL, payload)
  },
}
