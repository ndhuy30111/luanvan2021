export default {
  ACTIONS_CATEGORYS_GETALL(state, payload) {
    state.categorys = payload.categorys
    state.select = payload.select
  },
}
