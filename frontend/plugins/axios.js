export default function ({ $axios, redirect, store }) {
  $axios.onError((error) => {
    return error
  })
  $axios.onRequest((config) => {
    // if (config.url === '/admin/category') {
    // }

    return config
  })
}
