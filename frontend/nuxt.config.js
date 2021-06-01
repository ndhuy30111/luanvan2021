export default {
  // Disable server-side rendering: https://go.nuxtjs.dev/ssr-mode
  ssr: false,

  // Target: https://go.nuxtjs.dev/config-target
  target: 'static',

  // Global page headers: https://go.nuxtjs.dev/config-head
  head: {
    title: 'Cửa hàng 7755',
    htmlAttrs: {
      lang: 'vi',
    },
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1' },
      { hid: 'description', name: 'description', content: '' },
    ],
    link: [{ rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' }],
  },

  // Global CSS: https://go.nuxtjs.dev/config-css
  css: [],
  // Loadding : https://nuxtjs.org/docs/2.x/features/loading
  loading: {
    continuous: true,
    color: 'red',
  },

  // Plugins to run before rendering page: https://go.nuxtjs.dev/config-plugins
  plugins: [
    { src: '~/plugins/vue-fb-customer-chat.js', ssr: false },
    { src: '~/plugins/vuelidate.js', ssr: false },
    { src: '~/plugins/axios.js', ssr: false },
    '~/plugins/auth.js',
    { src: '~/plugins/vue2-editor.js' },
    '~/plugins/repositories.js',
    '~/plugins/local.js',
    '~/plugins/lodash.js',
  ],

  // Auto import components: https://go.nuxtjs.dev/config-components
  components: true,

  // Modules for dev and build (recommended): https://go.nuxtjs.dev/config-modules
  buildModules: [
    // https://go.nuxtjs.dev/eslint
    '@nuxtjs/eslint-module',
    // Simple usage
    '@nuxtjs/vuetify',
  ],

  // Modules: https://go.nuxtjs.dev/config-modules
  modules: [
    // https://go.nuxtjs.dev/bootstrap
    'bootstrap-vue/nuxt',
    // https://go.nuxtjs.dev/axios
    '@nuxtjs/axios',
    // Auth
    '@nuxtjs/auth-next',
    '@nuxtjs/cloudinary',
  ],
  bootstrapVue: {
    icons: true,
  },
  // Axios module configuration: https://go.nuxtjs.dev/config-axios
  axios: {
    baseURL: 'http://localhost:8080/api',
  },
  cloudinary: {
    cloudName: 'df9s1orh9',
    apiKey: '965953611862293',
    apiSecret: 'aL2Ez1PgQZNuGXTCHW01V1-fcbA',
  },
  // Build Configuration: https://go.nuxtjs.dev/config-build
  build: {},
  // Auth Configuration https://auth.nuxtjs.org/guide/setup
  auth: {
    common: {
      Accept: 'application/json, text/plain, */*',
    },
    strategies: {
      local: {
        token: {
          property: 'token',
          type: 'Bearer',
          name: 'Authorization',
          maxAge: 1800,
        },
        user: {
          property: false,
          autoFetch: true,
        },
        endpoints: {
          login: { url: '/admin/login', method: 'post', propertName: 'token' },
          logout: false,
          user: { url: '/admin/user', method: 'get' },
        },
        autoLogout: true,
      },
    },
  },
}
