export default {
  init(state, payload) {
    state.contents = payload.category
    state.select = payload.select
  },
  setContent(state, payload) {
    state.contents = payload
  },
  addContent(state, payload) {
    state.contents.push(payload)
  },
  editContent(state, payload) {
    const contentIndex = state.contents.findIndex(
      (content) => content.id === payload.id
    )
    state.contents[contentIndex] = payload
  },
  deleteContent(state, payload) {
    const contentIndex = state.contents.findIndex(
      (content) => content.id === payload.id
    )
    state.contents.splice(contentIndex, 1)
  },
}
