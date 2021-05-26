export default {
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
