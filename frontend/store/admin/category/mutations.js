export default {
  init(state, payload) {
    state.contents = payload.category
    state.select = payload.select
  },
  setContent(state, category) {
    state.contents = category
  },
  addContent(state, category) {
    state.contents.push(category)
  },
  editContent(state, category) {
    const contentIndex = state.contents.findIndex(
      (content) => content.id === category.id
    )
    state.contents[contentIndex] = category
  },
  deleteContent(state, category) {
    const contentIndex = state.contents.findIndex(
      (content) => content.id === category.id
    )
    state.contents.splice(contentIndex, 1)
  },
}
