export const state = () => ({
  counter: 0,
  authenticated: '',
})

export const mutations = {
  increment(state) {
    state.counter++
  },
  authName(state, parama) {
    state.authenticated = parama
  },
}
