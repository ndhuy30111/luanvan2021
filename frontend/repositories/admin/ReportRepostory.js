const resource = '/admin/report'
export default ($axios) => ({
  getReportInvoice() {
    return $axios.get(`${resource}/invoice`)
  },

  getReportInvoiceDate(payload) {
    return $axios.get(`${resource}/invoice/date`, payload)
  },
})
