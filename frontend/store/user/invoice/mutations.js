export default {
  MUTATIONS_INVOICE_CREATE(state, payload) {
    state.billCode = payload
  },
  MUTATIONS_INVOICE_GET(state, payload) {
    state.invoice = payload
  },
  MUTATION_INVOICE_NOT(state, payload) {
    state.not = payload.data
  },
  MUTATION_INVOICE_ACCURACY(state, payload) {
    state.accuracy = payload.data
  },
  MUTATION_INVOICE_TRANSPORT(state, payload) {
    state.transport = payload.data
  },
  MUTATION_INVOICE_COMPLETE(state, payload) {
    state.complete = payload.data
  },
  MUTATION_INVOICE_CANCEL(state, payload) {
    state.cancel = payload.data
  },
}
