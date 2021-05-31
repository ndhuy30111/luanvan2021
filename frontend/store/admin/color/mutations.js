export default {
  setColor(state, color) {
    state.color = color
  },
  addColor(state, color) {
    state.color.push(color)
  },
  editColor(state, color) {
    const contentIndex = state.color.findIndex(
      (content) => content.id === color.id
    )
    state.contents[contentIndex] = color
  },
  deleteColor(state, color) {
    const contentIndex = state.color.findIndex(
      (content) => content.id === color.id
    )
    state.color.splice(contentIndex, 1)
  },
}
