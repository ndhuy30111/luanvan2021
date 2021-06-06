import constants from './constants'

export default {
  addProdcutToCart: (context, cartItem) => {
    context.commit(constants.MUTATIONS_CART_ADDTOCART, cartItem)
  },

  removeProductCart: (context, indexRemove) => {
    context.commit(constants.MUTATIONS_REMOVE_PRODUCTCART, indexRemove)
  },
  render: (context) => {
    context.commit(constants.MUTATIONS_LOAD_CART)
  },
}
