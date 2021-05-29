export default function ({ $axios, redirect, store }) {
  $axios.onError(() => {})
  $axios.onRequest((config) => {
    // if (config.url === '/admin/category') {
    // }
    return config
  })
}
