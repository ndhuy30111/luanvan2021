import constants from './constants'

export default {
  setProdcut: (context, cartItem) => {
    context.commit(constants.MUTATIONS_CHECKOUT_SETPRODUCT, cartItem)
  },

  removeProduct: (context, indexRemove) => {
    context.commit(constants.MUTATIONS_REMOVE_PRODUCT_CHECKOUT, indexRemove)
  },
}
