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
export const getters = {
  isAuthenticated(state) {
    return state.auth.loggedIn
  },

  loggedInUser(state) {
    return state.auth.user
  },
}
